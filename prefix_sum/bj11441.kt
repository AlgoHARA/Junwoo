import java.lang.StringBuilder

fun main(){
    val n = readln().toInt()
    val sb = StringBuilder()
    val list = readln().split(" ").map { it.toInt() }

    val prefix = mutableListOf<Int>()
    prefix.add(0)
    prefix.add(list[0])
    for(i in 2..list.size){
        prefix.add(prefix[i-1] + list[i-1])
    }

    val m = readln().toInt()
    repeat(m){
        val (i,j) = readln().split(" ").map { it.toInt() }
        sb.append("${prefix[j] - prefix[i-1]}\n")
    }
    print(sb)
}
