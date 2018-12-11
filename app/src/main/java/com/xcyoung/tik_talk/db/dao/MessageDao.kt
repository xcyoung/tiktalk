package com.xcyoung.tik_talk.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.xcyoung.tik_talk.bean.MsgResult
import com.xcyoung.tik_talk.bean.db.T_Message

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Dao
abstract class MessageDao:BaseDao<T_Message>() {
    @Query("select * from T_Message where sessionId = :sessionId order by time")
    abstract fun getChatMsgsBySessionId(sessionId:String):List<T_Message>

    @Query("select a.*,b.unreadNum unreadNum,d.* from T_Message a left join (select sessionId, max(time) time,sum(status = 0) unreadNum from T_Message c group by c.sessionId) b left join T_Friends d on a.sessionId = b.sessionId and a.time = b.time and a.sessionId = d.id order by a.sessionId")
    abstract fun getMessageList():List<MsgResult>

    @Delete
    abstract fun delete(list:List<T_Message>):Int
}