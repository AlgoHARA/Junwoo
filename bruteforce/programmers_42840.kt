class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf().toMutableList()
        val supo1 = listOf(1,2,3,4,5)
        val supo2 = listOf(2,1,2,3,2,4,2,5)
        val supo3 = listOf(3,3,1,1,2,2,4,4,5,5)
        
        val correct = mutableListOf(0,0,0)
                
        answers.forEachIndexed{ index, it ->
            if(it == supo1[(index) % 5]) correct[0] += 1     
            if(it == supo2[(index) % 8]) correct[1] += 1
            if(it == supo3[(index) % 10]) correct[2] += 1
        }
        
        
        val best = correct.maxOrNull()
        
        correct.forEachIndexed{ index, it ->
            if(it == best) answer.add(index + 1) 
        }
        
        return answer.toIntArray()
    }
}
