package com.xcyoung.tik_talk.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xcyoung.tik_talk.bean.db.T_Friends
import com.xcyoung.tik_talk.bean.db.T_Message
import com.xcyoung.tik_talk.db.converter.DateConverter
import com.xcyoung.tik_talk.db.dao.FriendsDao
import com.xcyoung.tik_talk.db.dao.MessageDao

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Database(entities = [
    T_Message::class,
    T_Friends::class
], version = 1,exportSchema = true)
@TypeConverters(value = [
    DateConverter::class
])
abstract class TikTalkDatabase : RoomDatabase() {
    abstract fun getMessageDao():MessageDao
    abstract fun getFriendDao():FriendsDao

    companion object {
        private lateinit var INSTANCE:TikTalkDatabase
        fun getInstance():TikTalkDatabase = INSTANCE

        fun init(application: Application){
            INSTANCE = Room.databaseBuilder(application,TikTalkDatabase::class.java,"tik-talk_db")
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}