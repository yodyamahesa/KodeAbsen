import com.google.firebase.database.IgnoreExtraProperties

object JoinPengguna {
    @IgnoreExtraProperties
    data class join(val kelas: String) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
}