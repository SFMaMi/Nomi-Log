package com.example.tabtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
	
	//データベース名
	private static final String DB_NAME = "NomiLog";
	
	private String[][] datas = new String[][]{
	        {"され塩学食", "111-0031", "され塩区西光線2-19-3", "090-1111-1111", "5", "fav"}
	    };

}
