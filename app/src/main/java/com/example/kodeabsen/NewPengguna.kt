package com.example.kodeabsen

import com.google.firebase.database.IgnoreExtraProperties

object NewPengguna {
    @IgnoreExtraProperties
    data class pengguna(val email: String) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
}