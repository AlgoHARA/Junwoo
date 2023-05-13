/*
* 프로그래머스 12945 피보나치 수
*/
class Solution {
    fun solution(n: Int): Int {
    tailrec fun fibo(n: Int , pre:Int, next:Int): Int {
        if (n <= 0) return pre
        return fibo(n - 1, next%1234567, (pre +next)%1234567)
    }
    var answer = fibo(n,0,1) % 1234567
    return answer
    }
}
