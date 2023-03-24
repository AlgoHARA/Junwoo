/*
* 둘만의 암호
*/

class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        s.forEach{
            var count = 0
            var temp = it.code
            while(count != index){
                temp++
                if(!(skip.contains(temp.toChar()))) count++
            }
            if(temp >= 123){
                var over = temp - 122
                temp = 96
                count = 0
                while(count != over){
                temp++
                if(!(skip.contains(temp.toChar()))) count++
                if(temp == 123) temp = 97 // 다시 알파벳의 범위를 넘어갈 경우
                }
            }
            answer += temp.toChar()            
        }
        return answer
    }
}
