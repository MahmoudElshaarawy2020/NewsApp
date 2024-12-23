package com.example.newsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R

@Composable
fun SourceCard(
    sourceName: String,
    isSelected: Boolean = false,
    onClick: (Boolean) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .clickable { onClick(!isSelected) } // Toggle selection on click
            .padding(1.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = if (isSelected) 8.dp else 2.dp
    ) {
        Box(
            modifier = if (isSelected) {
                Modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(R.color.green),
                            colorResource(R.color.teal_200)
                        )
                    )
                )
            } else {
                Modifier.background(color = Color.LightGray)
            }.padding(16.dp),

        ) {
            Text(
                text = sourceName,
                color = if (isSelected) Color.White else Color.DarkGray, // Text color changes
                fontSize = 16.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, // Bold if selected
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SelectableSourceCard() {
    var isSelected by remember { mutableStateOf(false) }

    SourceCard(
        sourceName = "Selectable Source",
        isSelected = isSelected,
        onClick = { newState -> isSelected = newState }
    )
}

@Preview(showBackground = true)
@Composable
fun SourceCardPreview() {
    Column {
        SelectableSourceCard() // Card with click handling
    }
}
