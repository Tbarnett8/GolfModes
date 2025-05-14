package org.example.golfmodes.gamemodes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.GolfModeItem
import org.example.golfmodes.common.Scorecard

@Composable
fun GameScreen(
    mode: GolfModeItem,
    navigateToScorecard: (Scorecard) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = mode.name,
            color = Colors.TextPrimary,
            fontSize = 36.sp
        )
        var selectedIndex by remember { mutableIntStateOf(0) }
        val options = listOf("1", "2", "3","4")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex,
                    label = { Text(
                        text = label,
                        color = if (selectedIndex == index) Colors.TextPrimary else Colors.AppBackground
                    ) },
                    colors = SegmentedButtonColors(
                        activeBorderColor = Colors.AppAccent,
                        activeContainerColor = Colors.AppPrimary,
                        activeContentColor = Colors.TextPrimary,
                        inactiveContentColor = Colors.AppBackground,
                        inactiveBorderColor = Colors.AppAccent,
                        inactiveContainerColor = Colors.AppPrimary,
                        disabledActiveContainerColor = Colors.AppBackground,
                        disabledActiveContentColor = Colors.AppBackground,
                        disabledActiveBorderColor = Colors.AppBackground,
                        disabledInactiveContainerColor = Colors.AppBackground,
                        disabledInactiveContentColor = Colors.AppBackground,
                        disabledInactiveBorderColor = Colors.AppBackground
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable(
                    onClick = { navigateToScorecard(Scorecard(mode.mode, selectedIndex + 1)) }
                )
                .border(BorderStroke(1.dp, Colors.AppAccent), RoundedCornerShape(10.dp))
                .background(Colors.AppPrimary, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(vertical = 80.dp),
                text = "Go to Scorecard",
                color = Colors.TextPrimary,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("1", "2", "3","4")

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}