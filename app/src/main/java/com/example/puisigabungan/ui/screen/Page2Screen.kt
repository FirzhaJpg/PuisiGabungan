package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puisigabungan.R

@Composable
fun Page2Screen(navController: NavController) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.aww),
                contentDescription = "Background Puisi",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .graphicsLayer(alpha = 1f)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Rasa Yang Tak Terucap",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 30.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = """
                Aku mencintaimu dalam rahasia,
                seperti hujan yang jatuh tanpa suara.
                Menatapmu dari kejauhan,
                menyadari kau mungkin bukan untukku.

                Andai saja waktu berpihak padaku,
                andai saja takdir memberi celah,
                mungkin aku bisa menggenggam tanganmu,
                bukan hanya memandang dan berandai-andai.
            """.trimIndent(),
                                color = Color.White,
                                fontSize = 13.sp
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {
                            Text(
                                text = """
                Kau tersenyum, tapi bukan untukku,
                kau berbicara, tapi bukan namaku yang kau sebut.
                Aku hanya angin yang singgah sebentar,
                sementara hatimu berlabuh di tempat lain.

                Tapi aku sadar,
                cinta tak selalu tentang memiliki,
                kadang ia hanya tentang merelakan,
                dan meski hati ini tak pernah benar-benar siap.
            """.trimIndent(),
                                color = Color.White,
                                fontSize = 13.sp
                            )
                        }
                    }


                    Text(
                        text = "~ Jonathan 2K25",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

                Button(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text("Pergi ke Home")
                }
            }
        }
    }
}
