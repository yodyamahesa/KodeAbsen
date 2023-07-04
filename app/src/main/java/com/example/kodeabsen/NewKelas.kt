import com.google.firebase.database.IgnoreExtraProperties

object NewKelas {
    @IgnoreExtraProperties
    data class Kelas(val namaKelas: String? = null, val email: String? = null, val kodekelas: String) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }
}