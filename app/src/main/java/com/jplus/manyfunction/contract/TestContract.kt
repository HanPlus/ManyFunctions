package com.jplus.manyfunction.contract

import android.app.Activity
import android.content.Intent
import com.nice.baselibrary.base.net.download.JDownloadCallback
import com.nice.baselibrary.base.rx.NiceBaseView
import com.nice.baselibrary.base.rx.NicePresenter
import com.nice.baselibrary.base.vo.AppInfo
import com.nice.baselibrary.widget.dialog.NiceAlertDialog
import java.io.File

/**
 * @author JPlus
 * @date 2019/2/13.
 */
interface TestContract {
    interface View : NiceBaseView<Presenter> {
        /**
         */
        fun getFragActivity():Activity?
        /**
         * 未通过权限界面
         */
        fun showNotPermissionView(content:String)

        /**
         * 图片上传界面
         */
        fun showUploadPic()

        /**
         * 图片上传结果显示
         */
        fun uploadResultView(url:String?)

        /**
         * appInfoDemo界面
         */
        fun showAppInfo(infos:MutableList<AppInfo>)
        /**
         * 登录界面
         */
        fun showLogin()
        /**
         * 登录结果界面
         */
        fun showLoginResult(result:Boolean, message:String)
        /**
         * 热修复下载界面
         */
        fun showPatchDownLoad()
        /**
         * 视频播放界面
         */
        fun showVideoView()
        /**
         * 分享功能
         */
        fun showShareView()
        /**
         * 上拉加载下拉刷新功能
         */
        fun showRefreshLoadView()
    }

    interface Presenter: NicePresenter {
        /**
         * 请求权限测试
         */
        fun startPermissionTest()
        /**
         * ActivityResult返回
         */
        fun activityResult(requestCode: Int, resultCode: Int, data: Intent?)
        /**
         * 请求权限返回
         */
        fun permissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)

        /**
         * 图片上传测试
         */
        fun startPhotoTest()

        /**
         * 图片上传功能
         */
        fun checkToCameraOrPhoto(view: android.view.View, niceDialog: NiceAlertDialog)
        /**
         * 获取appInfos
         */
        fun getAppInfos()

        /**
         * 热修复下载url
         */
        fun getPatchDownLoadUrl()

        /**
         * 登录
         */
        fun login(phone:String, password:String)

        /**
         * 热修复dex下载
         */
        fun downLoadPatch(url: String, dirPath:String, jDownloadCallback: JDownloadCallback)

        /**
         * 视频流播放
         */
        fun playVideo(url: String)

        /**
         * 分享功能
         */
        fun share(file: File)

        /**
         * 上拉加载下拉刷新
         */
        fun refreshLoadView()

    }
}