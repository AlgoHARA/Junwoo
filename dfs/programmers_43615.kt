class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        val count = numbers.size
        var answer = 0
            
        fun dfs(depth:Int,num : Int){
            if(depth == count){
                if(num == target) answer++
                return
            }
            dfs(depth + 1, num + numbers[depth])
            dfs(depth + 1, num - numbers[depth])
        }
        
        dfs(0,0)
        return answer
    }
}
