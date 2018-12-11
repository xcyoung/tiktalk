package com.xcyoung.tik_talk.moudle.find

import android.os.Bundle
import android.view.View
import com.xcyoung.cyberframe.base.BaseFragment
import com.xcyoung.tik_talk.R
import com.xcyoung.tik_talk.base.BaseListFragment
import kotlinx.android.synthetic.main.fragment_example.*

/**
 * @author ChorYeung
 * @since 2018/11/27
 */
class FindFragment:BaseFragment() {
    override fun getCurrentViewLayoutId(): Int {
        return R.layout.fragment_example
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text.text = "Find"
    }
}