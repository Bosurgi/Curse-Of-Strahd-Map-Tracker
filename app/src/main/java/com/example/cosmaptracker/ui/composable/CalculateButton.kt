package com.example.cosmaptracker.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cosmaptracker.R
import com.example.cosmaptracker.data.Location

/***
 * Button to calculate the Distance between two points
 * @param startLocation: The starting location
 * @param endLocation: The ending location
 */
@Composable
fun CalculateButton(startLocation: Location?,
                    endLocation: Location?,
                    onClick: (startLocation: Location?, endLocation: Location?) -> Unit) {

    ElevatedButton(
        // On Click, using start and end locations to calculate distance
        onClick = { onClick(startLocation, endLocation) },

        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black,
        ),
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(text = "Calculate")
        Icon(
            painter = painterResource(id = R.drawable.calculator),
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp)
                .padding(horizontal = 2.dp),
            contentDescription = null,
            tint = Color.Black,
        )
    }
}

//@Composable
//@Preview
//fun CalculateButtonPreview() {
//    CalculateButton(onClick = {})
//}