package com.xcyoung.tik_talk.moudle.message.msg

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.base.BaseListFragment
import com.xcyoung.tik_talk.bean.MsgResult
import com.xcyoung.tik_talk.widget.SpacesItemDecoration

/**
 * @author ChorYeung
 * @since 2018/11/26
 */
class MessageFragment :BaseListFragment() {
    private lateinit var msgViewModel: MessageViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        msgViewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
        adapter.register(MsgResult::class.java, MessageViewBinder())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        msgViewModel.messageListLiveData.observe(this, Observer {
            onDataLoadSuccess(it)
        })
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }

    override fun loadData(isClean: Boolean) {
        msgViewModel.getMessageList()
    }

    override fun configRecyclerView(recyclerView: RecyclerView) {
        super.configRecyclerView(recyclerView)
        recyclerView.addItemDecoration(SpacesItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_8),resources.getDimensionPixelSize(R.dimen.dp_5)))
    }
}