package dev.zinary.onlylinks.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.QrCode2
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LinkerNavigationBar() {
    NavigationBar() {
        NavigationBarItem(
            label = {
                Text(text = "Links")
            },
            selected = true,
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Dashboard,
                    contentDescription = null,
                )
            },
        )
        NavigationBarItem(
            label = {
                Text(text = "Categories")
            },
            selected = false,
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Category,
                    contentDescription = null,
                )
            },
        )
        NavigationBarItem(
            label = {
                Text(text = "QR")
            },
            selected = false,
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.QrCode2,
                    contentDescription = null,
                )
            },
        )
    }
}
