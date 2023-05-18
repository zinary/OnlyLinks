package dev.zinary.onlylinks.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CategoriesChipsGroup(
    categories: List<String>,
    selectedChipIndex: Int,
    onClick: (Int) -> Unit,
) {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
    ) {
        itemsIndexed(categories) { index, item ->
            FilterChip(
                modifier = Modifier.padding(horizontal = 4.dp),
                selected = selectedChipIndex == index,
                onClick = { onClick(index) },
                label = {
                    Text(
                        text = item,
                    )
                },
            )
        }
    }
}
