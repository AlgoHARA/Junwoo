/*
* 가장 가까운 같은 글자
*/
class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        var temp = ""
        s.forEach{
            if(!(temp.contains(it))) answer.add(-1)
            else{
                var count = 0
                run breaking@{
                    temp.reversed().forEach{ ch ->
                        count++
                        if(it == ch) {
                            answer.add(count)
                            return@breaking
                        }
                    }
                }
            }
            temp += it
        }
        return answer.toIntArray()
    }
}
