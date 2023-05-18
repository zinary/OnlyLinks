package dev.zinary.onlylinks.presentation

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _list = (1..100).toList()
    val list: List<Int> get() = _list

    fun updateList(list: List<Int>) {
        _list = list
    }

    var isAuthenticated = true
}
