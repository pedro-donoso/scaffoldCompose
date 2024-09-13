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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

        var selectedOption by remember {
            mutableStateOf("")
        }

        Row {
            FilterChip(
                selected = selectedOption == "Compose",
                onClick = {
                    selectedOption = "Compose"
                },
                label = {
                    Text(text = "Compose")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = selectedOption == "Compose") {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )

            Spacer(modifier = Modifier.padding(15.dp))

            FilterChip(
                selected = selectedOption == "XML",
                onClick = {
                    selectedOption = "XML"
                },
                label = {
                    Text(text = "XML")
                },
                leadingIcon = {
                    AnimatedVisibility(visible = selectedOption == "XML") {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    }
                }
            )
        }
    }
}