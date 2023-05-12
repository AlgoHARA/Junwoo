/*
* 프로그래머스64064 불량 사용자
*/

class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        val result = mutableSetOf<MutableList<String>>()
        val visited = BooleanArray(user_id.size)
        val temp = mutableListOf<String>()
                
        fun backtrack(start:Int, depth : Int){
            if(depth == banned_id.size){
                result.add(temp.sorted().toMutableList())
                return
            }
            
            for(i in 0 until user_id.size){
                val con = banned_id[depth]
                    if(!visited[i]){
                        val user = user_id[i]
                        if(con.length == user.length){
                            var flag = true
                            con.forEachIndexed{ index, ch ->
                            if(ch != user[index]) 
                                if(ch != '*') flag = false
                            }
                            if(flag){
                                visited[i]= true
                                temp.add(user)
                                backtrack(i, depth+1)
                                temp.remove(user)
                                visited[i]=false
                            }
                        }
                    }
            }
        }
        backtrack(0,0)
        answer = result.size
        return answer
    }
}
