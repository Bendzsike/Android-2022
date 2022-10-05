class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(count: Int): List<Item> {
        val result = mutableListOf<Item>()
        for(i in 0 until count) {
            result.add(itemRepository.randomItem())
        }
        return result
    }
}