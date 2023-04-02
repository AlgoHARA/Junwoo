## 백트래킹

우선 백트래킹의 기본은 visited를 통해서 모든 경우의수를 탐색한다는 것입니다.

```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val num = IntArray(m) { 0 }
    val visited = BooleanArray(n) { false }

    fun backtrack(depth: Int) {
        if (m == depth) {
            println(num.joinToString(" "))
            return
        }

        for (i in 0..n - 1) {
            if (!visited[i]) {
                num[depth] = i + 1
                visited[i] = true
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
}
-> 4 2
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
```

다음과 같이 bt 함수내부에서 for문과 visited를 true false로 제어하여 재귀호출 내부에서는 visited[i]가 true인 경우로 탐색을 하게 됩니다. 이후에 visited[i]를 false로 해주어서 이후 for문 내부에는 새로운 i가 visited[i] 가 true인 경우로 탐색하게 될것 입니다. 

그런데 백트래킹의 방법에는 순열이냐(순서가 중요) 조합이에 따라서 중요해집니다,

- 순열

```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val nums = IntArray(n) { 0 }
    val visited = BooleanArray(n)
    val pick = ArrayList<Int>(n + 1)
    val result = ArrayList<Int>()
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        nums[index] = i
    }

    fun backtracking(depth: Int) {

        if (depth == n) {
            var temp = 0
            repeat(n - 1) {
                temp += abs(pick[it] - pick[it + 1])
            }
            result.add(temp)
        }

        for (i in 0..n - 1) {
            if (!visited[i]) {
                visited[i] = true
                pick.add(nums[i])
                backtracking(depth + 1)
                pick.removeLast()
                visited[i] = false
            }
        }

    }
    backtracking(0)
    print(result.max())
}
```

backTracking 함수 내부에서 for문을 보게 된다면 0 부터 모든 경우의수를 구하고 있습니다. 즉, 탐색할때 무조건 처음부터 시작하여 처음 시작점부터 시작하는 순서까지 중요하게 여깁니다. 또한 pick이라는 리스트에 add 해주어서 방문여부와는 별개로 순서를 저장해주고 visited와 같은 논리로 for문 내부에서 다른 경우의수를 탐색하기 위해서 재귀호출 후 removeLast해줍니다.

- 조합

조합의 경우 순서와 상관없이 경우의수만 따지며 됩니다.

```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StrictMath.min
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var result = Long.MAX_VALUE
    val ingredients = ArrayList<Pair<Int, Int>>(n)
    val visited = BooleanArray(n)

    repeat(n) {
        val (s, b) = readLine().split(" ").map { it.toInt() }
        ingredients.add(Pair(s, b))
    }

    fun backtrack(depth: Int) {
        for(i in depth..n-1){
            if(!visited[i]){
                visited[i] = true
                // 여태까지 나온 조합을 depth부터 다시 검사
                var s: Long = 1
                var b: Long = 0
                visited.forEachIndexed { index, boolean ->
                    if (boolean) {
                        s *= ingredients[index].first
                        b += ingredients[index].second
                    }
                }
                result = min(result, abs(s - b))

                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    print(result)
}
```

다음과 같이 backtrack 함수 내부의 for문에서는 매개변수로 받아온 depth부터 시작하여 이전에 선택한 수의 순서와 상관없이 어떤수가 뽑혔는지만 관심을 가지게 됩니다. 이때 visited 를 for문으로 돌려서 몇개를 선택했던간에 방문한 한 수에 대해서 어떠한 처리를 해줍니다. 이때 몇개가 뽑혔는가가 중요하다면, visited의 true 개수나 별도의 처리를 해주면 될것 입니다.
