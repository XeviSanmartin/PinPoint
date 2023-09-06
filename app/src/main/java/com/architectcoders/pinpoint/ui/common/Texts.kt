package com.architectcoders.pinpoint.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.architectcoders.pinpoint.ui.theme.black
import com.architectcoders.pinpoint.ui.theme.gray

@Composable
fun Title(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Start,
        color = black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Black,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun Subtitle(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Start,
        color = gray,
        fontSize = 15.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun Description(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Start,
        color = gray,
        fontSize = 12.sp,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, widthDp = 500)
@Composable
private fun MyPreview() {
    Column {
        Title(Modifier.padding(8.dp), "Title")
        Subtitle(Modifier.padding(16.dp), "Subtitle")
        Description(Modifier.padding(24.dp), "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description " +
            "A very long description A very long description A very long description ")
    }
}
