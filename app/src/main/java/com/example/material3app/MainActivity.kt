package com.example.material3app

//importaciones necesarias
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.material3app.ui.theme.Material3AppTheme

//extiende de ComponentActivity para poder usar el setContent
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3AppTheme {
                //estructura de la pantalla
                Scaffold(

                    floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = null
                            )
                        }
                    },
                    //barra de navegacion
                    topBar = {
                        Material3TopAppBar()
                    },
                    bottomBar = {
                        Material3BottomAppBar()
                    }
                ) { paddingValues ->
                    //contenido de la pantalla
                    Box(
                        //agrega espacio alrededor del contenido
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        ) {
                            MaterialDogCard()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3TopAppBar() {
    TopAppBar(
        //colores de la barra de navegacion
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        title = {
            //titulo de la barra de navegacion
            Text(text = "Mi Aplicacion")
        }
    )
}

@Composable
fun MaterialDogCard() {
    Card(
        onClick = { },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column {
                val dogUrl = "https://images.unsplash.com/photo-1452441271666-5d998aa2f6cc?q=80&w=1771&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                AsyncImage(
                    model = dogUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun Material3BottomAppBar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = null
                )
            }
        }

    )
}


