package dev.zinary.onlylinks.presentation.home

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LightbulbCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import dev.zinary.onlylinks.util.Constants

@Composable
@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class,
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

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState(),
        canScroll = { true },
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = "Only Links 🔗")
                },
                actions = {
                    IconButton(onClick = {
                        onLinkItemClick("search")
                    }) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Search),
                            contentDescription = "Search links",
                        )
                    }
                    Switch(checked = isDarkTheme, onCheckedChange = onThemeChange, thumbContent = {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.LightbulbCircle),
                            contentDescription = "Change Theme",
                        )
                    })
//                    IconButton(onClick = { onThemeChange }) {

//                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = firstVisibleItemIndex == 0,
                enter = slideInVertically(initialOffsetY = {
                    it
                }) + scaleIn() + fadeIn(),
                exit = slideOutVertically(
                    targetOffsetY = {
                        it
                    },
                ) + scaleOut() + fadeOut(),
            ) {
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
            }
        },
    ) { paddingValues ->
        var selectedChipIndex by remember { mutableStateOf(0) }

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

        LazyColumn(contentPadding = paddingValues, state = scrollState) {
            stickyHeader {
            }

            item(contentType = null) {
                CategoriesChipsGroup(
                    categories = Constants.CATEGORIES,
                    selectedChipIndex = selectedChipIndex,
                ) {
                    selectedChipIndex = it
                }
            }

            itemsIndexed((1..20).toList(), key = { _, i -> i }) { index, item ->
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
