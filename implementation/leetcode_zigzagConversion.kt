class Solution {
    fun convert(s: String, numRows: Int): String {
        val zigzag = Array(numRows) { mutableListOf<Char>() }
        if(numRows == 1) return s
        else{
            val corner = (numRows-1) * 2
            var temp = 0
            s.forEach{ char ->
                if(temp < numRows) zigzag[temp % numRows].add(char)
                else zigzag[corner-temp].add(char)

                if(temp+1 == corner) temp = 0
                else temp++
            }        
        }
        var result = StringBuilder()
        zigzag.forEach{ it->
            result.append(it.joinToString(""))
        }

        return result.toString()

    }

}
