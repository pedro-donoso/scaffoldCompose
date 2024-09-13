package com.example.material3app.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
//pantalla de configuracion
fun SettingScreen() {

    //estado del campo de texto
    var userName by remember {

        //valor inicial del campo de texto
        mutableStateOf("")
    }

    //estructura de la pantalla
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(20.dp)
    ) {

        //texto de la pantalla
        Text(text = "Your Dog's name is: $userName")

        //campo de texto
        TextField(
            value = userName,
            label = {
                Text(text = "Add your name here")
            },
            placeholder = {
                Text(text = "Dog name")
            },
            onValueChange = { newValue ->
                userName = newValue
            },
            isError = userName.isEmpty()
        )

        Spacer(modifier = Modifier.height(30.dp))

        var composeSelected by remember {
            mutableStateOf(false)
        }

        var xmlSelected by remember {
            mutableStateOf(false)
        }

        var playfulSelected by remember {
            mutableStateOf(false)
        }

        Text(text = "Characteristics of your dog: ")

        Row {
            FilterChip(
                selected = composeSelected,
                onClick = {
                    composeSelected = !composeSelected
                },
                label = {
                    Text(text = "Puppy")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = composeSelected) {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.padding(15.dp))

            FilterChip(
                selected = xmlSelected,
                onClick = {
                    xmlSelected = !xmlSelected
                },
                label = {
                    Text(text = "Rescued")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = xmlSelected) {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.padding(15.dp))

            FilterChip(
                selected = playfulSelected,
                onClick = {
                    playfulSelected = !playfulSelected
                },
                label = {
                    Text(text = "Playful")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = playfulSelected) {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        var composeSkills by remember {
            mutableFloatStateOf(1f)
        }

        Text(text = "Your Dog's age: ${composeSkills.toInt()}")

        Slider(
            value = composeSkills, onValueChange = { newValue ->
                composeSkills = newValue
            },
            steps = 4,
            valueRange = 1f..5f
        )

        Spacer(modifier = Modifier.height(30.dp))

        var darkModeEnabled by remember {
            mutableStateOf(false)
        }

        Text(text = "I agree to take care of him: $darkModeEnabled")

        Switch(
            thumbContent = {
                AnimatedVisibility(visible = darkModeEnabled) {
                    Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null)
                }
            },
            checked = darkModeEnabled, onCheckedChange = { newValue ->
            darkModeEnabled = newValue
        }
        )
    }
}