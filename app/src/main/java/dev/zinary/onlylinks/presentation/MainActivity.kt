package dev.zinary.onlylinks.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.outlined.AirlineSeatFlatAngled
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.zinary.hacx0rn3wz.ui.theme.OnlyLinksTheme
import dev.zinary.onlylinks.presentation.about.AboutScreen
import dev.zinary.onlylinks.presentation.home.add_edit_url.UrlScreen
import dev.zinary.onlylinks.presentation.home.categories.CategoriesScreen
import dev.zinary.onlylinks.presentation.home.LinksScreen
import dev.zinary.onlylinks.presentation.settings.SettingsScreen

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bottomBarScreens = listOf(
            Screens.Links,
            Screens.Categories,
            Screens.Settings,
        )

        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }

            OnlyLinksTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                val showBottomBar = navController.currentBackStackEntryAsState()
                    .value?.destination?.route in bottomBarScreens.map { it.route }
                Log.i("OnlyLinksTheme", "onCreate: ")
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    NavigationRail() {
                        NavigationRailItem(
                            selected = false,
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.AirlineSeatFlatAngled,
                                    contentDescription = null,
                                )
                            },
                        )
                    }
                    Scaffold(
                        bottomBar = {
                            if (showBottomBar) {
                                NavigationBar(
                                    containerColor = MaterialTheme.colorScheme.background,
                                ) {
                                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                                    val currentDestination = navBackStackEntry?.destination
                                    bottomBarScreens.forEach { screen ->
                                        NavigationBarItem(
                                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                            onClick = {
                                                navController.navigate(screen.route) {
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            },
                                            icon = {
                                                Icon(
                                                    screen.icon ?: Icons.Default.BrokenImage,
                                                    contentDescription = null,
                                                )
                                            },
                                            label = {
                                                Text(text = stringResource(id = screen.resourceId))
                                            },
                                        )
                                    }
                                }
                            }
                        },
                    ) { innerPadding ->
                        NavHost(
                            navController,
                            startDestination = Screens.Links.route,
                            Modifier.padding(innerPadding),
                        ) {
                            composable(Screens.Links.route) {
                                LinksScreen(
                                    onLinkItemClick = { route ->
                                        navController.navigate(route)
                                    },
                                    onThemeChange = {
                                        isDarkTheme = !isDarkTheme
                                    },
                                    isDarkTheme = isDarkTheme,
                                )
                            }
                            composable(Screens.Categories.route) { CategoriesScreen(/*...*/) }
                            composable(Screens.Settings.route) {
                                SettingsScreen { screen ->
                                    navController.navigate(screen.route) {
                                        launchSingleTop = true
                                    }
                                }
                            }
                            composable(Screens.Link.route) { UrlScreen(1) }
                            composable(Screens.About.route) { AboutScreen() }
                        }
                    }
                }
            }
        }
    }
}
