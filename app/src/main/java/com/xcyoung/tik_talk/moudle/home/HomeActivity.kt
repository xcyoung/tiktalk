package com.xcyoung.tik_talk.moudle.home

import android.os.Bundle
import android.widget.Toast
import com.xcyoung.cyberframe.base.BaseActivity
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.moudle.message.MessageFragment
import com.xcyoung.tik_talk.widget.CheckItemView
import com.xcyoung.tik_talk.widget.CheckMenuView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomMenu.setOnItemSelectedListener(object :CheckMenuView.OnItemSelectedListener{
            override fun onItemSelected(position: Int, item: CheckItemView) {
                Toast.makeText(this@HomeActivity,"$position",Toast.LENGTH_LONG).show()
            }
        })
        supportFragmentManager.beginTransaction().replace(R.id.container,MessageFragment()).commit()
    }
}