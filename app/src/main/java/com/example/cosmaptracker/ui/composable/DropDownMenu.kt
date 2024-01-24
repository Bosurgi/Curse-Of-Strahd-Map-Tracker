package com.example.cosmaptracker.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.unit.dp
import com.example.cosmaptracker.data.Location
import com.example.cosmaptracker.ui.screens.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DropDownMenu(viewModel: HomeViewModel) {
    // The List to display - Fake data for now

    var isStartExpanded by remember { mutableStateOf(false) }
    var isDestinationExpanded by remember { mutableStateOf(false) }

    val locations = viewModel.getAllLocations()
    var startLocation by remember { mutableStateOf("") }
    var endLocation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        // DropDown Menu displaying the starting location
        ExposedDropdownMenuBox(
            expanded = isStartExpanded,
            onExpandedChange = { expanded -> isStartExpanded = expanded },
            // Adding some distance between the two DropDown Menus
            modifier = Modifier.padding(top = 16.dp, bottom = 40.dp)
        ) {
            // Wrapping into CompositionLocalProvider to prevent Keyboard to open
            CompositionLocalProvider(LocalTextInputService provides null) {
                OutlinedTextField(
                    value = startLocation,
                    readOnly = true,
                    onValueChange = { startLocation = it },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isStartExpanded) },
                    label = { Text("Start") },
                    placeholder = { Text("Select the starting location") },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    modifier = Modifier
                        .menuAnchor(),
                )
            }
            ExposedDropdownMenu(
                expanded = isStartExpanded,
                onDismissRequest = {
                    isStartExpanded = false
                },
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
            )
            {
                LocationDropDownList(locations, onItemClick = { selectedLocation ->
                    startLocation = selectedLocation.name;
                    // Sets the start Location in the ViewModel
                    viewModel.startLocation = selectedLocation
                }, onExpandedChange = { isStartExpanded = it })
            } // End of Column
        } // End of ExposedDropdownMenuBox

        // DropDown Menu displaying the destination location
        ExposedDropdownMenuBox(expanded = isDestinationExpanded,
            onExpandedChange = { expanded ->
                isDestinationExpanded = expanded
            }
        ) {
            // Wrapping into CompositionLocalProvider to prevent Keyboard to open
            CompositionLocalProvider(LocalTextInputService provides null) {
                OutlinedTextField(
                    value = endLocation,
                    readOnly = true,
                    onValueChange = { endLocation = it },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDestinationExpanded) },
                    label = { Text("Destination") },
                    placeholder = { Text("Select the destination") },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    modifier = Modifier
                        .menuAnchor(),
                )
            }
            ExposedDropdownMenu(
                expanded = isDestinationExpanded,
                onDismissRequest = {
                    isDestinationExpanded = false
                },
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
            )
            {
                LocationDropDownList(locations, onItemClick = { selectedLocation ->
                    endLocation = selectedLocation.name;
                    // Sets the start Location in the ViewModel
                    viewModel.endLocation = selectedLocation
                }, onExpandedChange = { isDestinationExpanded = it })
            }
        } // End of ExposedDropdownMenuBox

    } // End of Column

} // End of dropDownMenu

@Composable
private fun LocationDropDownList(
    locations: List<Location>,
    onItemClick: (Location) -> Unit,
    onExpandedChange: (Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .width(200.dp)
            .height(150.dp)
    ) {
        items(locations) {
            DropdownMenuItem(
                text = { Text(it.name) },
                onClick = {
                    onItemClick(it)
                    onExpandedChange(false)
                }
            )
        }
    }
}


//@Composable
//@Preview
//fun dropDownMenuPreview() {
//    val barovia = Location("Barovia")
//    val vallaki = Location("Vallaki")
//    var locations = listOf<Location>(barovia, vallaki)
//    DropDownMenu(locations)
//}