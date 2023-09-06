package com.architectcoders.pinpoint.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryList(list: List<CategoryItemUiModel>, onClick: (CategoryItemUiModel) -> Unit) {
    LazyColumn(Modifier.padding(8.dp)) {
        items(list) { item -> CategoryItem(item) { onClick(item) } }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF, heightDp = 1500, widthDp = 500)
@Composable
private fun MyPreview() {
    val list = listOf(
        CategoryItemUiModel(1, "", "Title 1", "Subtitle 1"),
        CategoryItemUiModel(1, "", "Title 2", "Subtitle 2"),
        CategoryItemUiModel(1, "", "Title 3", "Subtitle 3")
    )
    CategoryList(list) {}
}