package dev.zinary.onlylinks.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextOverflow

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LinkItem(
    modifier: Modifier = Modifier,
    isSelectionMode: Boolean,
    index: Int,
    item: Int,
    onClicked: () -> Unit,
) {
    ListItem(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inversePrimary)
            .clickable {
                onClicked()
            },
        leadingContent = {
//       todo show the image here
        },
        headlineText = {
            Text(text = "Link Title $item")
        },
        supportingText = {
            Text(
                text = "https://zinary.dev/item/$item",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        },
        trailingContent = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Default.MoreVert),
                    contentDescription = null,
                )
            }
        },
    )
}
