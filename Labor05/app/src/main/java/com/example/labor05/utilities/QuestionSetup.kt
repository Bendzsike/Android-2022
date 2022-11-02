package com.example.labor05.utilities

import androidx.compose.runtime.Composable
import com.example.labor05.quiz.Item
import com.example.labor05.quiz.ItemRepository
import com.example.labor05.quiz.ItemService

@Composable
fun questionListSetup(): List<Item> {
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    CreateQuizList(itemRepository)
    return itemService.selectRandomItems(itemRepository.size())
}