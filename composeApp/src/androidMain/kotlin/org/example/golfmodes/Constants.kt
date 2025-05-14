package org.example.golfmodes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Attribution
import androidx.compose.material.icons.filled.Home

object Constants {
    val BottomNavItems = listOf(
        // Home screen
        BottomNavItem(
            label = "Home",
            icon = Icons.Default.Home,
            pageId = 1
        ),
        // Search screen
        BottomNavItem(
            label = "Game Modes",
            icon = Icons.Default.Apps,
            pageId = 2
        ),
        // Profile screen
        BottomNavItem(
            label = "Profile",
            icon = Icons.Default.Attribution,
            pageId = 3
        )
    )
}