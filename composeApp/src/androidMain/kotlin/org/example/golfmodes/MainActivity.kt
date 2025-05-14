package org.example.golfmodes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.GolfModeItem
import org.example.golfmodes.common.Scorecard
import org.example.golfmodes.gamemodes.GameModesScreen
import org.example.golfmodes.gamemodes.GameScreen
import org.example.golfmodes.gamemodes.ScorecardScreen
import org.example.golfmodes.homepage.Homepage
import org.example.golfmodes.mycareer.MyCareerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) { padding ->
                    NavHostContainer(navController = navController, padding = padding)
                }
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = Modifier.padding(paddingValues = padding),

        builder = {
            composable<Home> {
                Homepage()
            }
            composable<GameModes> {
                GameModesScreen( onGameClick = { mode ->
                    navController.navigate(mode)
                })
            }
            composable<Profile> {
                MyCareerScreen()
            }
            composable<GolfModeItem> { navBackStackEntry ->
                val game: GolfModeItem = navBackStackEntry.toRoute()
                GameScreen(mode = game, navigateToScorecard = { scorecard ->
                    navController.navigate(scorecard)
                })
            }
            composable<Scorecard> { navBackStackEntry ->
                val scorecard: Scorecard = navBackStackEntry.toRoute()
                ScorecardScreen(scorecard = scorecard)
            }
        })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        tonalElevation = 10.dp,
        containerColor = Colors.AppPrimary
    ) {
        var currentPage by remember { mutableIntStateOf(1) }

        Constants.BottomNavItems.forEach { navItem ->

            NavigationBarItem(
                selected = currentPage == navItem.pageId,
                onClick = {
                    currentPage = navItem.pageId
                    when(navItem.pageId) {
                        1 -> navController.navigate(Home)
                        2 -> navController.navigate(GameModes)
                        3 -> navController.navigate(Profile)
                    }
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Colors.TextPrimary,
                    unselectedIconColor = Colors.AppBackground,
                    selectedTextColor = Colors.TextPrimary,
                    unselectedTextColor = Colors.AppBackground,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}