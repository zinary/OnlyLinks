package dev.zinary.onlylinks.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        modifier = modifier.clickable {
            onClicked()
        },
        leadingContent = {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "$index")
            }
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
                    painter = rememberVectorPainter(image = Icons.Default.OpenInBrowser),
                    contentDescription = null,
                )
            }
        },
    )
}
