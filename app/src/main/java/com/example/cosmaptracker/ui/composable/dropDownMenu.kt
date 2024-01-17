package com.example.cosmaptracker.ui.composable

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun dropDownMenu() {
    // The List to display - Fake data for now
    var locations = listOf<String>("Location 1", "Location 2", "Location 3")

    var isExpanded by remember { mutableStateOf(false) }
    var startLocation by remember { mutableStateOf("") }
    var endLocation by remember { mutableStateOf("") }


    Box() {
        // DropDown Menu displaying the starting location
        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { expanded ->
            isExpanded = expanded

        }) {
            // Wrapping into CompositionLocalProvider to prevent Keyboard to open
            CompositionLocalProvider(LocalTextInputService provides null) {
                OutlinedTextField(
                    value = startLocation,
                    readOnly = true,
                    onValueChange = { startLocation = it },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                    label = { Text("Start") },
                    placeholder = { Text("Select the starting location") },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    modifier = Modifier
                        .menuAnchor(),
                )
            }
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                },
                modifier = Modifier.background(Color.Transparent)
            )
            {
                /* TODO: Add the list of locations here
                * For loop for each location and create the items or LazyColumn
                */
                locations.forEachIndexed { index, location ->
                    DropdownMenuItem(
                        text = { Text(location) },
                        onClick = { startLocation = location; isExpanded = false })
                }

            }
        } // End of ExposedDropdownMenuBox
    } // End of Box

} // End of dropDownMenu


@Composable
@Preview
fun dropDownMenuPreview() {
    dropDownMenu()
}