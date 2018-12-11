package com.xcyoung.tik_talk.moudle.message.msg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.bean.MsgResult
import com.xcyoung.tik_talk.bean.db.T_Message
import me.drakeet.multitype.ItemViewBinder

/**
 * @author ChorYeung
 * @since 2018/11/26
 */
class MessageViewBinder:ItemViewBinder<MsgResult, MessageViewBinder.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_msg, parent, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: MsgResult) {
        p0.name.text = p1.friend.name
        p0.message.text = p1.msg.postMsg
        p0.time.text = p1.msg.time.toString()
        p0.badge.text = p1.unreadNum.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.findViewById(R.id.name)
        val message:TextView = itemView.findViewById(R.id.message)
        val time:TextView = itemView.findViewById(R.id.time)
        val badge:TextView = itemView.findViewById(R.id.badge)
    }
}