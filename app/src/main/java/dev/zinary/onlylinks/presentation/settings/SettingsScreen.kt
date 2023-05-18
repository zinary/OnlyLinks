package dev.zinary.onlylinks.presentation.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DisplaySettings
import androidx.compose.material.icons.outlined.ImportExport
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import dev.zinary.onlylinks.presentation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onClick: (Screens) -> Unit,
) {
    val scrollableState = rememberScrollableState {
        it
    }
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = stringResource(id = Screens.Settings.resourceId))
                },
            )
        },
    ) {
        LazyColumn(
            Modifier.padding(it),
        ) {
            item {
                SettingsItem(
                    title = "About",
                    subtitle = "Releases, Version, Credits",
                    icon = Icons.Outlined.Info,
                    onClick = {
                        onClick(Screens.About)
                    },
                )
            }
            item {
                SettingsItem(
                    title = "Display",
                    subtitle = "Choose theme",
                    icon = Icons.Outlined.DisplaySettings,
                    onClick = {
                        onClick(Screens.Categories)
                    },
                )
            }
            item {
                SettingsItem(
                    title = "Import & Export",
                    subtitle = "Local backup and google drive backup",
                    icon = Icons.Outlined.ImportExport,
                    onClick = {
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsItem(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    ListItem(
        leadingContent = {
            Icon(imageVector = icon, contentDescription = title)
        },
        headlineText = {
            Text(
                text = title,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
        supportingText = {
            Text(
                text = subtitle,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        modifier = Modifier.clickable {
            onClick()
        },
    )
}
