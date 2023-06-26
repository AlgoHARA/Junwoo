/*
* 프로그래머스 연속 부분 수열 합의 개수
*/

class Solution {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0
        val arr = IntArray(elements.size * 2)
        val result = mutableSetOf<Int>()
        repeat(elements.size * 2){
            arr[it] = elements[it % elements.size]
        }
        
        for (i in 1..elements.size) {
            for (j in 0..elements.size) {
                result.add(arr.slice(j..j+i-1).sum())
            }
        }
        
        answer = result.size
        
        return answer
    }
}
