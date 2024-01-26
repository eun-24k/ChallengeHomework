package com.example.homework.todo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoData(
    val title: String?,
    val description: String?,
    val switch: Boolean,
    ) : Parcelable