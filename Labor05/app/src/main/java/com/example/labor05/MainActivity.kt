package com.example.labor05

import Item
import ItemController
import ItemRepository
import ItemService
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labor05.ui.theme.Labor05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labor05Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuizScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "QUIZ",
            style = TextStyle(fontSize = 26.sp)
        )
        Spacer(Modifier.size(70.dp))
        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )
        Spacer(Modifier.size(70.dp))
        Button(
            onClick = {
                if(name.equals("")) {
                    Toast.makeText(context, "Please enter your name!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Get Started")
        }
    }
}

@Composable
fun QuizScreen() {
    var correctAnswers = 0
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    createQuizList(itemRepository)
    val questions = itemService.selectRandomItems(itemRepository.size())
    questions.forEach {
        if(QuestionScreen(it)) {
            ++correctAnswers
        }
    }

}

@Composable
fun QuestionScreen(questionItem: Item): Boolean {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = questionItem.question,
            style = TextStyle(fontSize = 26.sp)
        )
        Spacer(Modifier.size(20.dp))
    }
    return true
}

@Composable
fun createQuizList(itemRepository: ItemRepository) {
    itemRepository.saveItem(
        Item(
            stringResource(R.string.question1),
            stringArrayResource(R.array.question1_answers).toList(),
            R.integer.question1_correct
        )
    )
}
