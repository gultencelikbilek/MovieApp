package com.example.movieapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.domain.model.Data

@Composable
fun Header() {
    Text(
        text = stringResource(id = R.string.movie_list_header),
        style = TextStyle(
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MovieCardComponent(data: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Row {
            val painter = rememberAsyncImagePainter(model = data.images)
            Image(
                painter = painter,
                contentDescription = data.title,
                modifier = Modifier.size(85.dp)
            )

            Text(
                text = data.title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.displaySmall.fontSize,
                    color = Color.Black
                )
            )
        }
    }
}