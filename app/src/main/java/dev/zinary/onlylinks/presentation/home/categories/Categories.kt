package dev.zinary.onlylinks.presentation.home.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.zinary.onlylinks.presentation.Screens
import dev.zinary.onlylinks.presentation.components.EmptyState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {
    Scaffold(topBar = {
        LargeTopAppBar(
            title = {
                Text(text = stringResource(id = Screens.Categories.resourceId))
            },
        )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            EmptyState()
        }
    }
}
