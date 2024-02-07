fun main() {

    val n = readln().toInt()
    val nums = MutableList(10000000) { it+1 }
    nums.removeIf { it > n }

    var start = 0
    var end = 0
    var count = 0
    var cur = 0

    while (true) {
        print("$start $end")
        if(end >= nums.size || start >= nums.size) break
        cur = nums[start] + nums[end]
        if (cur <= n){
            if(cur == n) count++
            end++
        }else{
            start++
        }
    }

    print(count)

}
