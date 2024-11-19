package com.example.cityproblemsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cityproblemsapplication.ui.theme.CityProblemsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityProblemsApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CityProblemsApplication()
                }
            }
        }
    }
}

@Composable
fun CityProblemsApplication() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {HomeScreen(navController)}
        composable("submit_problem") {SubmitProblemScreen()}
    }

}

@Composable
fun HomeScreen(navController: NavController) {
    Image(
        painter = painterResource(R.drawable.city_background),
        contentDescription = "image of a city",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
            )
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
            //fontFamily = righteousFontFamily,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "Report issues in our city quickly and easily, helping us keep our community safe and well-maintained.",
            fontSize = 24.sp,
            //fontFamily = righteousFontFamily,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .height(250.dp)

        )

        Button(
            onClick = {navController.navigate("submit_problem")},
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp)
                .shadow(elevation = 16.dp, shape = RoundedCornerShape(20.dp))


        ) {
            Text(
                text = "Report a problem",
                //fontFamily = righteousFontFamily,
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
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(28.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD7998E)
            )

        )
        {
            Text(
                text = "View problems",
                //fontFamily = righteousFontFamily,
                fontSize = 23.sp
            )
        }
    }
}


@Composable
fun SubmitProblemScreen() {


    Image(
        painter = painterResource(R.drawable.city_background),
        contentDescription = "image of a city",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .blur(
                radiusX = 3.dp,
                radiusY = 3.dp,
                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
            )
    )

 Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Submit a Problem",
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

     AutoCompleteDropdown()

     Spacer(
         modifier = Modifier.height(300.dp)
     )

        Button(
            onClick = { /* Submit form to database */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Submit")
        }
    }
}


@Composable
fun AutoCompleteDropdown() {

    val problems = listOf(
        "Road Damage", "Sidewalk blocked", "Cracked sidewalk",
        "Collapsed or broken bridge", "Clogged drainage", "Public transport delay",
        "Non-functional traffic lights", "Overcrowded area", "Construction blockades",
        "Littered area", "Broken pipeline", "Power outage", "Noise pollution",
        "Broken streetlights"
    )

    var category by remember { mutableStateOf("") }

    val heightTextFields by remember { mutableStateOf(55.dp) }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    expanded = false
                }
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 3.dp, bottom = 2.dp),
            text = "Category",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(heightTextFields)
                        .border(
                            width = 1.8.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() },

                    value = category,
                    onValueChange = {
                        category = it
                        expanded = true
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(15.dp),
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Rounded.KeyboardArrowDown,
                                contentDescription = "arrow",
                                tint = Color.Black
                            )
                        }

                    }
                )

            }

            AnimatedVisibility(visible = expanded) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(textFieldSize.width.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {

                    LazyColumn(
                        modifier = Modifier.heightIn(max = 150.dp),
                    ) {

                        if (category.isNotEmpty()) {
                            items(
                                problems.filter {
                                    it.lowercase()
                                        .contains(category.lowercase()) || it.lowercase()
                                        .contains("others")
                                }
                                    .sorted()
                            ) {
                                CategoryItems(title = it) { title ->
                                    category = title
                                    expanded = false
                                }
                            }
                        } else {
                            items(
                                problems.sorted()
                            ) {
                                CategoryItems(title = it) { title ->
                                    category = title
                                    expanded = false
                                }
                            }
                        }

                    }

                }
            }

        }

    }

        }




@Composable
fun CategoryItems(
    title: String,
    onSelect: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(title)
            }
            .padding(10.dp)
    ) {
        Text(text = title, fontSize = 16.sp)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityProblemsScreenPreview(){
    CityProblemsApplicationTheme {
        SubmitProblemScreen()
    }
}







