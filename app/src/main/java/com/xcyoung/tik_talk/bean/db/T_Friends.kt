package com.xcyoung.tik_talk.bean.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Entity
data class T_Friends(                 //好友表
        @PrimaryKey
        val id:String,                //主键可为好友用户id(好友的userId)
        val userId:String,            //用户本人id
        val name:String,              //昵称
        val icon:String               //头像
)