/*
* 체육복
*/

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        val list = MutableList<Int>(n+2){1}
        list[0] = 0
        list[n+1] = 0
        
        lost.forEach{
            list[it]--
        }
        reserve.forEach{
            list[it]++
        }
        list.forEachIndexed{ index, it ->
            if(it == 0 && index != 0 && index != n+1){
                if(list[index-1] == 2 || list[index+1] == 2){
                    if(list[index-1] == 2){
                      list[index-1]-- 
                      list[index]++                      
                    }else{
                      list[index+1]-- 
                      list[index]++  
                    }
                }
            }
        }
        answer = list.count{it == 2 || it == 1}
    
        return answer
    }
}
