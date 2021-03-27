package unpas.ac.id.mydb.data

import androidx.lifecycle.LiveData

class Repository(private val anggotaDao: AnggotaDao) {
    val readAnggota:LiveData<List<Anggota>> = anggotaDao.readData()

    suspend fun insertAnggota(anggota: Anggota){
        anggotaDao.insertData(anggota)
    }
}