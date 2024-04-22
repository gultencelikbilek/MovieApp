package com.example.movieapp.presentation.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.movieapp.R

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    val modifier = Modifier
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.banner_img),
            contentDescription = "banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White.copy(0.4f), RoundedCornerShape(20.dp))
                .border(0.5.dp, Color.White, RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val offset = Offset(10.0f, 10f)
            Text(
                text = stringResource(id = R.string.banner_header),
                modifier = Modifier.padding(vertical = 25.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 34.sp,
                    shadow = Shadow(color = Color(0xFFFC5A03), offset = offset, blurRadius = 3f),
                    textAlign = TextAlign.Center
                )
            )

            Button(
                onClick = {
                      navHostController.navigate("movie_list_screen")
                },
                modifier
                    .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .background(Color.Gray.copy(0.8f), RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(
                            3.dp,
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFB226E1),
                                    Color(0xFFFC6603),
                                    Color(0xFF5995EE),
                                    Color(0xFF3D3535)
                                )
                            )

                        ),
                        RoundedCornerShape(16.dp)
                    ),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Get In",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
            }

        }
    }
}