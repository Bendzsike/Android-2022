package com.example.labor05.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.example.labor05.quiz.Item
import com.example.labor05.quiz.ItemRepository
import com.example.labor05.R

@Composable
fun CreateQuizList(itemRepository: ItemRepository) {
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question1),
            stringArrayResource(R.array.question1_answers).toList(),
            integerResource(R.integer.question1_correct)
        )
    )
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question2),
            stringArrayResource(R.array.question2_answers).toList(),
            integerResource(R.integer.question2_correct)
        )
    )
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question3),
            stringArrayResource(R.array.question3_answers).toList(),
            integerResource(R.integer.question3_correct)
        )
    )
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question4),
            stringArrayResource(R.array.question4_answers).toList(),
            integerResource(R.integer.question4_correct)
        )
    )
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question5),
            stringArrayResource(R.array.question5_answers).toList(),
            integerResource(R.integer.question5_correct)
        )
    )
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question6),
            stringArrayResource(R.array.question6_answers).toList(),
            integerResource(R.integer.question6_correct)
        )
    )
}