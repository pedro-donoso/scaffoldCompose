package com.example.material3app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

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
        horizontalAlignment = Alignment.Start
    ){

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
        } )
    }
}