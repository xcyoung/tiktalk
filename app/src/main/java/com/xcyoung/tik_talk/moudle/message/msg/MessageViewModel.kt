package com.xcyoung.tik_talk.moudle.message.msg

import androidx.lifecycle.MutableLiveData
import com.xcyoung.cyberframe.base.BaseViewModel
import com.xcyoung.tik_talk.bean.ChatResult
import com.xcyoung.tik_talk.bean.MsgResult
import com.xcyoung.tik_talk.controller.MessageController
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
class MessageViewModel:BaseViewModel() {
    val msgController = MessageController()
    val messageListLiveData = MutableLiveData<List<MsgResult>>()
    val chatListLiveData = MutableLiveData<ChatResult>()
    val deleteMsgLiveData = MutableLiveData<Int>()

    fun getMessageList() {
        doAsync {
            val list = msgController.getMessageList()
            uiThread {
                messageListLiveData.value = list
            }
        }
    }

    fun getChatMsgsBySessionId(sessionId:String){
        doAsync {
            val chatResult = msgController.getChatMsgsBySessionId(sessionId)
            uiThread {
                chatListLiveData.value = chatResult
            }
        }
    }

    fun deleteMsg(sessionId: String){
        doAsync {
            val chatResult = msgController.getChatMsgsBySessionId(sessionId)
            val result = msgController.deleteMsg(chatResult.chatList)
            uiThread {
                deleteMsgLiveData.value = result
            }
        }
    }
}