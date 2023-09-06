package com.architectcoders.pinpoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.architectcoders.pinpoint.ui.MainScreen
import com.architectcoders.pinpoint.ui.common.LoaderComponent
import com.architectcoders.pinpoint.ui.extensions.subscribeLoader
import com.architectcoders.pinpoint.ui.theme.PinPointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowLoader = mutableStateOf(true)
        lifecycleScope.subscribeLoader { shouldShowLoader.value = it }
        setContent {
            PinPointTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val showLoader by remember { shouldShowLoader }
                    Box {
                        MainScreen()
                        if (showLoader) {
                            LoaderComponent()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PinPointTheme {
        Greeting("Android")
    }
}