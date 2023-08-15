package com.architectcoders.pinpoint.ui.home

import android.widget.GridLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.architectcoders.pinpoint.ui.theme.black
import com.architectcoders.pinpoint.ui.theme.white

@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel(), onItemClicked: (Int) -> Unit) {
    val categories by viewModel.categories.collectAsState(initial = listOf())
    Column {
        Text(
            text = "Categories",
            color = black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(categories) { category ->
                CategoryItem(category) {}
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, heightDp = 1000, widthDp = 500)
@Composable
fun Preview() {
    HomeScreen()
}
