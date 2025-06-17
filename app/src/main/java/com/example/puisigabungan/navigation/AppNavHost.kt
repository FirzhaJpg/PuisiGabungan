package com.example.puisigabungan.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.puisigabungan.ui.screen.HomeScreen
import com.example.puisigabungan.ui.screen.Page1Screen
import com.example.puisigabungan.ui.screen.Page2Screen
import com.example.puisigabungan.ui.screen.Page3Screen
import com.example.puisigabungan.ui.screen.Page4Screen
import com.example.puisigabungan.ui.screen.Page5Screen
import com.example.puisigabungan.ui.screen.Page6Screen
import com.example.puisigabungan.ui.screen.Page7Screen
import com.example.puisigabungan.ui.screen.Page8Screen
import com.example.puisigabungan.ui.screen.Page9Screen
import com.example.puisigabungan.ui.screen.Page10Screen
import com.example.puisigabungan.model.RegisterScreen
import com.example.puisigabungan.model.User
import com.example.puisigabungan.ui.screen.LoginScreen
import com.example.puisigabungan.ui.screen.UserFormScreen
import com.example.puisigabungan.ui.screen.UserScreen
import com.example.puisigabungan.viewmodel.UserViewModel
import com.example.puisigabungan.ui.screen.UserUpdateScreen
import kotlin.collections.find

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier.fillMaxSize()
    ) {
        composable("home") { HomeScreen(navController)}
        composable("page1") { Page1Screen(navController) }
        composable("page2") { Page2Screen(navController)}
        composable("page3") { Page3Screen(navController)}
        composable("page4") { Page4Screen(navController)}
        composable("page5") { Page5Screen(navController)}
        composable("page6") { Page6Screen(navController) }
        composable("page7") { Page7Screen(navController) }
        composable("page8") { Page8Screen(navController) }
        composable("page9") { Page9Screen(navController) }
        composable("page10") { Page10Screen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("user") { UserScreen(navController) }
        composable("tambah_user") { UserFormScreen(navController) }
        composable("userform") { UserFormScreen(navController) }
        composable(
            route = "edit_user/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("id")
            val viewModel: UserViewModel = viewModel()
            val userToEdit = viewModel.users.find { it.id == userId }
            if (userToEdit != null) {
                UserUpdateScreen(navController = navController, userToEdit = userToEdit as User?, viewModel = viewModel)
            }
        }
    }
}