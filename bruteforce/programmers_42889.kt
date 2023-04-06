class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var failure = hashMapOf<Int,Float>()
        var stage = 1
        var people = stages.size.toFloat()
        while(stage != N+1){
            val suc = stages.count{it == stage}
            if(suc != 0){
                failure.put(stage, (suc.toFloat()/people))
                people -= suc
            }else{
                failure.put(stage, 0.toFloat())
            }
             stage++
        }
        
        failure.toList().sortedByDescending{(key,value) -> value}
                .toMap().forEach{
                    answer.add(it.key)        
                }
        
        return answer.toIntArray()
    }
}
