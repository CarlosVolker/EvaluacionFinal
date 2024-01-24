package cl.cvega.android.evaluacionfinal.basedatos

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDataConverter {
    @TypeConverter
    fun fronTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}