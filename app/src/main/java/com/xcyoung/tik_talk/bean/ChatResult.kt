package com.xcyoung.tik_talk.bean

import com.xcyoung.tik_talk.bean.db.T_Friends
import com.xcyoung.tik_talk.bean.db.T_Message

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
data class ChatResult(
        val chatList:List<T_Message>,
        val talker:T_Friends
)