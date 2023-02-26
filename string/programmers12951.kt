class Solution {
    fun solution(s: String): String {
        var answer = ""
        s.split(" ").forEach{
            it.forEachIndexed{ index, ch->
                if(index == 0) answer += ch.uppercase()
                else answer += ch.lowercase()    
            }
            answer += " "
        } 
        answer = answer.substring(0,answer.length-1)
        return answer
    }
}
