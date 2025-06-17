package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puisigabungan.R

@Composable
fun Page3Screen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.una),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Text(
                    text = "A",
                    fontSize = 50.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 25.dp)
                )
                Text(
                    text = "Kalau sampai waktuku\n" +
                            "‘Ku mau tak seorang‘kan merayu\n" +
                            "Tidak juga kau\n" +
                            "Tak perlu sedu sedan itu",
                    fontSize = 15.sp,
                    color = Color.White,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "K",
                    fontSize = 50.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 25.dp)
                )
                Text(
                    text = "Aku ini binatang jalang\n" +
                            "Dari kumpulannya terbuang\n" +
                            "Biar peluru menembus kulitku\n" +
                            "Aku tetap meradang menerjang\n",
                    fontSize = 15.sp,
                    color = Color.White
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "U",
                    fontSize = 50.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 25.dp)
                )
                Text(
                    text = "Luka dan bisa kubawa berlari\n" +
                            "Berlari\n" +
                            "Hingga hilang pedih peri\n" +
                            "Dan aku akan lebih tidak perduli\n" +
                            "Aku mau hidup seribu tahun lagi.",
                    fontSize = 15.sp,
                    color = Color.White
                )
            }

            Text(
                text = "-Chairil Anwar, 1943",
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Kembali ke Menu")
            }
        }
    }
}
