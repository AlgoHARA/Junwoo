class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n){false}
        
        fun dfs(start: Int){
            visited[start] = true
            computers[start].forEachIndexed{ index, it ->
                if(index != start && it == 1 && visited[index] == false) dfs(index)
            }
        }
        var temp = 0
        while(true){
            if(visited[temp] ==  false) {
                dfs(temp)
                answer++
            }
            temp++
            if(visited.all {it == true}) break
        }
        return answer
    }
}
