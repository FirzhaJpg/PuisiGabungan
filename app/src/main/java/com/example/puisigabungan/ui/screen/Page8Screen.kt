package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puisigabungan.R


@Composable
fun Page8Screen(navController: NavController) {
    // Puisi per bait
    val puisi = listOf(
        """
        Di pagi yang sunyi, aku melangkah,
        Menyusuri jalan penuh cerita,
        Angin berbisik lirih di telinga,
        Seolah ingin menahan langkahku sejenak.
        """,

        """
        Langit kadang cerah, kadang kelabu,
        Seperti hati yang tak selalu utuh,
        Namun kaki ini tetap melaju,
        Mengejar mimpi di ufuk jauh.
        """,

        """
        Kadang lelah, ingin berhenti,
        Namun harapan menyalakan lagi,
        Sebab hidup bukan sekedar berdiri,
        Tapi tentang terus berlari.
        """,

        """
        Di setiap jatuh, ada bangkit,
        Di setiap luka, ada pulih,
        Hingga suatu saat nanti,
        Aku tersenyum, sampai di titik yang kumimpi.
        """
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.lonelyman),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay hitam transparan
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        // Konten utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Judul
            Text(
                text = "Langkah Terus Berjalan",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Setiap bait puisi
            puisi.forEach { bait ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = bait.trimIndent(),
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Justify,
                        lineHeight = 22.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.navigate("home") }) {
                Text("Back")
            }
        }
    }
}
