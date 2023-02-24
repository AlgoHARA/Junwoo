class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf().toMutableList() 
        var height = 1
        while(true){
            if(yellow % height == 0){
                if(((height * 2) + ((yellow / height) * 2) + 4) == brown){
                    answer.add((yellow / height)+2)
                    answer.add(height+2) 
                    break
                }        
            }   
            height++
        }
        return answer.toIntArray()
    }
}
