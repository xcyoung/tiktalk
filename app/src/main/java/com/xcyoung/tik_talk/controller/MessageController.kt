package com.xcyoung.tik_talk.controller

import com.xcyoung.cyberframe.base.BaseController
import com.xcyoung.tik_talk.bean.ChatResult
import com.xcyoung.tik_talk.bean.MsgResult
import com.xcyoung.tik_talk.bean.db.T_Message
import com.xcyoung.tik_talk.db.TikTalkDatabase

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
class MessageController :BaseController() {
    fun getMessageList():List<MsgResult>{
        return TikTalkDatabase.getInstance().getMessageDao().getMessageList()
    }

    fun getChatMsgsBySessionId(sessionId:String):ChatResult{
        val msgs =TikTalkDatabase.getInstance().getMessageDao().getChatMsgsBySessionId(sessionId)
        val talker = TikTalkDatabase.getInstance().getFriendDao().getFriendInfo(sessionId)
        return ChatResult(msgs,talker)
    }

    fun deleteMsg(chatList:List<T_Message>):Int{
        return TikTalkDatabase.getInstance().getMessageDao().delete(chatList)
    }
}