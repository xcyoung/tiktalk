package com.xcyoung.tik_talk.moudle.message

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.base.BaseListFragment
import com.xcyoung.tik_talk.widget.SpacesItemDecoration
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration

/**
 * @author ChorYeung
 * @since 2018/11/26
 */
class MessageFragment :BaseListFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.register(Any::class.java,MessageViewBinder())
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }

    override fun loadData(isClean: Boolean) {
        for (i in 0..10){
            items.add(Any())
        }
    }

    override fun configRecyclerView(recyclerView: RecyclerView) {
        super.configRecyclerView(recyclerView)
        recyclerView.addItemDecoration(SpacesItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_8)
                ,resources.getDimensionPixelSize(R.dimen.dp_5)))
    }
}