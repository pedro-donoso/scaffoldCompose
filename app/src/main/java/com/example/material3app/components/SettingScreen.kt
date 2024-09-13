package com.example.material3app.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
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
        Text(text = "Your user name is: $userName")

        //campo de texto
        TextField(
            value = userName,
            label = {
                Text(text = "Add your name here")
            },
            placeholder = {
                Text(text = "User name")
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

        Row {
            FilterChip(
                selected = composeSelected,
                onClick = {
                    composeSelected = !composeSelected
                },
                label = {
                    Text(text = "Compose")
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
                    Text(text = "XML")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = xmlSelected) {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        var composeSkills by remember {
            mutableFloatStateOf(1f)
        }

        Text(text = "Compose Skills: ${composeSkills.toInt()}")

        Slider(
            value = composeSkills, onValueChange = {newValue ->
            composeSkills = newValue
        },
            steps = 4,
            valueRange = 1f..5f
        )
    }
}