package com.nice.baselibrary.download

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.ArrayList

/**
 * @author JPlus
 * @date 2019/3/7.
 */
class NiceDownloadDataSource(context: Context) {
    private var mNiceDownloadList: ArrayList<NiceDownloadInfo> = ArrayList()
    private var mDownloadDataHelper: NiceDownloadDBHelper? = null
    private var mDatabase: SQLiteDatabase? = null

    init {
        mDownloadDataHelper = NiceDownloadDBHelper(context)
        mDatabase = mDownloadDataHelper?.writableDatabase
        mNiceDownloadList = mDownloadDataHelper!!.queryAll(mDatabase)
    }

    fun addData(item: NiceDownloadInfo) : NiceDownloadInfo {
        if (mDownloadDataHelper?.add(item, mDatabase) != null) {
            mNiceDownloadList.add(item)
        }
        return item
    }

    fun addDatas(items: ArrayList<NiceDownloadInfo>) {
        items.filter { mDownloadDataHelper?.add(it, mDatabase) != null }
                .forEach { mNiceDownloadList.add(it) }

    }

    fun removeData(item: NiceDownloadInfo): NiceDownloadInfo? {
        if (mDownloadDataHelper?.remove(item, mDatabase) != null) {
            mNiceDownloadList.remove(item)
        }
        return item
    }

    fun removeDatas(items: ArrayList<NiceDownloadInfo>) {
        items.filter { mDownloadDataHelper?.remove(it, mDatabase) != null }
                .forEach { mNiceDownloadList.remove(it) }
    }

    fun deleteAll() {

    }

    fun modifyData(niceDownloadInfo: NiceDownloadInfo) {
        mDownloadDataHelper?.update(niceDownloadInfo, mDatabase)
    }

    fun refreshData(): List<NiceDownloadInfo>? {
        return null
    }

    fun getData(url: String): NiceDownloadInfo? {
        return mDownloadDataHelper?.queryByUrl(url, mDatabase)
    }
    fun getDataByUrl(url: String): NiceDownloadInfo? {

        return mDownloadDataHelper?.queryByUrl(url, mDatabase)
    }

    fun getAllData(): ArrayList<NiceDownloadInfo>? {
        return mDownloadDataHelper?.queryAll(mDatabase)
    }
}