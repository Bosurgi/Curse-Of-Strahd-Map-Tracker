package com.example.cosmaptracker.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cosmaptracker.ui.composable.CalculateButton
import com.example.cosmaptracker.ui.composable.DistanceBox
import com.example.cosmaptracker.ui.composable.DropDownMenu
import kotlinx.coroutines.launch

@Composable
fun Home(viewModel: HomeViewModel) {


    var distance by remember { mutableStateOf("0") }
    var time by remember { mutableIntStateOf(0) }

    val calculatedDistance by viewModel.calculatedDistanceFlow.collectAsState(initial = null)

    LaunchedEffect(calculatedDistance) {
        if (calculatedDistance != null) {
            distance = calculatedDistance.toString()
            time = viewModel.getTime()
        } else {
            distance = "0"
            time = 0
        }
    }
// To launch a coroutine from a composable later.
    val coroutineScope = rememberCoroutineScope()

    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize(),
        ) {
            HomeHeader()

            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                DropDownMenu(viewModel)
                CalculateButton(
                    startLocation = viewModel.getStartLocation(),
                    endLocation = viewModel.getEndLocation(),
                    onClick = { startLocation, endLocation ->
                        if (startLocation != null && endLocation != null) {
                            // Getting the Distance from coroutine.
                            coroutineScope.launch {
                                viewModel.getDistance(startLocation, endLocation)
                            }
                        }
                    }
                )
                DistanceBox(distance = distance, time = time)
            }
        }
    }
}

//@Composable
//@Preview
//fun homePreview() {
//    Home()
//}