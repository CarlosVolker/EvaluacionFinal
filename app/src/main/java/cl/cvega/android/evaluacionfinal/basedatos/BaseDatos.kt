package cl.cvega.android.evaluacionfinal.basedatos

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Medicion::class], version = 1)
@TypeConverters(LocalDataConverter::class)
abstract class BaseDatos : RoomDatabase(){
    abstract fun medicionDao() : MedicionDao
}