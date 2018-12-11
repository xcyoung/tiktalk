package com.xcyoung.tik_talk.bean.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Entity
data class T_Message (              //聊天记录表
        @PrimaryKey
        val id:String,
        val postMsg:String,         //消息内容(有可能为json 兼容文字、图片、语音、视频)
        val status:Int,             //接收状态  0：未读 1：已读
        val time:Long,              //发送时间  timestamp
        val fromUserId:String,      //发送者id
        val toUserId:String,        //接收者id
        val sessionId:String,       //用于表示一次会话，通常为好友id 可关联Friends表
        val msgType:String          //消息类型
)