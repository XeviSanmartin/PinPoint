package com.architectcoders.pinpoint.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.architectcoders.pinpoint.R
import com.architectcoders.pinpoint.ui.common.Description
import com.architectcoders.pinpoint.ui.common.Subtitle
import com.architectcoders.pinpoint.ui.common.Title
import com.architectcoders.pinpoint.ui.theme.black
import com.architectcoders.pinpoint.ui.theme.white

@Composable
fun DetailScreen(model: DetailUiModel) {
    Column {
        Image(urlImage = "")
        DetailTitle(model.title)
        DetailSubtitle(model.subtitle)
        DetailCoord(model.coord)
        DetailDescription(model.description)
    }
}

@Composable
private fun DetailTitle(title: String) {
    Title(
        text = title,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
private fun DetailSubtitle(subtitle: String?) {
    if (!subtitle.isNullOrBlank())
        Subtitle(
            text = subtitle,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp)
        )
}

@Composable
private fun DetailCoord(coord: String?) {
    if (!coord.isNullOrBlank())
        Column {
            Title(modifier = Modifier.padding(start = 16.dp, bottom = 8.dp), text = "Coord:")
            Subtitle(
                text = coord,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp)
            )
        }
}

@Composable
private fun DetailDescription(description: String?) {
    if (!description.isNullOrBlank())
        Description(
            text = description,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp)
        )
}

@Composable
private fun Image(urlImage: String) {
    Box{
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = R.drawable.ic_launcher_background,
            contentDescription = "Image",
            contentScale = ContentScale.FillWidth,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
        )
        Row(
            Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = white
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = white
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 1000, widthDp = 500)
@Composable
private fun MyPreview() {
    val fakeModel = DetailUiModel(
        "",
        "Cities",
        "Paris (France)",
        "1.35, 103.87",
        "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description "
    )
    DetailScreen(fakeModel)
}
