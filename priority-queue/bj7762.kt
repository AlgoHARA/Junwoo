import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
/*
* 7662 이중 우선순위 큐
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()

    repeat(n) {
        val m = readLine().toInt()
        val treeMap = TreeMap<Long, Int>() // 케이스마다 treeMap을 초기화 시켜주어야함

        repeat(m) {
            val com = readLine().split(" ")
            if (com[0] == "I") {
                val num = com[1].toLong()
                treeMap[num] = treeMap.getOrDefault(num, 0) + 1 // 해당 자리에 아무것도 없으면 1을 넣어주고 아니면 그 key값 + 1
            } else {
                if (treeMap.isNotEmpty()) {
                    val key = if (com[1] == "1") treeMap.lastKey() else treeMap.firstKey()
                    if (treeMap[key] == 1)
                        treeMap.remove(key)
                    else
                        treeMap[key] = treeMap[key]!! - 1
                }
            }
        }
        if (treeMap.isEmpty()) bw.write("EMPTY\n")
        else bw.write("${treeMap.lastKey()} ${treeMap.firstKey()}\n")
    }
    bw.flush()
    bw.close()
}

/*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val minQueue = PriorityQueue<Int>()
    val maxQueue = PriorityQueue<Int>(Collections.reverseOrder())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()

    repeat(n) {
        val m = readLine().toInt()
        repeat(m) {
            val com = readLine()
            when (com) {
                "D -1" -> {
                    if (minQueue.isNotEmpty()) {
                        maxQueue.remove(minQueue.poll())
                    }
                }
                "D 1" -> {
                    if (maxQueue.isNotEmpty()) {
                        minQueue.remove(maxQueue.poll())
                    }
                }
                else -> {
                    val num = com.substring(2).toInt()
                    minQueue.add(num)
                    maxQueue.add(num)
                }
            }
        }
        if (minQueue.isEmpty()) bw.append("EMPTY\n")
        else bw.append("${maxQueue.poll()} ${minQueue.poll()}\n")
    }
    bw.flush()
    bw.close()
}
*/ 
// 다음과 같이 두개의 우선순위큐를 통해서 구현하게 되면 테스트케이스는 통과하지만 시간초과가 발생한다.
