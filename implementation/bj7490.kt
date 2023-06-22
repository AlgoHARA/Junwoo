import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj7490 0 만들기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val t = readLine().toInt()
    val sb = StringBuilder()
    val results = mutableListOf<String>()
    var start = 0

    fun backtrack(num: String, depth: Int) {
        if (depth == start) {
            var exp = num
            exp = exp.replace(" ","")
            var pre_oper = ""
            var temp = ""
            var result = 0

            exp.forEach {
                if(it == '+' || it == '-'){
                    if(pre_oper == "") result += temp.toInt()
                    else{
                        if(pre_oper == "-") result -= temp.toInt()
                        else result += temp.toInt()
                    }
                    pre_oper = "$it"
                    temp = ""
                }else{
                    temp += it
                }
            }
            if(pre_oper == "-") result -= temp.toInt()
            else result += temp.toInt()

            if(result == 0) results.add(num)
            return
        }
        backtrack("${start - depth}+" + num, depth + 1)
        backtrack("${start - depth}-" + num, depth + 1)
        backtrack("${start - depth} " + num, depth + 1)
    }

    repeat(t) {
        val n = readLine().toInt()
        start = n
        backtrack("$n", 1)
        results.sorted().forEach {
            sb.append("$it\n")
        }
        sb.append("\n")
        results.clear()
    }
    print(sb)

}
