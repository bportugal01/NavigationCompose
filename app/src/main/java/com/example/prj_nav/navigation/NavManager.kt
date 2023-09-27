package com.example.prj_nav.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.prj_nav.R
import com.example.prj_nav.components.MainIconButton
import com.example.prj_nav.components.TitleBar
import com.example.prj_nav.splash.SplashScreen
import com.example.prj_nav.view.DetailsView
import com.example.prj_nav.view.HomeView
import com.example.prj_navegacao.views.PerfilView


@Composable
fun NavManager(navController: NavHostController) {


    NavHost(
        navController = navController, startDestination = "Splash", modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        composable("Home") {
            HomeView(navController)
        }
        composable(
            "Detail/{id}/?{opcional}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("opcional") { type = NavType.StringType },
            )
        ) { navBackStackEntry ->
            val arguments = navBackStackEntry.arguments
            val id = arguments?.getInt("id") ?: 0
            val opcional = arguments?.getString("opcional") ?: ""
            DetailsView(navController, id, opcional)
        }
        composable(NavigationItem.Home.route) {
            HomeView(navController)
        }
        composable(NavigationItem.Config.route) {
            DetailsView(navController, id = 0, opcional = "")
        }
        composable(NavigationItem.Perfil.route) {
            PerfilView()
        }
        composable("Splash") {
            SplashScreen(
                navigateToStartChat = {
                    navController.navigate(NavigationItem.Home.route) {
                        popUpTo("Splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController) },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavManager(navController = navController)
            }
        }
    )
}


@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        title = { TitleBar(name = "Jetpack Compose") },
        backgroundColor = Color(0xFFc55676), // Alterado colors para backgroundColor
        navigationIcon = {
            MainIconButton(icon = Icons.Default.ArrowBack) {
                navController.popBackStack()
            }
        }
    )
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Perfil,
        NavigationItem.Config
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_700),
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(5.dp)
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationRoute ?: item.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
