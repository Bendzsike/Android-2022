import java.io.File

object TreeSetDictionary : IDictionary {
    private val words = mutableSetOf<String>()

    init {
        File(IDictionary.fileName).forEachLine {
            add(it)
        }
    }

    override fun add(word: String): Boolean {
        if(find(word)) {
            return false
        }
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return word in words
    }

    override fun size(): Int {
        return words.size
    }

}