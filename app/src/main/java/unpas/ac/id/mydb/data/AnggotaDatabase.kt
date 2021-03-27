package unpas.ac.id.mydb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Anggota::class],version = 1,exportSchema = false)
abstract class AnggotaDatabase:RoomDatabase() {
    abstract fun anggotaDao():AnggotaDao

    companion object{
        @Volatile
        private var INSTANCE :AnggotaDatabase ?= null

        fun getDatabase(context: Context):AnggotaDatabase{
            val tempInstance= INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AnggotaDatabase::class.java,
                        "anggota_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}