/*
* programmers 할인행사
*/
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        
        val total = number.sum()
        
        for(i in 0..discount.size -10){
            val temp = discount.slice(i..i+9)
            var flag = true
            want.forEachIndexed{ index, w ->
                if(temp.count{it == w} < number[index]) flag = false
            }
            if(flag) answer++
        }        
        
        return answer
    }
}
