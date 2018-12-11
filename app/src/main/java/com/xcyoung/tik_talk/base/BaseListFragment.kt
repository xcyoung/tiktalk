package com.xcyoung.tik_talk.base

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xcyoung.cyberframe.base.BaseFragment
import com.xcyoung.tik_talk.R
import kotlinx.android.synthetic.main.layout_list.*
import me.drakeet.multitype.MultiTypeAdapter

/**
 * @author ChorYeung
 * @since 2018/11/26
 */
abstract class BaseListFragment :BaseFragment() {
    protected val items = ArrayList<Any>()
    protected val adapter = MultiTypeAdapter(items)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRecyclerView(list)
        list.layoutManager = getLayoutManager()
        list.adapter = adapter
        getData(true)
    }

    override fun getCurrentViewLayoutId(): Int {
        return R.layout.layout_list
    }

    fun getData(isClean: Boolean){
        loadData(isClean)
    }

    protected fun onDataLoadSuccess(data:List<Any>){
        if(data.isNotEmpty()){
            if(items.isNotEmpty()) items.clear()
            items.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    open fun configRecyclerView(recyclerView: RecyclerView){

    }

    abstract fun getLayoutManager():RecyclerView.LayoutManager

    abstract fun loadData(isClean : Boolean)
}