package org.example.golfmodes.mycareer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.golfmodes.common.Colors
import org.example.golfmodes.common.Lists

@Composable
fun MyCareerScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "My Career",
            color = Colors.TextPrimary,
            fontSize = 36.sp
        )
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Lists.careerSettings.forEach {
                Row {
                    Text(
                        text = it.name,
                        color = Colors.TextPrimary
                    )
                    if (it.showMore){
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
                            contentDescription = "",
                            tint = Colors.TextPrimary
                        )
                    }
                }
            }
        }

    }
}