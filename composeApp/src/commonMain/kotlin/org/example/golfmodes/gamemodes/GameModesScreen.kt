package org.example.golfmodes.gamemodes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.GolfModeItem
import org.example.golfmodes.common.Lists


@Composable
fun GameModesScreen(
    onGameClick: (GolfModeItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(Lists.golfModesList) {
                GameButton(it, onGameClick)
            }
        }
    }
}

@Composable
fun GameButton(
    game: GolfModeItem,
    onGameClick: (GolfModeItem) -> Unit
) {
    val buttonShape = RoundedCornerShape(10.dp)
    var buttonWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Button(
        modifier = Modifier
            .onGloballyPositioned { layoutResult ->
                val widthInPixels = layoutResult.size.width
                buttonWidth = with(density) { widthInPixels.toDp() }
            }
            .height(buttonWidth)
            .border(BorderStroke(1.dp, Colors.AppAccent), buttonShape),
        onClick = { onGameClick(game) },
        elevation = ButtonDefaults.elevation(20.dp),
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Colors.AppPrimary,
            contentColor = Colors.TextPrimary,
        )
    ) {
        Text(
            text = game.name,
            textAlign = TextAlign.Center
        )
    }
}