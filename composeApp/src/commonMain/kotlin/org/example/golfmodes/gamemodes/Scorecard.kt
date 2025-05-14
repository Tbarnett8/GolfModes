package org.example.golfmodes.gamemodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.Scorecard

@Composable
fun ScorecardScreen(
    scorecard: Scorecard,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val players = (1..scorecard.playersNum).map { it }
        val tableData = (1..18).map { it.toString() }
        LazyColumn(Modifier.fillMaxSize().padding(10.dp)) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().background(Colors.AppPrimary),
                ) {
                    FilledTableItem(Modifier.weight(1f).bottomBorder(1.dp, Colors.AppAccent), "Hole")
                    players.forEach {
                        FilledTableItem(Modifier.weight(1f).leftBorder(1.dp, Colors.AppAccent), "Player $it")
                    }
                }
            }
            items(tableData) {
                Row(Modifier.fillMaxWidth().background(Colors.AppPrimary)) {
                    FilledTableItem(Modifier.weight(1f).bottomBorder(1.dp, Colors.AppAccent), it)
                    players.forEach { _ ->
                        EmptyTableItem(
                            Modifier.weight(1f),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FilledTableItem(
    modifier: Modifier,
    text: String
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = text,
            color = Colors.TextPrimary
        )
    }
}

@Composable
fun EmptyTableItem(
    modifier: Modifier,
) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = modifier.background(Colors.AppAccent)
            .bottomBorder(1.dp, Colors.AppPrimary)
            .leftBorder(1.dp, Colors.AppPrimary),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            modifier = Modifier.wrapContentSize(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            value = text,
            onValueChange = { text = it },
        )
    }
}

fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx/2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width , y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)

fun Modifier.leftBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx/2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = 0f , y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)