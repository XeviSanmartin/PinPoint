package com.architectcoders.pinpoint.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            category.subtitle
                ?.let {
                    if (it.isBlank().not())
                        CategorySubtitle(category.subtitle)
                }
        }
    }
}

@Composable
private fun CategoryImage(urlImage: String) {
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

@Composable
private fun CategorySubtitle(subtitle: String) {
    Text(
        text = subtitle,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp),
        textAlign = TextAlign.Center,
        color = black,
        fontSize = 12.sp,
        maxLines = 10,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 1000, widthDp = 500)
@Composable
private fun MyPreview() {
    val fakeModel = CategoryItemUiModel(
        0,
        "",
        "Cities",
        "A description for this category"
    )
    CategoryItem(fakeModel) { }
}
