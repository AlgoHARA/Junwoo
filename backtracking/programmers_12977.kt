class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        val combines = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)
        val picks = mutableListOf<Int>()

        fun backtrack(depth : Int, start:Int){
            if(depth == 3){
                var temp = 0
                visited.forEachIndexed{ index , b ->
                    if(b) temp += nums[index]
                }
                combines.add(temp)
                return 
            }
            for(i in start..nums.size-1){
                if(!visited[i]){
                    visited[i] = true
                    backtrack(depth+ 1, i + 1)
                    visited[i] = false
                }
            }
        }
        
        fun isPrime(n: Int): Boolean {
            if (n == 0 || n == 1) return false
            var i = 2
            while (i * i <= n) { if (n % i++ == 0) return false }
            return true
        }
        
        backtrack(0,0)
        
        println(combines.joinToString(" "))
        
        combines.forEach{
            if(isPrime(it)){
                answer ++
            }
        }
        
        
        return answer
    }
}
