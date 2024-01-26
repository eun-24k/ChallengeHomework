package com.example.homework

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoModel(
    var title: String,
    var description: String

) : Parcelable