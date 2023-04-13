class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
        var temp = ""
        new_id.toLowerCase().forEach{
            if(it.code in 'a'.code .. 'z'.code || it.code in '0'.code..'9'.code || it=='-' || it == '_' || it == '.'){
                temp += it
            }
        }
        while(temp.contains("..")){
            temp = temp.replace("..",".")
        }
        
        if (temp.isEmpty()) temp = "a"
        if (temp.first() == '.') temp = temp.substring(1, temp.length)
        
        if (temp.isEmpty()) temp = "a"
        if (temp.last() == '.') {
            if(temp.length == 1) temp =""
            else temp = temp.substring(0,temp.length-1)
        }
        
        if (temp.isEmpty()) temp = "a"
        if (temp.length >= 16) {
            temp = temp.substring(0,15)
            if(temp.last() == '.') temp = temp.substring(0,14)
        }
        while (temp.length <= 2) {
            temp += temp.last()
        }
        answer = temp
        return answer 
    }
}
