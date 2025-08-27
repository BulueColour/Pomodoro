package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding
import com.skooldio.android.fundamentals.workshop.pomodoro.ui.theme.PomodoroTheme

class TimerActivity : AppCompatActivity() {

    companion object{

//        private const val EXTRA_WORK_DURATION = "work_duration"
//        private const val EXTRA_SHORT_BREAK_DURATION = "short_break_duration"
//        private const val EXTRA_LONG_BREAK_DURATION = "long_break_duration"
        private const val EXTRA_CONFIG = "config"

        fun newIntent(
            context: Context,
//            workDuration: Int,
//            shortBreakDuration: Int,
//            longBreakDuration: Int
            config: Config
        ) : Intent {
            return Intent(context, TimerActivity::class.java).apply{
//                putExtra(EXTRA_WORK_DURATION, workDuration)
//                putExtra(EXTRA_SHORT_BREAK_DURATION, shortBreakDuration)
//                putExtra(EXTRA_LONG_BREAK_DURATION, longBreakDuration)
                putExtra(EXTRA_CONFIG, config)
            }
        }
    }

    private val binding: ActivityTimerBinding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }

//    private var workDuration: Int = 0
//    private var shortBreakDuration: Int = 0
//    private var longBreakDuration: Int = 0
    private var config: Config? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PomodoroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        setContentView(binding.root)
        restoreBundle()
    }

    private fun restoreBundle() {
//        workDuration = intent.getIntExtra(EXTRA_WORK_DURATION, 0)
//        shortBreakDuration = intent.getIntExtra(EXTRA_SHORT_BREAK_DURATION, 0)
//        longBreakDuration = intent.getIntExtra(EXTRA_LONG_BREAK_DURATION, 0)
        config = intent.getParcelableExtra(EXTRA_CONFIG)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PomodoroTheme {
        Greeting("Android")
    }
}