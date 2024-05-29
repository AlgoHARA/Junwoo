fun solution(source: List<String>, challengeId: Int): List<String> {
    val regex = """(\s*)//DB (\d+)//(.+)""".toRegex()
    val result = mutableListOf<String>()

    source.forEach { line->
        val match = regex.matchEntire(line)
        if (match != null) {
            if (match.groupValues[2].toInt() == challengeId) {
                result.removeAt(result.size-1)
                result.add(match.groupValues[1] + match.groupValues[3])
            }
        } else {
            result.add(line)
        }
    }

    return result
}
