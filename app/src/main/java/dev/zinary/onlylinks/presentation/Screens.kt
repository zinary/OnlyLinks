package dev.zinary.onlylinks.presentation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import dev.zinary.onlylinks.R

sealed class Screens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector? = null,
) {
    object Links : Screens("links", R.string.links, Icons.Outlined.Link)
    object Link : Screens("link", R.string.links)
    object Categories : Screens("categories", R.string.categories, Icons.Outlined.Category)
    object Settings : Screens("settings", R.string.settings, Icons.Outlined.Settings)
    object About : Screens("about", R.string.about)
}
