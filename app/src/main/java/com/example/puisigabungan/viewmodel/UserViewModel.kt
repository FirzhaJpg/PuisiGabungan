package com.example.puisigabungan.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.puisigabungan.model.User
import com.example.puisigabungan.repository.UserRepository

class UserViewModel : ViewModel() {
    private val repository = UserRepository()
    private val _users = mutableStateListOf<User>()
    val users: List<User> get() = _users

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        repository.fetchUsers { userList ->
            _users.clear()
            _users.addAll(userList)
        }
    }

    fun addUser(username: String, password: String, role: String) {
        val user = User(username = username, password = password, role = role)
        repository.addUser(user) { fetchUsers() }
    }

    fun updateUser(user: User) {
        repository.updateUser(user) { fetchUsers() }
    }

    fun deleteUser(userId: String) {
        repository.deleteUser(userId) {
            _users.removeAll { it.id == userId }
        }
    }
}
