package com.xcyoung.tik_talk.moudle.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xcyoung.tik_talk.R
import me.drakeet.multitype.ItemViewBinder

/**
 * @author ChorYeung
 * @since 2018/11/26
 */
class MessageViewBinder:ItemViewBinder<Any,MessageViewBinder.ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_msg,parent,false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Any) {
        p0.name.text = "xcyoung"
        p0.message.text = "aaa"
        p0.time.text = "11:12"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.findViewById(R.id.name)
        val message:TextView = itemView.findViewById(R.id.message)
        val time:TextView = itemView.findViewById(R.id.time)
    }
}