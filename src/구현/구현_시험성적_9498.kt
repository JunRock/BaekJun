package 구현

fun main() {
    var num = readLine()!!.toInt();
    val result = when (num) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
    println(result)
}
