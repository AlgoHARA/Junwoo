/*
프로그래머스 월간 코드 챌린지 시즌1 두 개 뽑아서 더하기
*/

class Solution { 
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val list = mutableListOf<Int>()
        var count = 1
        var start  = 0
        var end = 1
        
        while(true){
            if(start == end){
                count++
                if(count == numbers.size) break
                start = 0
                end = count
            }
            println(numbers[start] + numbers[end])
            list.add(numbers[start] + numbers[end])
            start++
        }
        answer= list.toSet().sorted().toIntArray()
        
        return answer
    }
}
