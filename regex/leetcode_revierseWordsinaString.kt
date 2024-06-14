class Solution {
    fun reverseWords(s: String): String {
        
        val temp = s.split("\\s+".toRegex())
        return temp.reversed().joinToString(" ").trim()

    }
}
