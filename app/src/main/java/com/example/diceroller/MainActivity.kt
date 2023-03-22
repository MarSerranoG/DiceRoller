package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()

                }
            }
        }
    }

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var diceOne by remember { mutableStateOf(1) }
    var diceTwo by remember { mutableStateOf(1) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Mar Serrano Galvan")
        Image(
            painter = painterResource(id = behavior(diceOne)),
            contentDescription = diceOne.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = behavior(diceTwo)),
            contentDescription = diceTwo.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {diceOne = (1..6).random()
            diceTwo = (1..6).random()}) {
            Text(stringResource(R.string.roll))
        }
    }
}

fun behavior (value : Int):Int{
    val imageResource = when(value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6

    }
    return imageResource
}




