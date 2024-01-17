package com.example.cosmaptracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cosmaptracker.ui.composable.dropDownMenu

@Composable
fun home() {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            homeHeader()
            
            Column(modifier = Modifier.align(Alignment.Center)) {
                dropDownMenu()
            }

        }
    }
}

@Composable
@Preview
fun homePreview() {
    home()
}