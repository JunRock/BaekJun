package 구현

fun main(){
    val (x,y) = readln().split(" ").map { (it.toInt()) }
    val list = ArrayList<Int>()
        val numList = readln().split(" ").map { (it.toInt()) }
        list.addAll(numList)


        list.filter { it < y }. forEach{ print("$it ")}
}