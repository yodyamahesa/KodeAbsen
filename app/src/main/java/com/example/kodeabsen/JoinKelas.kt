import com.google.firebase.database.IgnoreExtraProperties

object JoinKelas {
    @IgnoreExtraProperties
    data class join(val email: String) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
}