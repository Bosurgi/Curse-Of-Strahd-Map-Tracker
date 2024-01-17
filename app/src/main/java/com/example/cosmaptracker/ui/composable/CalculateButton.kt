package com.example.cosmaptracker.ui.composable

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

@Composable
fun CalculateButton(onClick: () -> Unit) {
    ElevatedButton(
        onClick = { onClick() },
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
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

@Composable
@Preview
fun CalculateButtonPreview() {
    CalculateButton(onClick = {})
}