package unpas.ac.id.mydb.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import unpas.ac.id.mydb.data.Anggota
import unpas.ac.id.mydb.data.AnggotaDatabase
import unpas.ac.id.mydb.data.Repository

class AnggotaViewModel(application: Application):AndroidViewModel(application) {
    val readData:LiveData<List<Anggota>>
    private val repository:Repository

    init {
        val anggotaDao = AnggotaDatabase.getDatabase(application).anggotaDao()
        repository = Repository(anggotaDao)
        readData = repository.readAnggota
    }

    fun insertData(anggota: Anggota){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertAnggota(anggota)
        }
    }
}