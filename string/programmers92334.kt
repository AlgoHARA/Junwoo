class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size) {0}
        val result = mutableSetOf<Pair<String,String>>() // 앞은 신고자 뒤는 신고당한사람
        val banList = mutableListOf<String>()
        
        report.forEach{
            val temp = it.split(" ")
            result.add(Pair(temp[0],temp[1]))
        }
        
        id_list.forEach{user->
            if(result.count{it.second == user} >= k){
                banList.add(user)
            }
        }
        
        result.forEach{
            if(banList.contains(it.second)){
                id_list.forEachIndexed{index, user->
                    if(user == it.first)
                        answer[index] = answer[index] + 1
                }
            }
        }   
        return answer
    }
}
