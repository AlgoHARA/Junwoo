/**
* 문자열 나누기
*/

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var x = s.first()
        var result = 0
        
        val queue = ArrayDeque<Char>()
        s.forEach{
            if(queue.isEmpty()) x = it
            if(it == x) queue.add(it)
            else {
                queue.removeLast()
                if(queue.isEmpty()) answer++
            }
        }
        if(queue.isNotEmpty()) answer++
        return answer
    }
}
