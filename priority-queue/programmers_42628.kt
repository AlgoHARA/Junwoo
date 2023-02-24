import java.util.*
import kotlin.collections.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf().toMutableList()
        val minQueue = PriorityQueue<Int>()
        val maxQueue = PriorityQueue<Int>(Collections.reverseOrder())
        
        operations.forEach{                
            when(it){
                "D -1" ->{
                    if(minQueue.isNotEmpty()){
                        val min = minQueue.poll()
                        maxQueue.remove(min)    
                    }                   
                }
                "D 1" ->{
                    if(maxQueue.isNotEmpty()){
                        val max = maxQueue.poll()
                        minQueue.remove(max)    
                    }
                }
                else ->{
                    val num = it.substring(2).toInt()
                    minQueue.add(num)
                    maxQueue.add(num)
                }
            }   
        }
        
        answer.add(maxQueue.poll() ?: 0)
        answer.add(minQueue.poll() ?: 0)
        
        return answer.toIntArray()
    }
}
