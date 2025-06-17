package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puisigabungan.R


@Composable
fun Page7Screen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.pus1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Judul dan pengarang
            Text(
                text = "My Little Feline",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "me",
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Dua kolom bait utama
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    listOf(
                        "By the window, you sit so still,",
                        "Eyes so bright, yet calm and chill.",
                        "Tail sways gently, soft and free,",
                        "Chasing away the loneliness in me."
                    ).forEach {
                        Text(
                            text = it,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    listOf(
                        "You leap and dance so wild, so free,",
                        "Chasing shadows far and near.",
                        "Then rest beside, so close to me,",
                        "Curled up warm, where love resides."
                    ).forEach {
                        Text(
                            text = it,
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bait penutup
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                listOf(
                    "Oh, little cat, so sweet, so true,",
                    "Every day feels bright with you.",
                    "Your gentle purr, your loving gaze,",
                    "Fill my heart in countless ways."
                ).forEach {
                    Text(
                        text = it,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol kembali
            Button(onClick = { navController.popBackStack() }) {
                Text("Kembali")
            }
        }
    }
}
