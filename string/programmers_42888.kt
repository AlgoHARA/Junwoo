/*
* 2019 Kakao 오픈채팅방
*/
class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val db = HashMap<String, String>()
        record.forEach{
            val temp = it.split(" ")
            if(temp[0] == "Enter")
                db.put(temp[1],temp[2])
            else if(temp[0] == "Change")
                db[temp[1]] = temp[2]
        }
        record.forEach{
            val temp = it.split(" ")
            if(temp[0] == "Enter")
                answer.add("${db[temp[1]]}님이 들어왔습니다.")
            else if(temp[0] == "Leave")
                answer.add("${db[temp[1]]}님이 나갔습니다.")
        }
    
        return answer.toTypedArray()
    }
}
