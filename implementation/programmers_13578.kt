/*
* 13578 숫자 카드 나누기
*/

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        var maxA = arrayA[0]
        val divideA = mutableListOf<Int>()
        var maxB = arrayB[0]
        val divideB = mutableListOf<Int>()
        
        arrayA.forEach{
            maxA = gcd(maxA,it)
        }
        repeat(maxA){
            if(maxA % (it+1) == 0) divideA.add(it+1)
        }

        
        arrayB.forEach{
            maxB = gcd(maxB,it)
        }
        repeat(maxB){
            if(maxB % (it+1) == 0) divideB.add(it+1)
        }

        
        divideA.forEach{ num-> 
            if(arrayA.count{it % num == 0} == 0 && arrayB.count{it % num !=0} == 0){
                if(answer < num) answer = num
            }
            else if(arrayB.count{it % num == 0} == 0 && arrayA.count{it % num !=0} == 0){
                if(answer < num) answer = num
            }
        }
        
        divideB.forEach{ num-> 
            if(arrayA.count{it % num == 0} == 0 && arrayB.count{it % num !=0} == 0){
                if(answer < num) answer = num
            }
            else if(arrayB.count{it % num == 0} == 0 && arrayA.count{it % num !=0} == 0){
                if(answer < num) answer = num
            }
        }
        

        return answer
    }
    fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
      
}
