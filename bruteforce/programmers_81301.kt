
import kotlin.math.*

/*
* 2021 카카오 채용연계형 인턴십
숫자 문자열과 영단어
*/

class Solution {

    fun solution(s: String): Int {
        var answer:Int = 0
        var result = ""
        var temp = ""
        
        //println(ch.code-'0'.code)
        s.forEach{
            if(0 <= it.code-'0'.code && it.code-'0'.code <= 9){
                result += it.code-'0'.code
            }else{
                temp += it
                val che = check(temp)
                if(che != null){
                    result += che!!.code - '0'.code
                    temp =""
                }
            }
        }        
        
        result.forEachIndexed{ index, it ->
            answer += (it.code - '0'.code) * ((10.0).pow(result.length -1 - index)).toInt()
        }
        return answer
    }
    
    
    fun check(num:String):Char?{
        when(num){
            "zero" -> return '0'
            "one" -> return '1'
            "two" -> return '2'
            "three" -> return '3'
            "four" -> return '4'
            "five" -> return '5'
            "six" -> return '6'
            "seven" -> return '7'
            "eight" -> return '8'
            "nine" -> return '9'
            else -> return null
        }
    }
}
