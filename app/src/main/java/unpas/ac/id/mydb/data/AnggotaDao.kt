package unpas.ac.id.mydb.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnggotaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(anggota: Anggota)

    @Query("SELECT * FROM anggota_master")
    fun readData():LiveData<List<Anggota>>
}