package com.example.event

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.event.ui.theme.EventTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyScreen(viewModel: MyViewModel, modifier: Modifier = Modifier) {
    viewModel.myString.observeAsState().value
    val context = LocalContext.current
    val toast = {
        viewModel.assignText()
        Toast.makeText(context, viewModel.myString.value, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { toast.invoke() }) {
            Text(text = "Click Me")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventTheme {
        MyScreen(MyViewModel())
    }
}