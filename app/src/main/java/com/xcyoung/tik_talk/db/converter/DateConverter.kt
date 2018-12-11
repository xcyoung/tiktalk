package com.xcyoung.tik_talk.db.converter

import androidx.room.TypeConverter
import java.util.*

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
class DateConverter {
    @TypeConverter
    fun from(value:Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun to(date:Date):Long{
        return date.time
    }
}