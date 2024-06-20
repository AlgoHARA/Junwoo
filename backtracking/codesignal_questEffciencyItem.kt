fun solution(h: MutableList<Int>, points: MutableList<Int>, timeForQuests: Int): Int {
    val total = h.size
    var result = 0
    
    fun backtrack(remainingTime: Int, currentPoints: Int, start: Int) {
        if (currentPoints > result) {
            result = currentPoints
        }
        
        for (i in start until total) {
            if (remainingTime >= h[i]) {
                backtrack(remainingTime - h[i], currentPoints + points[i], i + 1)
            }
        }
    }
    
    backtrack(timeForQuests, 0, 0)
    
    return result
}
