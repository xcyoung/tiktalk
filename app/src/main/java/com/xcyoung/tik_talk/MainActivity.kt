package com.xcyoung.tik_talk

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        setSupportActionBar(bottomAppBar)
    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.menu_bottom_bar, menu)
//        return true
//    }
}
