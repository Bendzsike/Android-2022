import com.example.labor05.quiz.ItemService

class ItemController(private val itemService: ItemService) {
    fun quiz(count: Int) {
        var correctAnswers = 0
        val listOfQuestions = itemService.selectRandomItems(count)
        listOfQuestions.forEach {
            println("Question: ${it.question}")
            it.answers.forEachIndexed { index, element ->
                println("\t${index + 1}. $element")
            }
            val answer = readLine()?.toInt()?.minus(1)
            if (answer == null || answer >= it.answers.size) {
                println("Incorrect choice!")
            } else if(it.answers[answer] == it.answers[it.correct]) {
                ++correctAnswers
            }
        }
        listOfQuestions.forEachIndexed { index, element ->
            println("${index + 1}. question's correct answer: ${element.answers[element.correct]}")
        }
        println("Correct answers: $correctAnswers/$count")
    }
}