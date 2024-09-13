package com.example.material3app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    }
}