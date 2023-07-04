package com.example.kodeabsen

import com.google.firebase.database.IgnoreExtraProperties

object NewUser {
    @IgnoreExtraProperties
    data class User(val username: String? = null, val email: String? = null) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
}