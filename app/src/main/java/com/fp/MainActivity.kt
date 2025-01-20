package com.fp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fp.data.Datasource
import com.fp.model.Artist
import com.fp.ui.theme.ArtistMemoryTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistMemoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtistApp()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ArtistApp() {
    ArtistList(
        artistList = Datasource().loadArtist()
    )
}

@Composable
fun ArtistList(artistList: List<Artist>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(artistList) { index, artist ->
            ArtistCard(
                artist = artist,
                numberInTheList = (index + 1).toString() // Convertir el índice en número (inicia desde 1)
            )
        }
    }
}

@Composable
fun ArtistCard(artist: Artist, numberInTheList: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(15.dp)) {
        Image(
            painter = painterResource(artist.imageResourceId),
            contentDescription = artist.name,
            modifier = modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp), // Margen para separar del resto
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp), // Espaciado interno del rectángulo
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = numberInTheList, fontSize = 20.sp)
                Text(text = artist.name, fontWeight = FontWeight.Bold)
            }

        }

        Row(modifier = modifier) {
            Image(
                painter = painterResource(R.drawable.calendar),
                contentDescription = "Birthday",
                modifier = modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(8.dp),

                contentScale = ContentScale.Fit
            )
            Text(text = artist.birthday.toString(), modifier = modifier.padding(15.dp))
        }
        Row(modifier = modifier) {
            Image(
                painter = painterResource(R.drawable.dollar),
                contentDescription = "Salary",
                modifier = modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(8.dp),

                contentScale = ContentScale.Fit
            )
            Text(text = artist.salary.toString(), modifier = modifier.padding(15.dp))
        }
        Spacer(modifier = modifier.height(10.dp))
        Text(text = stringResource(artist.stringResourceId), fontSize = 10.sp)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ArtistAppPreview() {
    ArtistMemoryTheme {
       ArtistApp()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    val artist = Artist(
        R.string.aretha_franklin_summary,
        R.drawable.aretha_franklin,
        "Aretha Franklin",
        LocalDate.parse("1942-03-25"),
        2000.0
    )
    ArtistMemoryTheme {
        ArtistCard(artist, "1")
    }
}