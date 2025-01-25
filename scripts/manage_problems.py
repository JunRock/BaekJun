import os
import requests
import json

SOLVED_AC_API_URL = "https://solved.ac/api/v3/problem/show"

def get_problem_info(problem_id):
    response = requests.get(f"{SOLVED_AC_API_URL}?problemId={problem_id}")
    if response.status_code != 200:
        raise Exception(f"Failed to fetch problem info for problem ID {problem_id}: {response.status_code}")

    data = response.json()
    levels = {
        0: "Unrated",
        1: "Bronze 5", 2: "Bronze 4", 3: "Bronze 3", 4: "Bronze 2", 5: "Bronze 1",
        6: "Silver 5", 7: "Silver 4", 8: "Silver 3", 9: "Silver 2", 10: "Silver 1",
        11: "Gold 5", 12: "Gold 4", 13: "Gold 3", 14: "Gold 2", 15: "Gold 1",
        16: "Platinum 5", 17: "Platinum 4", 18: "Platinum 3", 19: "Platinum 2", 20: "Platinum 1"
    }

    return {
        "problem_id": data["problemId"],
        "problem_name": data["titleKo"],
        "problem_level": levels[data["level"]],
        "problem_tags": [tag["key"] for tag in data["tags"]],
        "problem_link": f"https://www.acmicpc.net/problem/{data['problemId']}"
    }


def generate_readme(base_dir, problems):
    readme_content = ["# Baekjoon Problem Solving\n", "## Solved Problems by Category\n"]

    categories = {}
    for problem in problems:
        category = problem["problem_tags"][0].capitalize() if problem["problem_tags"] else "Uncategorized"
        if category not in categories:
            categories[category] = []
        categories[category].append(problem)

    for category, problems in categories.items():
        readme_content.append(f"<details>\n<summary>{category}</summary>\n\n")
        readme_content.append("| Problem ID | Title | Difficulty | Tags | Link | Code |\n")
        readme_content.append("|------------|-------|------------|------|------|------|\n")
        for problem in problems:
            code_link = f"src/{category.lower()}/boj{problem['problem_id']}/Main.java"
            readme_content.append(
                f"| {problem['problem_id']} | {problem['problem_name']} | {problem['problem_level']} | {', '.join(problem['problem_tags'])} | "
                f"[Problem Link]({problem['problem_link']}) | [Code]({code_link}) |\n"
            )
        readme_content.append("\n</details>\n")

    with open("README.md", "w", encoding="utf-8") as f:
        f.writelines(readme_content)


def main():
    commit_message = os.getenv("COMMIT_MESSAGE")
    if not commit_message or not commit_message.startswith("feat : solve"):
        print("No valid commit message found.")
        return

    try:
        problem_id = commit_message.split(" ")[-1]
    except IndexError:
        raise Exception("Failed to extract problem ID from commit message.")

    problem_info = get_problem_info(problem_id)

    problems_file = "problems.json"
    if os.path.exists(problems_file):
        with open(problems_file, "r", encoding="utf-8") as f:
            problems = json.load(f)
    else:
        problems = []

    problems.append(problem_info)

    with open(problems_file, "w", encoding="utf-8") as f:
        json.dump(problems, f, indent=4)

    generate_readme("src", problems)


if __name__ == "__main__":
    main()
