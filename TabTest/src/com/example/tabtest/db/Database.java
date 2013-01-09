package com.example.tabtest.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
	
	//データベース名
	private static final String DB_NAME = "NomiLog";
	
	//店名，郵便番号，住所，電話番号，評価，タグ
	private String[][] datas = new String[][]{
	        {"され塩食堂", "111-0031", "され塩区西光線2-19-1", "025-1111-1111", "5", "fav"},
	        {"佐玲児雄食堂", "121-4631", "され塩区北光線6-9-2", "046-2222-2222", "5", "fav"},
	        {"沙禮餌緒食堂", "493-0359", "され塩区東光線8-2-3", "067-2222-2222", "5", "fav"}
	    };
	
	/**
     * コンストラクタ
     */
    public Database(Context context) {
        // 指定したデータベース名が存在しない場合は、新たに作成されonCreate()が呼ばれる
        // バージョンを変更するとonUpgrade()が呼ばれる
        super(context, DB_NAME, null, 1);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	db = SQLiteDatabase.openOrCreateDatabase("NomiDB", null); 
        db.beginTransaction();
        
        try{
            // テーブルの生成
            StringBuilder createSql = new StringBuilder();
            createSql.append("create table " + NLog.TABLE_NAME + " (");
            createSql.append(NLog.COLUMN_ID + " integer primary key autoincrement not null,");
            createSql.append(NLog.COLUMN_SHOP_NAME + " text not null,");
            createSql.append(NLog.COLUMN_ZIP + " text,");
            createSql.append(NLog.COLUMN_ADDRESS + " text,");
            createSql.append(NLog.COLUMN_TEL + " text,");
            createSql.append(NLog.COLUMN_VALUE + " text");
            createSql.append(NLog.COLUMN_TAG + " text");
            createSql.append(")");

            db.execSQL( createSql.toString());

            // サンプルデータの投入
            for( String[] data: datas){
                ContentValues values = new ContentValues();
                values.put(NLog.COLUMN_SHOP_NAME, data[ 0]);
                values.put(NLog.COLUMN_ZIP, data[ 1]);
                values.put(NLog.COLUMN_ADDRESS, data[ 2]);
                values.put(NLog.COLUMN_TEL, data[ 3]);
                values.put(NLog.COLUMN_VALUE, data[ 4]);
                values.put(NLog.COLUMN_TAG, data[ 5]);
                db.insert(NLog.TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
    
	/**
     * データベースの更新
     * 
     * 親クラスのコンストラクタに渡すversionを変更したときに呼び出される
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // データベースの更新
    }

}
