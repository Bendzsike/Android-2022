package com.example.labor05.quiz

class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(amount: Int): List<Item> {
        val result = mutableListOf<Item>()
        var count = amount
        while(count > 0) {
            var contains = false
            val newItem = itemRepository.randomItem()
            result.forEach {
                if(it.question == newItem.question) {
                    contains = true
                }
            }
            if(!contains) {
                result.add(newItem)
                --count
            }
        }
        return result
    }
}