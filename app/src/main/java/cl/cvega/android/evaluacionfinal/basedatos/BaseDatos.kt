package cl.cvega.android.evaluacionfinal.basedatos

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.cvega.android.evaluacionfinal.Aplicacion

@Database(entities = [Medicion::class], version = 1)
@TypeConverters(LocalDataConverter::class)
abstract class BaseDatos : RoomDatabase(){
    abstract fun medicionDao() : MedicionDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun getDatabase(context: Context): BaseDatos {
            return INSTANCE ?: synchronized(this) {
                val instance = (context.applicationContext as Aplicacion).db
                INSTANCE = instance
                instance
            }
        }
        /*fun getDatabase(context: Context): BaseDatos {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }*/
    }
}