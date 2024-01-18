package com.example.cosmaptracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cosmaptracker.R

@Composable
fun homeHeader() {
    Surface {


        val uiColour = if (isSystemInDarkTheme()) Color.White else Color.Black

        Row {
            Image(
                painter = painterResource(id = R.drawable.strahdfamilycrest),
                contentDescription = null,
                modifier = Modifier
                    .size(136.dp)
                    .fillMaxSize()
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
                    .align(Alignment.CenterVertically),

                text = stringResource(id = R.string.home_message),
                fontSize = 36.sp,
                color = uiColour,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
            )
        }
    }

}

@Preview
@Composable
fun headerPreview() {
    homeHeader()
}