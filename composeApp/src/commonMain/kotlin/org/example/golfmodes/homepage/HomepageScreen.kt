package org.example.golfmodes.homepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.golfmodes.common.Colors

@Composable
fun Homepage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.AppBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Home",
            color = Colors.TextPrimary,
            fontSize = 36.sp
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            val buttonShape = RoundedCornerShape(10.dp)
            item {
                Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1f)
                            .clickable(
                                onClick = { TODO() }
                            )
                            .border(BorderStroke(1.dp, Colors.AppAccent), buttonShape)
                            .background(Colors.AppPrimary, buttonShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 80.dp),
                            text = "Promotion",
                            color = Colors.TextPrimary,
                            fontSize = 20.sp
                        )
                    }
            }
            item {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        color = Colors.TextPrimary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .weight(1f)
                                .background(Colors.AppPrimary, buttonShape)
                                .border(BorderStroke(1.dp, Colors.AppAccent), buttonShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                modifier = Modifier.padding(vertical = 40.dp),
                                imageVector = Icons.Default.Menu,
                                tint = Colors.TextPrimary,
                                contentDescription = ""
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .weight(1f)
                                .background(Colors.AppPrimary, buttonShape)
                                .border(BorderStroke(1.dp, Colors.AppAccent), buttonShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                modifier = Modifier.padding(vertical = 40.dp),
                                imageVector = Icons.Default.Menu,
                                tint = Colors.TextPrimary,
                                contentDescription = ""
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        color = Colors.TextPrimary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }