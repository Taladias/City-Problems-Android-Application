package com.example.cityproblemsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cityproblemsapplication.ui.theme.CityProblemsApplicationTheme
import com.example.cityproblemsapplication.ui.theme.righteousFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityProblemsApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CityProblemsApplicationScreen()
                }
            }
        }
    }
}

@Composable
fun CityProblemsApplicationScreen() {
         Image(
            painter = painterResource(R.drawable.city_background),
            contentDescription = "image of a city",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(34.dp)
        ) {
            Text(
                text = "City Issues",
                fontSize = 50.sp,
                fontFamily = righteousFontFamily,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Text(
                text = "Report issues in our city quickly and easily, helping us keep our community safe and well-maintained.",
                fontSize = 24.sp,
                fontFamily = righteousFontFamily,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(250.dp)

            )

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp)


            ) {
                Text(
                    text = "Report a problem",
                    fontFamily = righteousFontFamily,
                    fontSize = 23.sp
                )
            }

            Spacer(
                modifier = Modifier
                    .height(100.dp)

            )

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(56.dp)

            )
            {
                Text(
                    text = "View problems",
                    fontFamily = righteousFontFamily,
                    fontSize = 23.sp
                )
            }
        }

}







