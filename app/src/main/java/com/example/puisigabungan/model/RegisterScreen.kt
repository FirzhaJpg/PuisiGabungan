package com.example.puisigabungan.model

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val db = Firebase.firestore

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Register User", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        OutlinedTextField(value = role, onValueChange = { role = it }, label = { Text("Role (admin/user)") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (username.isNotBlank() && password.isNotBlank() && role.isNotBlank()) {
                val userData = hashMapOf(
                    "username" to username,
                    "password" to password,
                    "role" to role
                )
                db.collection("users")
                    .add(userData)
                    .addOnSuccessListener {
                        message = "User berhasil ditambahkan!"
                    }
                    .addOnFailureListener {
                        message = "Gagal tambah user: ${it.message}"
                    }
            } else {
                message = "Semua field harus diisi"
            }
        }) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (message.isNotBlank()) {
            Text(text = message, color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigateUp() }) {
            Text("Kembali ke Login")
        }
    }
}
