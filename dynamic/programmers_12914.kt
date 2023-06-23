class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        val dp = LongArray(n+1)
        dp[0] = 1
        dp[1] = 1
        if(n < 2) return dp[n]%1234567
        
        for(i in 2 until n + 1){
           dp[i] = (dp[i-1] + dp[i-2])%1234567
        }
        answer = dp[n] % 1234567
        return answer 
    }
}

/*
백트래킹으로 풀면 테스트케이스 많아지게 될 경우 시간초과
class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        
        fun backtrack(cur : Int){
            if(cur >= n){
                if(cur == n) answer++
                return
            }
            backtrack(cur + 1)
            backtrack(cur + 2)
        }
        
        backtrack(0)
        return answer % 1234567
    }
}
*/
