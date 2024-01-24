package com.example.cosmaptracker.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DistanceBox(distance: String, time: Int) {

    Column(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.small)
            .background(Color.LightGray, shape = MaterialTheme.shapes.small)
            .size(200.dp, 80.dp),
        // Space between the two elements are spaced evenly
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // First Row - Distance
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            // Distance - Description
            Text(
                textAlign = TextAlign.Justify,
                text = "Distance:",
                style = MaterialTheme.typography.bodyMedium,
            )

            // Distance - Value
            Text(
                textAlign = TextAlign.Justify,
                text = distance + " miles",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        // Second Row - Time
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            // Time - Description
            Text(
                textAlign = TextAlign.Justify,
                text = "Time:",
                style = MaterialTheme.typography.bodyMedium
            )

            // Time - Value
            Text(
                textAlign = TextAlign.Justify,
                text = time.toString() + " hours",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
@Preview
fun DistanceBoxPreview() {
    DistanceBox("10km", 10)
}