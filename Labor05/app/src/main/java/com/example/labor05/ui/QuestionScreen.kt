package com.example.labor05.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.labor05.navigation.Routes
import com.example.labor05.quiz.Item

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