package org.example.golfmodes.mycareer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.golfmodes.common.CareerListItem
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.Lists.appSettings
import org.example.golfmodes.common.Lists.careerSettings

@Composable
fun MyCareerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormattedList("Career Information", careerSettings)
        FormattedList("App Settings", appSettings)
    }
}

@Composable
fun FormattedList(listName: String, list: List<CareerListItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(Colors.AppPrimary),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = listName,
            fontWeight = FontWeight.Bold,
            color = Colors.TextPrimary, // Slightly less intense black
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp) // Add padding around the label
        )
        list.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(vertical = 20.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = item.name,
                    color = Colors.TextPrimary,
                )
                if (item.showMore) {
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowForward,
                        contentDescription = "",
                        tint = Colors.TextPrimary
                    )
                }
            }
            if (index < careerSettings.lastIndex) {
                Divider(color = Colors.AppAccent, thickness = 1.dp)
            }
        }
    }
}