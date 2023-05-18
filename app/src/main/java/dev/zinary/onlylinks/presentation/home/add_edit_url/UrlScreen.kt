package dev.zinary.onlylinks.presentation.home.add_edit_url

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UrlScreen(
    id: Int,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Add Link")
            }, navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, null)
                }
            })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Save")
                },
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.Save),
                        contentDescription = "Add new link",
                    )
                },
                onClick = {
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .scrollable(scrollState, Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                value = "Link Name",
                label = {
                    Text(text = "Name")
                },
                onValueChange = { },
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                label = {
                    Text(text = "URL")
                },
                value = "https://zinary.dev",
                onValueChange = {},
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
                    .padding(4.dp),
                label = {
                    Text(text = "Notes")
                },
                value = "https://zinary.dev",
                onValueChange = {},
            )

            var selectedChips = remember {
                mutableStateOf(listOf<Int>())
            }

//            CategoriesChipsGroup(
//                categories = Constants.CATEGORIES,
//                selectedChipIndex = selectedChipIndex
//            ) {
//                selectedChipIndex = it
//            }
        }
    }
}

@Preview
@Composable
fun UrlScreenPrev() {
    UrlScreen(id = 1)
}
