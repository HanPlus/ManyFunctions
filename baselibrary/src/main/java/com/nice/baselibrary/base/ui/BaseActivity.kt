package com.nice.baselibrary.base.ui

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nice.baselibrary.base.utils.ActivityCollect
import com.nice.baselibrary.base.utils.LogUtils
import com.nice.baselibrary.base.utils.showNormalToast

/**
 * @author JPlus
 * @date 2019/1/16.
 */
abstract class BaseActivity : AppCompatActivity() {
    companion object {
        private const val BACK_TIME =2000
    }

    private var mBackTime=0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollect.add(this)
        LogUtils.d(this.localClassName + " --onCreate()")
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        onSetContent()
    }

    private fun onSetContent() {
        onInit()
        onFindView()
        onBindListener()
    }

    /**
     * 初始化操作
     */
    abstract fun onInit()

    /**
     * 绑定id
     */
    abstract fun onFindView()

    /**
     * 绑定监听
     */
    abstract fun onBindListener()

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtils.d(this.localClassName + " --onConfigurationChanged()")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.d(this.localClassName + " --onStart()")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.d(this.localClassName + " --onPause()")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.d(this.localClassName + " --onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.d(this.localClassName + " --onRestart()")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.d(this.localClassName + " --onResume()")
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollect.remove(this)
        LogUtils.d(this.localClassName + " --onDestroy()")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        LogUtils.d(this.localClassName + " --onNewIntent()")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LogUtils.d(this.localClassName + " --onActivityResult()")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        LogUtils.d(this.localClassName + " --onRequestPermissionsResult()")
    }

    /**
     * 是否点击两次退出
     * @return
     */
    open fun setBackTwiceMsg():String{
        return ""
    }

    override fun onBackPressed() {
        if(setBackTwiceMsg().isNotEmpty()){
            if(System.currentTimeMillis()- mBackTime>BACK_TIME){
                mBackTime = System.currentTimeMillis()
                this.showNormalToast(setBackTwiceMsg())
            }else{
                ActivityCollect.removeAll()
            }
        }else {
            super.onBackPressed()
        }
    }

}