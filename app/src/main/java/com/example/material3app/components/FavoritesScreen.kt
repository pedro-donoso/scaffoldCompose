package com.example.material3app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun FavoriteScreen() {

    val image1 =
        "https://images.unsplash.com/photo-1422565096762-bdb997a56a84?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image2 =
        "https://images.unsplash.com/photo-1530281700549-e82e7bf110d6?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image3 =
        "https://images.unsplash.com/photo-1444212477490-ca407925329e?q=80&w=1856&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image4 =
    "https://images.unsplash.com/photo-1532592333381-a141e3f197c9?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image5 =
    "https://images.unsplash.com/photo-1510771463146-e89e6e86560e?q=80&w=1362&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image6 =
    "https://images.unsplash.com/photo-1507146426996-ef05306b995a?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image7 =
    "https://images.unsplash.com/photo-1561037404-61cd46aa615b?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val dogList = remember {
        mutableStateListOf(
            Dog(
                "Toto",
                image1
            ),
            Dog(
                "Chiquita",
                image2
            ),
            Dog(
                "Kira",
                image3
            ),
            Dog(
                "Lola",
                image4
            ),
            Dog(
                "Toby",
                image5
            ),
            Dog(
                "Nina",
                image6
            ),
            Dog(
                "Lulu",
                image7
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
    ) {
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dogList) { dog ->
                Card(
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(modifier = Modifier.height(200.dp)) {
                        
                        IconButton(
                            modifier = Modifier
                                .zIndex(1f)
                                .align(Alignment.TopEnd),
                            onClick = { }) {
                            Icon(imageVector = if (dog.isFavorite) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                                contentDescription = null)
                            
                        }
                        
                        AsyncImage(
                            model = dog.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        
//        LazyColumn {
//            items(dogList) { dog ->
//                Card(
//                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
//                ) {
//                    Box(modifier = Modifier.height(200.dp)) {
//                        AsyncImage(model = dog.image,
//                            contentDescription = null,
//                            contentScale = ContentScale.Crop
//                        )
//                    }
//                }
//            }
//        }
    }
}

data class Dog(
    val name: String,
    val image: String,
    val isFavorite: Boolean = false
)