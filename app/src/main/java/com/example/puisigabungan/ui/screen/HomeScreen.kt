package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puisigabungan.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Kumpulan Puisi",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            val buttonModifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)

            val buttonColors = ButtonDefaults.buttonColors(
                containerColor = Color(0xAA0288D1),
                contentColor = Color.White
            )

            val judulPuisi = listOf(
                "Firzha", "Jonathan", "Waode", "Daffa", "Nashira",
                "Mine", "Eka", "Adrian", "Nabhan", "Segap"
            )

            val destinations = listOf(
                "page1", "page2", "page3", "page4","page5",
                "page6", "page7", "page8", "page9", "page10"
            )

            judulPuisi.zip(destinations).forEach { (title, route) ->
                Button(
                    onClick = { navController.navigate(route) },
                    modifier = buttonModifier,
                    colors = buttonColors
                ) {
                    Text(text = title)
                }
            }
        }
    }
}