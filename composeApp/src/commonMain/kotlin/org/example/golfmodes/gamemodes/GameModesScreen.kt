package org.example.golfmodes.gamemodes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Game Modes",
            color = Colors.TextPrimary,
            fontSize = 36.sp
        )
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Colors.AppBackground),
            columns = GridCells.Fixed(2)
        ) {
            items(Lists.golfModesList) {
                val buttonShape = RoundedCornerShape(10.dp)
                Button(
                    modifier = Modifier.padding(10.dp)
                        .border(BorderStroke(1.dp, Colors.AppAccent), buttonShape),
                    onClick = { onGameClick(it) },
                    elevation = ButtonDefaults.elevation(20.dp),
                    shape = buttonShape,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Colors.AppPrimary,
                        contentColor = Colors.TextPrimary,
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 60.dp),
                        text = it.name
                    )
                }
            }
        }
    }
}