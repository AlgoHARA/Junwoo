fun main(){
    val (x,y) = readLine()!!.split(" ")

    print((x.reversed().toInt() + y.reversed().toInt()).toString().reversed().toInt())
}
