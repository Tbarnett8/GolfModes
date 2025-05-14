package org.example.golfmodes

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val pageId: Int,
)
