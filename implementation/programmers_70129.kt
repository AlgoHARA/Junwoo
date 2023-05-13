/*
* 프로그래머스 70129 이진 변환 반복하기
*/

class Solution {
    fun solution(s: String): IntArray {
        var str = s
        var zero = 0
        var count = 0
        var answer = IntArray(2)
        while(true){
            if(str == "1") break
            if(str.contains("0")){
                answer[1] += str.count{ it == '0' }
                str = str.replace("0","")
            }
            str = Integer.toBinaryString(str.length).toString()
            answer[0]++
        }
        
        return answer
    }
}
