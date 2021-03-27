package unpas.ac.id.mydb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anggota_master")
data class Anggota (
        @PrimaryKey(autoGenerate = true)
        val id:Int,
        val nama:String,
        val umur:String
        )
