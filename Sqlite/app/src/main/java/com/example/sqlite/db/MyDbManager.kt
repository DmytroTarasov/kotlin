package com.example.sqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(private val context: Context) {
    private val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase // open a database for writing
    }

    fun insertToDb(title: String, content: String, uri: String) {
        val values = ContentValues().apply { // what to write into a DB - we specify data as
            // pairs key/value
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
            put(MyDbNameClass.COLUMN_NAME_IMAGE_URI, uri)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        var cursor = db?.query( // we request a data into a variable cursor
            MyDbNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null,
        )

        with(cursor) {
            while(this?.moveToNext()!!) { // when cursor has data
                // put a title into a variable dataText and then put this variable into a dataList
                val dataText = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDb() {
        myDbHelper.close()
    }
}