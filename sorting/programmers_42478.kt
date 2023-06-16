class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf().toMutableList()
        val result = mutableListOf<Int>()
        commands.forEachIndexed{ index, it ->
            val temp = array.copyOfRange(it[0]-1,it[1]).sorted()
            answer.add(temp[it[2]-1])
        }
        
        return answer.toIntArray()
    }
}
