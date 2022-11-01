package com.example.labor05

import com.example.labor05.quiz.Item
import com.example.labor05.quiz.ItemRepository
import com.example.labor05.quiz.ItemService
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.text.style.TextAlign
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
    val context = LocalContext.current
    val navController = rememberNavController()

    val questions = questionListSetup()

    val startDestination = Routes.MainScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.MainScreen.route) {
            BackHandler(true) {
                Toast.makeText(context, "Pressing back is g*y!", Toast.LENGTH_SHORT).show()
            }
            MainScreen(navController = navController)
        }

        composable(
            "${Routes.QuestionScreen.route}/{questionNumber}/{correctAnswers}/{name}",
            arguments = listOf(
                navArgument("questionNumber") { type = NavType.IntType },
                navArgument("correctAnswers") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType }
            )
        ) {
            val number = it.arguments?.getInt("questionNumber") ?: 0
            val correctAnswers = it.arguments?.getInt("correctAnswers") ?: 0
            val name = it.arguments?.getString("name") ?: ""

            BackHandler(true) {
                Toast.makeText(context, "Pressing back is g*y!", Toast.LENGTH_SHORT).show()
            }

            QuestionScreen(navController = navController, questions, number, correctAnswers, name)
        }

        composable(
            "${Routes.EndScreen.route}/{correctAnswers}/{allAnswers}/{name}",
            arguments = listOf(
                navArgument("correctAnswers") { type = NavType.IntType },
                navArgument("allAnswers") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType }
            )
        ) {
            val correctAnswers = it.arguments?.getInt("correctAnswers") ?: 0
            val allAnswers = it.arguments?.getInt("allAnswers") ?: 0
            val name = it.arguments?.getString("name") ?: ""

            BackHandler(true) {
                Toast.makeText(context, "Pressing back is g*y!", Toast.LENGTH_SHORT).show()
            }

            EndScreen(navController = navController, correctAnswers, allAnswers, name)
        }
    }
}

@Composable
fun questionListSetup(): List<Item> {
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    CreateQuizList(itemRepository)
    return itemService.selectRandomItems(itemRepository.size())
}

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

@Composable
fun MainScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "QUIZ",
            style = TextStyle(fontSize = 26.sp),
        )
        Spacer(Modifier.size(70.dp))
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
                    navController.navigate("${Routes.QuestionScreen.route}/0/0/$name")
                }
            }
        ) {
            Text(text = "Get Started")
        }
    }
}

@Composable
fun QuestionScreen(navController: NavController, questions: List<Item>, questionNumber: Int, correctAnswers: Int, name: String) {

    val context = LocalContext.current

    var correct = correctAnswers
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = questions[questionNumber].question,
            style = TextStyle(fontSize = 26.sp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(20.dp))
        val selectedValue = remember { mutableStateOf("") }

        val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
        val onChangeState: (String) -> Unit = { selectedValue.value = it }

        val items = questions[questionNumber].answers
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
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
                if(selectedValue.value == "") {
                    Toast.makeText(context, "Please choose an answer!", Toast.LENGTH_SHORT).show()
                } else {
                    if(selectedValue.value == questions[questionNumber].answers[questions[questionNumber].correct - 1]) {
                        ++correct
                    }

                    if(questionNumber < questions.size - 1) {
                        navController.navigate("${Routes.QuestionScreen.route}/${questionNumber + 1}/${correct}/$name")
                    } else {
                        navController.navigate("${Routes.EndScreen.route}/$correct/${questions.size}/$name")
                    }
                }
            }
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun EndScreen(navController: NavController, correctAnswers: Int, allAnswers: Int, name: String) {
    val value = correctAnswers / allAnswers.toFloat()
    val firstText = stringResource(id =
        if (value == 0f) {
            R.string.none_correct
        } else if (value < 0.5f) {
            R.string.less_than_half_correct
        } else if (value == 0.5f) {
            R.string.half_correct
        } else if (value > 0.5f && value != 1f) {
            R.string.more_than_half_correct
        } else {
            R.string.all_correct
        }, name)

    val secondText = stringResource(id = R.string.score, correctAnswers, allAnswers)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = firstText,
            style = TextStyle(fontSize = 26.sp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(70.dp))
        Text(
            text = secondText,
            style = TextStyle(fontSize = 26.sp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(70.dp))
        Button(
            onClick = {
                navController.navigate(Routes.MainScreen.route)
            }
        ) {
            Text(text = "Back to Start")
        }
    }
}
