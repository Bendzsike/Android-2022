import java.io.File
import java.util.*
import kotlin.random.Random

class ItemRepository {
    private val items = mutableListOf<Item>()

    init {
        val scanner = Scanner(File("Quiz.txt"))
        lateinit var question:String
        lateinit var answers:List<String>
        var correctAnswer = 0
        while(scanner.hasNextLine()) {
            question = scanner.nextLine()
            val numOfAnswers = scanner.nextLine().toInt()
            answers = mutableListOf()
            for(i in 0 until numOfAnswers) {
                answers.add(scanner.nextLine())
            }
            correctAnswer = scanner.nextLine().toInt() - 1
        }
        saveItem(Item(question, answers, correctAnswer))
    }

    fun randomItem(): Item {
        return items[Random.nextInt(size())]
    }

    private fun saveItem(item: Item) {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }
}