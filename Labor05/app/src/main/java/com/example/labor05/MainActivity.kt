package com.example.labor05

import com.example.labor05.quiz.Item
import com.example.labor05.quiz.ItemRepository
import com.example.labor05.quiz.ItemService
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    NavigationHandler()
                }
            }
        }
    }
}

@Composable
fun NavigationHandler(){
    val navController = rememberNavController()

    val questions = QuestionListSetup()

    val startDestination = Routes.MainScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(
            "${Routes.QuestionScreen.route}/{questionNumber}/{correctAnswers}",
            arguments = listOf(
                navArgument("questionNumber") { type = NavType.IntType },
                navArgument("correctAnswers") { type = NavType.IntType }
            )
        ) {
            val number = it.arguments?.getInt("questionNumber") ?: 0
            val correctAnswers = it.arguments?.getInt("correctAnswers") ?: 0
            QuestionScreen(navController = navController, questions, number, correctAnswers)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
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
                if(name == "") {
                    Toast.makeText(context, "Please enter your name!", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("${Routes.QuestionScreen.route}/0/0")
                }
            }
        ) {
            Text(text = "Get Started")
        }
    }
}

@Composable
fun QuestionListSetup(): List<Item> {
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    createQuizList(itemRepository)
    return itemService.selectRandomItems(2)
}

@Composable
fun QuestionScreen(navController: NavController, questions: List<Item>, questionNumber: Int, correctAnswers: Int) {
    var correct = false
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(0.7f)
    ) {
        Text(
            text = questions[questionNumber].question,
            style = TextStyle(fontSize = 26.sp)
        )
        Spacer(Modifier.size(20.dp))
        val selectedValue = remember { mutableStateOf("") }

        val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
        val onChangeState: (String) -> Unit = { selectedValue.value = it }

        val items = questions[questionNumber].answers
        Column(Modifier.padding(8.dp)) {
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .selectable(
                            selected = isSelectedItem(item),
                            onClick = { onChangeState(item) },
                            role = Role.RadioButton
                        )
                        .padding(8.dp)
                ) {
                    RadioButton(
                        selected = isSelectedItem(item),
                        onClick = null
                    )
                    Text(
                        text = item,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        Button(
            onClick = {
                //TODO: For some god damn reason doesn't work
                if(selectedValue.value == questions[questionNumber].answers[questions[questionNumber].correct]) {
                    correct = true
                }
                if(questionNumber < questions.size) {
                    if(correct) {
                        navController.navigate("${Routes.QuestionScreen.route}/${questionNumber + 1}/${correctAnswers + 1}")
                    } else {
                        navController.navigate("${Routes.QuestionScreen.route}/${questionNumber + 1}/$correctAnswers")
                    }
                } else {
                    //TODO: Navigate to EndScreen
                }
            }
        ) {
            Text(text = "Submit")
        }
        Text(text = correctAnswers.toString())
    }
}

@Composable
fun createQuizList(itemRepository: ItemRepository) {
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
