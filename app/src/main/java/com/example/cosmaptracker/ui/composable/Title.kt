package com.example.cosmaptracker.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cosmaptracker.R

@Composable
fun HomeHeader() {

    val uiColour = if (isSystemInDarkTheme()) Color.White else Color.Black
    val orientation = LocalConfiguration.current.orientation

    Row(verticalAlignment = Alignment.Top) {
        Image(
            painter = painterResource(id = R.drawable.strahdfamilycrest),
            contentDescription = null,
            modifier = Modifier
                .size(136.dp)
                .fillMaxWidth()
                .background(Color.Transparent)
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
            alpha = 0.8f,
            contentScale = ContentScale.FillWidth,
        )
        Text(
            modifier = Modifier
                .padding(end = 16.dp)
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .alignByBaseline()
                .align(Alignment.CenterVertically)
                .fillMaxWidth(),
            minLines = 2,

            text = stringResource(id = R.string.home_message),
            fontSize = 36.sp,
            color = uiColour,
            textAlign = if(orientation == Configuration.ORIENTATION_LANDSCAPE) TextAlign.Left else TextAlign.Center,
            style = MaterialTheme.typography.displayMedium,
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    HomeHeader()
}