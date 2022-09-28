interface IDictionary {
    companion object {
        const val fileName = "input.txt"
    }
    fun add(word: String) : Boolean
    fun find(word: String) : Boolean
    fun size() : Int
}