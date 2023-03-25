import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 하얀 칸
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var count = 0
    repeat(8){
        if(it % 2 == 1) {
            readLine().forEachIndexed { index, c ->
                if (index % 2 == 1) {
                    if (c == 'F') count++
                }
            }
        }else{
            readLine().forEachIndexed { index, c ->
                if (index % 2 == 0) {
                    if (c == 'F') count++
                }
            }
        }
    }
    print(count)
}
