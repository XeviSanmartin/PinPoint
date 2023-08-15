package com.architectcoders.pinpoint.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.architectcoders.pinpoint.R
import com.architectcoders.pinpoint.ui.theme.black

@Composable
fun CategoryItem(category: CategoryItemUiModel, onClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .clickable { onClicked() },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            CategoryImage(category.urlImage)
            CategoryTitle(category.title)
        }
    }
}

@Composable
fun CategoryImage(urlImage: String) {
    AsyncImage(
        modifier = Modifier.fillMaxWidth(),
        model = R.drawable.ic_launcher_background,
        contentDescription = "Image",
        contentScale = ContentScale.FillWidth,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
    )
}

@Composable
private fun CategoryTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center,
        color = black,
        fontSize = 15.sp,
        fontWeight = FontWeight.Black,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 1000, widthDp = 500)
@Composable
fun MyPreview() {
    CategoryItem(fakeModel) { }
}

private val fakeModel = CategoryItemUiModel(
    0,
    "",
    "Cities"
)
