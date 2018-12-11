package com.xcyoung.tik_talk.moudle.home

import android.os.Bundle
import com.xcyoung.cyberframe.base.BaseActivity
import com.xcyoung.cyberframe.base.BaseFragment
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.moudle.find.FindFragment
import com.xcyoung.tik_talk.moudle.friends.FriendsFragment
import com.xcyoung.tik_talk.moudle.message.msg.MessageFragment
import com.xcyoung.tik_talk.moudle.user.MineFragment
import com.xcyoung.tik_talk.widget.CheckItemView
import com.xcyoung.tik_talk.widget.CheckMenuView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity:BaseActivity() {
    val fragmentList = ArrayList<BaseFragment>()
    var curIndex = -1

    init {
        fragmentList.add(MessageFragment())
        fragmentList.add(FriendsFragment())
        fragmentList.add(FindFragment())
        fragmentList.add(MineFragment())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomMenu.setOnItemSelectedListener(object :CheckMenuView.OnItemSelectedListener{
            override fun onItemSelected(position: Int, item: CheckItemView) {
                showFragment(position)
            }
        })

        showFragment(0)
    }

    private fun showFragment(index:Int){
        if(index > 3) return
        if(curIndex == index) return
        val f = fragmentList[index]
        val tag = f.javaClass.name
        val fragmentInCache = supportFragmentManager.findFragmentByTag(tag)

        val transaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.fragments.forEach {
            it.userVisibleHint = false
            transaction.hide(it)
        }

        if(fragmentInCache!=null){
            fragmentInCache.userVisibleHint = true
            transaction.show(fragmentInCache)
        }else{
            f.userVisibleHint = true
            transaction.add(R.id.container,f,tag).show(f)
        }
        transaction.commit()
        curIndex = index
    }
}