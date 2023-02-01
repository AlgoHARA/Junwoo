import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val sen = readLine()
        if((sen.length % 10) == 0){
            repeat(sen.length / 10){ i->
                if(sen.length == 10)
                	println(sen)
                else               
                	println(sen.substring(i*10 until (i+1)*10))
            }
        }else{
            repeat((sen.length / 10).toInt() + 1){ i ->
                if(i == sen.length / 10)
                    println(sen.substring(i*10 until sen.length))
                else
                    println(sen.substring(i*10 until (i+1)*10))
            }
        }
    }
