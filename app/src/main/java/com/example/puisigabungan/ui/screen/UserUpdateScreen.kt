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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun UserUpdateScreen(
    navController: NavController,
    userToEdit: User? = null,
    viewModel: UserViewModel = viewModel()
) {
    var username by remember { mutableStateOf(userToEdit?.username ?: "") }
    var role by remember { mutableStateOf(userToEdit?.role ?: "") }
    var password by remember { mutableStateOf("") }

    val isEdit = userToEdit != null

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = if (isEdit) "Edit Pengguna" else "Tambah Pengguna",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(if (isEdit) "Password Baru (opsional)" else "Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = role,
            onValueChange = { role = it },
            label = { Text("Role") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isNotBlank() && role.isNotBlank() && (!isEdit || password.isNotBlank())) {
                    if (userToEdit != null) {
                        val updatedUser = userToEdit.copy(
                            username = username,
                            role = role,
                            password = if (password.isNotBlank()) password else userToEdit.password
                        )
                        viewModel.updateUser(updatedUser)
                    } else {
                        viewModel.addUser(username, password, role)
                    }
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = username.isNotBlank() && role.isNotBlank() && (!isEdit || password.isNotBlank())
        ) {
            Icon(Icons.Default.Check, contentDescription = "Simpan")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Simpan")
        }
    }
}
