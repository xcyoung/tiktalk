package com.xcyoung.tik_talk.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.xcyoung.tik_talk.bean.db.T_Friends

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Dao
abstract class FriendsDao:BaseDao<T_Friends>() {
    @Query("select * from T_Friends where id = :id")
    abstract fun getFriendInfo(id:String):T_Friends
}