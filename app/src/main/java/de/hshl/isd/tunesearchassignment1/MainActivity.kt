package de.hshl.isd.tunesearchassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import de.hshl.isd.tunesearchassignment1.ui.theme.TuneSearchAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MainContent()
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    NavigationHost(navController)
}