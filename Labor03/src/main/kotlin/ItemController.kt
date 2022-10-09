class ItemController(private val itemService: ItemService) {
    fun quiz(count: Int) {
        var correctAnswers = 0
        val listOfQuestions = itemService.selectRandomItems(count)
        for (i in 0 until count) {
            println("Question: ${listOfQuestions[i].question}")
            for(j in 0 until listOfQuestions[i].answers.size) {
                println("\t${j + 1}. ${listOfQuestions[i].answers[j]}")
            }
            val answer = readLine()?.toInt()?.minus(1)
            if(listOfQuestions[i].answers[answer!!] == listOfQuestions[i].answers[listOfQuestions[i].correct]) {
                ++correctAnswers
            }
        }
        listOfQuestions.forEachIndexed { index, element ->
            println("${index + 1}. question's correct answer: ${element.answers[element.correct]}")
        }
        println("Correct answers: $correctAnswers/$count")
    }
}