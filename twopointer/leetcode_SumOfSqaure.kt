import kotlin.math.*

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var start = 0
        var end = sqrt(c.toDouble()).toLong()

        while(start <= end){
            val sum = start*start + end*end
            if(sum == c.toLong()) return true
            else if(sum > c.toLong()) end--
            else start++
        }

        return false
    }
}
