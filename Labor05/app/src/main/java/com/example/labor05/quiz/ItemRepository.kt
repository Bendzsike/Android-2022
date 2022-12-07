package com.example.labor05.quiz

class ItemRepository {
    private val items = mutableListOf<Item>()

    fun randomItem(): Item {
        return items[(0..5).random()]
    }

    fun saveItem(item: Item) {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }
}