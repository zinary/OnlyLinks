package dev.zinary.onlylinks.presentation.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import dev.zinary.onlylinks.util.Constants

@Composable
@OptIn(
    ExperimentalMaterial3Api::class,
)
fun LinksScreen(
    onLinkItemClick: (String) -> Unit,
    onThemeChange: (Boolean) -> Unit,
    isDarkTheme: Boolean,
) {
    val context = LocalContext.current
    var openDialog by remember { mutableStateOf(false) }
    val scrollState = rememberLazyListState()
    val firstVisibleItemIndex by remember { derivedStateOf { scrollState.firstVisibleItemIndex } }

    var count by remember { mutableStateOf(0) }
    var selectedChipIndex by remember { mutableStateOf(0) }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Add Link")
                },
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.Add),
                        contentDescription = "Add new link",
                    )
                },
                onClick = {
                    count++
                },
            )
        },
    ) { paddingValues ->

        if (openDialog) {
            AlertDialog(
                title = { Text(text = "Warning") },
                text = { Text("Hello! This is our Alert Dialog..") },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog = false
                            Toast.makeText(context, "Confirm Button Click", Toast.LENGTH_LONG)
                                .show()
                        },
                    ) {
                        Text("Confirm")
                    }
                },
                onDismissRequest = { openDialog = false },

                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                            Toast.makeText(context, "Dismiss Button Click", Toast.LENGTH_LONG)
                                .show()
                        },
                    ) {
                        Text("Dismiss")
                    }
                },

                )
        }

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            CategoriesChipsGroup(
                categories = Constants.CATEGORIES,
                selectedChipIndex = selectedChipIndex,
            ) {
                selectedChipIndex = it
            }
            LazyColumn(
                state = scrollState,
                modifier = Modifier.weight(1f)
            ) {
                itemsIndexed((1..220).toList(), key = { _, i -> i }) { index, item ->
                    LinkItem(
                        isSelectionMode = false,
                        index = index,
                        item = item,
                        onClicked = {
                            onLinkItemClick("link")
                        },
                    )
                }
            }
        }
    }
}
