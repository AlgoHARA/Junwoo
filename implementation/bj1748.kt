fun main(){

    val n = readLine()!!.toInt()
    var count = 0

    for(i in 1..n){
        when(i){
            in 1..9 -> count +=1
            in 10..99 -> count +=2
            in 100..999 -> count +=3
            in 1000..9999 -> count +=4
            in 10000..99999 -> count +=5
            in 100000..999999 -> count +=6
            in 1000000..9999999 -> count +=7
            in 10000000..99999999 -> count +=8
            in 100000000..999999999 -> count +=9
        }
    }
    print(count)
    
}

// 메모리 초과 버전
// fun main(){
//     val n = readLine()!!.toInt()
//     val sb = StringBuilder()
//     for(i in 1..n){
//         sb.append(i)
//     }
//     print(sb.length)    
// }
