fun solution(question: String): String {
    var result = question.trim()

    // 공백 여러개 하나의 공백으로 변환
    result = result.replace(Regex("\\s+"), " ")
    // ,부분 변환
    result = result.replace(Regex("\\s*,\\s*"), ", ")
    // 첫글자 대문자
    result = result.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    // 문장 끝 ? 하나만 되도록
    result = result.replace(Regex("\\?+\\s*$"), "")
    result += "?"

    return result
}
