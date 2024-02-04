fun main() {

    val (n, k) = readln().split(" ").map { it.toInt() }
    val zoo = MutableList(1000001) { 0 }
    var max = Int.MIN_VALUE
    var result = 0
    repeat(n){
        val (g,x) = readln().split(" ").map { it.toInt() }
        zoo[x] = g
    }

    for(i in 0..1000000){
        if(i >= 2*k+1) result -= zoo[i -(2*k+1)]
        result += zoo[i]
        if(result > max) max = result
    }
    print(max)
}
