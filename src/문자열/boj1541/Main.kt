package 문자열.boj1541

fun main() {
    System.`in`.bufferedReader().use { reader ->
       System.out.bufferedWriter().use { writer ->

            val input = reader.readLine().split("-")

            val result = input
                .map { it.split("+").sumOf(String::toInt) }
                .let { nums -> nums.first() - nums.drop(1).sum() }

            writer.write(result)
            writer.flush()
        }
    }
}