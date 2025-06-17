package com.example.puisigabungan.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.puisigabungan.model.User
import com.example.puisigabungan.viewmodel.UserViewModel

@Composable
fun UserFormScreen(
    navController: NavController,
    userToEdit: User? = null,
    viewModel: UserViewModel = viewModel()
) {
    var username by remember { mutableStateOf(userToEdit?.username ?: "") }
    var role by remember { mutableStateOf(userToEdit?.role ?: "") }
    var password by remember { mutableStateOf("") }
    val isEdit = userToEdit != null

    Column(Modifier.padding(16.dp).fillMaxSize()) {
        Text(
            text = if (isEdit) "Edit User" else "Tambah User",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(16.dp))

        TextField(value = username, onValueChange = { username = it }, label = { Text("Username") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))

        if (!isEdit) {
            TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
        }

        TextField(value = role, onValueChange = { role = it }, label = { Text("Role") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (isEdit) {
                    val updatedUser = userToEdit!!.copy(username = username, role = role)
                    viewModel.updateUser(updatedUser)
                } else {
                    viewModel.addUser(username, password, role)
                }
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Check, contentDescription = "Simpan")
            Spacer(Modifier.width(8.dp))
            Text("Simpan")
        }
    }
}
