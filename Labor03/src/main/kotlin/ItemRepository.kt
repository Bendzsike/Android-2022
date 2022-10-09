import java.io.File
import java.util.*

class ItemRepository {
    private val items = mutableListOf<Item>()

    init {
        val scanner = Scanner(File("Quiz.txt"))
        lateinit var question:String
        lateinit var answers:List<String>
        while(scanner.hasNextLine()) {
            question = scanner.nextLine()
            val numOfAnswers = scanner.nextLine().toInt()
            answers = mutableListOf()
            for(i in 0 until numOfAnswers) {
                answers.add(scanner.nextLine())
            }
            val correctAnswer = scanner.nextLine().toInt() - 1
            saveItem(Item(question, answers, correctAnswer))
        }
    }

    fun randomItem(): Item {
        return items[(0..5).random()]
    }

    private fun saveItem(item: Item) {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }
}