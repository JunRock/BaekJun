import requests
import json
import datetime
import sys
import os

if len(sys.argv) == 1:
    print("no system arguments")
    exit()

GH_TOKEN = sys.argv[1]
OWNER = sys.argv[2]
OWN_REPOSITORY_NAME = sys.argv[3]

GH_API_BASED_URL = "https://api.github.com"
GH_API_BASED_HEADERS = {
    "Authorization": "Bearer {}".format(GH_TOKEN),
    "X-GitHub-Api-Version": "2022-11-28",
    "Accept": "application/vnd.github+json"
}

SOLVED_AD_API_URL = "https://solved.ac/api/v3/problem/show"

def read_latest_solved_commit_info():
    read_commit_endpoint = GH_API_BASED_URL + "/repos/{}/{}/commits".format(OWNER, OWN_REPOSITORY_NAME)

    parameters = {"per_page": 1, "page": 1}
    response = requests.get(
        read_commit_endpoint,
        headers=GH_API_BASED_HEADERS,
        params=parameters
    ).json()

    latest_commit_sha = response[0]["sha"]

    commit_details_endpoint = GH_API_BASED_URL + "/repos/{}/{}/commits/{}".format(OWNER, OWN_REPOSITORY_NAME, latest_commit_sha)
    commit_details = requests.get(
        commit_details_endpoint,
        headers=GH_API_BASED_HEADERS
    ).json()

    if "files" not in commit_details or len(commit_details["files"]) == 0:
        raise Exception("No files found in the latest commit.")

    return {
        "commit_message": commit_details["commit"]["message"],
        "commit_url": commit_details["html_url"],
        "file_path": commit_details["files"][0]["filename"]
    }


def get_problem_info(problem_id):
    levels = {
        0: "U",
        1: "B5", 2: "B4", 3: "B3", 4: "B2", 5: "B1",
        6: "S5", 7: "S4", 8: "S3", 9: "S2", 10: "S1",
        11: "G5", 12: "G4", 13: "G3", 14: "G2", 15: "G1",
        16: "P1", 17: "P2", 18: "P3", 19: "P2", 20: "P1",
    }

    parameters = {"problemId": problem_id}

    response = requests.get(
        SOLVED_AD_API_URL,
        params=parameters
    ).json()

    return {
        "problem_id": response["problemId"],
        "problem_name": response["titleKo"],
        "problem_level": levels[response["level"]],
        "problem_tags": [tag["key"] for tag in response["tags"]],
    }

def add_problem_metadata_to_java(file_path, problem_info):
    metadata = f"""/*
 * Baekjoon Problem #{problem_info['problem_id']}: {problem_info['problem_name']}
 * Link: https://www.acmicpc.net/problem/{problem_info['problem_id']}
 * Level: {problem_info['problem_level']}
 * Tags: {', '.join(problem_info['problem_tags'])}
 */
"""
    try:
        with open(file_path, "r+", encoding="utf-8") as file:
            content = file.read()
            if metadata in content:
                print(f"Metadata already exists in {file_path}")
                return

            file.seek(0, 0)
            file.write(metadata + "\n" + content)
            print(f"Metadata added to {file_path}")
    except FileNotFoundError:
        print(f"File {file_path} not found.")
    except Exception as e:
        print(f"Error updating file {file_path}: {e}")

def main():
    latest_commit_info = read_latest_solved_commit_info()
    latest_commit_message = latest_commit_info["commit_message"]
    file_path = latest_commit_info["file_path"]

    if not latest_commit_message.startswith("solve"):
        print("This commit is not a 'solve' commit")
        return

    solved_problem_number = latest_commit_message.split()[1]

    problem_info = get_problem_info(solved_problem_number)
    add_problem_metadata_to_java(file_path, problem_info)

if __name__ == "__main__":
    main()
