package com.architectcoders.pinpoint.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.architectcoders.pinpoint.navigation.BottomNavigationScreen
import com.architectcoders.pinpoint.ui.home.HomeScreen
import com.architectcoders.pinpoint.ui.near.NearScreen
import com.architectcoders.pinpoint.ui.theme.white

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavigationScreen.Home,
        BottomNavigationScreen.Search,
        BottomNavigationScreen.Favourites,
        BottomNavigationScreen.Near
    )

    Scaffold(
        bottomBar = { BottomBar(navController, bottomNavItems) }
    ) {
        MainScreenNavConfigurations(navController, it)
    }
}

@Composable
fun MainScreenNavConfigurations(
    navController: NavHostController,
    padding: PaddingValues
) {
    Box(Modifier.padding(padding)) {
        NavHost(
            navController = navController,
            startDestination = BottomNavigationScreen.Home.route
        ) {
            composable(BottomNavigationScreen.Home.route) { HomeScreen() {} }
            composable(BottomNavigationScreen.Search.route) { Text("Search") }
            composable(BottomNavigationScreen.Favourites.route) { Text("Favourites") }
            composable(BottomNavigationScreen.Near.route) { NearScreen() }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomNavItems: List<BottomNavigationScreen>
) {
    var currentRoute by remember { mutableStateOf(BottomNavigationScreen.Home.route) }
    BottomNavigation {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, stringResource(id = screen.title)) },
                label = { BottomBarLabel(label = screen.title) },
//                label = { Text(text = stringResource(id = screen.title)) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        currentRoute = screen.route
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun BottomBarLabel(@StringRes label: Int) {
    Text(
        text = stringResource(id = label),
        color = white,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(widthDp = 250)
@Composable
fun Preview() {
    MainScreen()
}
