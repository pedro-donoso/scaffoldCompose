package com.example.material3app

//importaciones necesarias
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

                var showDialog by remember {
                    mutableStateOf(false)
                }

                if (showDialog) {
                    Material3AlertDialog()
                }

                //estructura de la pantalla
                Scaffold(

                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            showDialog = true
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = null
                            )
                        }
                    },
                    //barra de navegacion superior
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
                        //agrega un scroll vertical
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .verticalScroll(rememberScrollState())
                        ) {
                            //agrega tarjetas
                            MaterialDogCard()
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
            //iconos de la barra de navegacion
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

        //estilos de la barra de navegacion
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
fun Material3AlertDialog() {
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = { }) {
                Text(text = "Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = { }) {
                Text(text = "Cancelar")
            }
        },
        title = {
            Text(text = "Call My Dog")
        },
        text = {
            Text(text = "Do you want to call my dog?")
        }
    )
}

@Composable
//tarjeta de material3
fun MaterialDogCard() {
    //estado de la tarjeta
    var expanded by remember {
        mutableStateOf(false) }

    //estructura de la tarjeta
    Card(
        //acciones de la tarjeta
        onClick = {
            expanded = !expanded
        },
        //estilos de la tarjeta
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        //espacio alrededor de la tarjeta
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        //contenido de la tarjeta
        Box(
            //estilos del contenido de la tarjeta
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {
            //imagen de la tarjeta
            Column {
                val dogUrl = "https://images.unsplash.com/photo-1452441271666-5d998aa2f6cc?q=80&w=1771&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

                // descripcion de la imagen de la tarjeta
                AsyncImage(
                    model = dogUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                )

                //texto de la tarjeta
                Text(
                    text = "This is my Dog!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                )

                //descripcion de la tarjeta
                val description = "Los perros, esos seres peludos y leales, han sido nuestros compañeros desde tiempos inmemoriales que nos enseñan sobre la lealtad, la alegría y la amistad incondicional. Los perros nos recuerdan que la vida es mejor cuando compartimos momentos con quienes amamos."

                //propiedades del texto de la tarjeta
                Text(
                    text = description,
                    fontSize = 15.sp,
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
//barra de navegacion inferior
fun Material3BottomAppBar() {
    //estructura de la barra de navegacion
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        actions = {
            //iconos de la barra de navegacion
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


