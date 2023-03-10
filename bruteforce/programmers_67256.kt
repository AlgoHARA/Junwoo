/*
* 2020 카카오 키패드 누르기
*/

import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left = "*"
        var right = "#"
        
        fun checkDis(num : String){
            val temp = when(num){
                "2" -> 0
                "5" -> 1
                "8" -> 2
                "0" -> 3
                else -> 0
            }
            val l = when(left){
                "1" -> 0
                "4" -> 1
                "7" -> 2
                "*" -> 3
                "2" -> 0
                "5" -> 1
                "8" -> 2
                "0" -> 3
                else -> 99
            }
            val r = when(right){
                "3" -> 0
                "6" -> 1
                "9" -> 2
                "#" -> 3
                "2" -> 0
                "5" -> 1
                "8" -> 2
                "0" -> 3 
                else -> 99
            }
            val ldis = 
            if(left == "2" || left == "5" || left =="8" || left == "0")
                abs(l-temp)
            else abs(l-temp) +1 
            
            val rdis =             
            if(right == "2" || right == "5" || right =="8" || right == "0")
                abs(r-temp)
            else
                abs(r-temp)+1

            
            if(ldis > rdis){
                right = num
                answer+="R"
            }
            else if(ldis < rdis){
                left = num
                answer+="L"
            }
            else{
                if(hand == "right"){
                    right = num
                    answer+="R"
                }
                else{
                    left = num
                    answer+="L"
                }
            }     
        }
        
        numbers.forEach{
            when(it){
                1 -> {
                    answer +="L"
                    left = "1"
                }
                4 -> {
                    answer +="L"
                    left = "4"
                }
                7 -> {
                    answer +="L"
                    left = "7"
                }
                3 -> {
                    answer +="R"
                    right = "3"
                }
                6 -> {
                    answer += "R"
                    right = "6"
                }
                9 -> {
                    answer += "R"
                    right = "9"
                }
                else -> {
                    checkDis(it.toString())
                }
            }  
        }
        return answer
    }
}
