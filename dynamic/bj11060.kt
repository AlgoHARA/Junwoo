import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
11060 점프점프
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() } // 문제에서 제시하는 값 리스트
    val dp = MutableList<Int?>(n) { null } // 모든 값을 null로 초기화 해당 리스트는 여기까지 도달하는데 얼마나 걸렸는지를 저장하는 리스트
    dp[0] = 0 // 최초 시작값만 0으로 값 변경
    list.forEachIndexed { index, i ->
        if (i != 0 && dp[index] != null) { // i가 0이면 점프를 할 수 없으므로 아무런 동작을 해주지 않는다. 
          // 또는 지금 현재 값이 null이라면 점프를 통해서 도달 하지 못했다는 얘기이므로 동작하지 않아준다. 
          // ex) n이 5일때 1 0 0 1 0 의 경우 네번째의 1은 정상적인 방법으로 도달 할 수 없으므로 이러한 경우를 걸러준다. 
            for (i in 1..i) { // i 의 범위 ex) i가 3이면 -> 1 2 3 으로 점프를 뛸수 있으므로 점프 범위에 대해서 반목분
                if (index + i <= n - 1) { // 점프뛸 index가 n보다 넘지 않는가를 판별
                    dp[index + i] = min(dp[index + i] ?: Int.MAX_VALUE, dp[index]!! + 1)
                    // 기존의 점프뛰어서 도달한 값과 현재 지점에서 점프뛰어서 + 1을 비교해 최소값을 넣어준다
                    // dp[index + 1]?: Int.MAX_VALUE의 의미는 점프뛸 곳이 null이라면 null 대신 Int의 최대값을 넣어준다는 뜻 
                    // 즉, 아직 점프를 통해서 도달을 하지 못해 null인 경우 dp[index] + 1의 값을 넣어준다는 뜻
                }
            }
        }
    }

    if (dp[n - 1] == null) // 마지막 값이 null이면 -1 아니면 마지막 자리 값
        print(-1)
    else
        print(dp[n - 1])


}
