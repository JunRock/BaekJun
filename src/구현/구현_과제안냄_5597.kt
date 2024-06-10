package 구현

fun main(){
    val list = ArrayList<Int>()

    for (i in 0 until  28){
        list.add(readLine()!!.toInt())
    }


    for (i in 1..30){
        if(!list.contains(i)){
            println(i)
        }
    }
}