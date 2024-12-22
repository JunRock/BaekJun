package implementation

fun main() {
    val list = ArrayList<Int>()

    for (i in 0 until 28) {
        list.add(readLine()!!.toInt())
    }
    var name: String? = null

    for (i in 1..30) {
        if (!list.contains(i)) {
            println(i)
        }
    }
}