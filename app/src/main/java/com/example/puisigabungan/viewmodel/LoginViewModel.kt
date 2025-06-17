package com.example.puisigabungan.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    fun loginWithFirestore(username: String,password: String, onSuccess: (role: String) -> Unit,onError: (String) -> Unit)
    {
        val db = Firebase.firestore

        db.collection("users")
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val document = documents.first()
                    val storedPassword = document.getString("password")
                    val role = document.getString("role")

                    if (storedPassword == password) {
                        onSuccess(role ?: "unknown")
                    } else {
                        onError("Password salah")
                    }
                } else {
                    onError("User tidak ditemukan")
                }
            }
            .addOnFailureListener {
                onError("Terjadi kesalahan: ${it.message}")
            }
    }
}