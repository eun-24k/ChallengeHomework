package com.example.homework.main

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class TodoMainTab (
    val fragment: Fragment,
    @StringRes val title: Int,
)