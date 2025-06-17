package com.example.puisigabungan.repository

import android.util.Log
import com.example.puisigabungan.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class UserRepository {
    private val db = Firebase.firestore
    private val userCollection = db.collection("users")

    fun fetchUsers(onSuccess: (List<User>) -> Unit) {
        userCollection.get()
            .addOnSuccessListener { result ->
                val users = result.map { doc ->
                    User(
                        id = doc.id,
                        username = doc.getString("username") ?: "",
                        password = doc.getString("password") ?: "",
                        role = doc.getString("role") ?: ""
                    )
                }
                onSuccess(users)
            }
    }

    fun addUser(user: User, onSuccess: () -> Unit) {
        val id = user.id.ifBlank { userCollection.document().id }
        val newUserData = mapOf(
            "id" to id,
            "username" to user.username,
            "password" to user.password,
            "role" to user.role
        )
        userCollection.document(id).set(newUserData)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.e("Firestore", "Failed to add user", it) }
    }

    fun updateUser(user: User, onSuccess: () -> Unit) {
        val updatedData = mapOf(
            "username" to user.username,
            "password" to user.password,
            "role" to user.role
        )
        userCollection.document(user.id).set(updatedData)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.e("Firestore", "Failed to update user", it) }
    }

    fun deleteUser(userId: String, onSuccess: () -> Unit) {
        userCollection.document(userId).delete()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { Log.e("Firestore", "Failed to delete user", it) }
    }
}
