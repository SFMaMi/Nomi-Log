package com.example.tabtest.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 データアクセスクラス
 */
public class NDBDao {
    
    private Database helper = null;
    
    public NDBDao(Context context) {
        helper = new Database(context);
    }
    
   
    public NLog save(NLog NomiL){
        SQLiteDatabase db = helper.getWritableDatabase();
        NLog result = null;
        try {
            ContentValues values = new ContentValues();
            values.put( NLog.COLUMN_SHOP_NAME, NomiL.getShopName());
            values.put( NLog.COLUMN_ZIP, NomiL.getZip());
            values.put( NLog.COLUMN_ADDRESS, NomiL.getAddress());
            values.put( NLog.COLUMN_TEL, NomiL.getTel());
            values.put( NLog.COLUMN_VALUE, NomiL.getValue());
            values.put( NLog.COLUMN_TAG, NomiL.getTag());

            Long rowId = NomiL.getRowid();
            // IDがnullの場合はinsert
            if( rowId == null){
                rowId = db.insert( NLog.TABLE_NAME, null, values);
            }
            else{
                db.update( NLog.TABLE_NAME, values, NLog.COLUMN_ID + "=?", new String[]{ String.valueOf( rowId)});
            }
            result = load( rowId);
        } finally {
            db.close();
        }
        return result;
    }
    
    /**
     * レコードの削除
     * @param bizCard 削除対象のオブジェクト
     */
    public void delete(NLog NomiL) {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            db.delete( NLog.TABLE_NAME, NLog.COLUMN_ID + "=?", new String[]{ String.valueOf( NomiL.getRowid())});
        } finally {
            db.close();
        }
    }
    
    /**
     * idでBizCardをロードする
     * @param rowId PK
     * @return ロード結果
     */
    public NLog load(Long rowId) {
        SQLiteDatabase db = helper.getReadableDatabase();
        
        NLog NomiL = null;
        try {
            Cursor cursor = db.query( NLog.TABLE_NAME, null, NLog.COLUMN_ID + "=?", new String[]{ String.valueOf( rowId)}, null, null, null);
            cursor.moveToFirst();
            NomiL = getNLog( cursor);
        } finally {
            db.close();
        }
        return NomiL;
    }
    
    /**
     * 一覧を取得する
     * @return 検索結果
     */
    public List<NLog> list() {
        SQLiteDatabase db = helper.getReadableDatabase();
        
        List<NLog> bizCardList;
        try {
            Cursor cursor = db.query( NLog.TABLE_NAME, null, null, null, null, null, NLog.COLUMN_ID);
            bizCardList = new ArrayList<NLog>();
            cursor.moveToFirst();
            while( !cursor.isAfterLast()){
                bizCardList.add( getNLog( cursor));
                cursor.moveToNext();
            }
        } finally {
            db.close();
        }
        return bizCardList;
    }
    
    /**
     * カーソルからオブジェクトへの変換
     * @param cursor カーソル
     * @return 変換結果
     */
    private NLog getNLog( Cursor cursor){
    	NLog NomiL = new NLog();

    	NomiL.setRowid( cursor.getLong(0));
    	NomiL.setShopName( cursor.getString(1));
    	NomiL.setZip( cursor.getString(2));
    	NomiL.setAddress( cursor.getString(3));
    	NomiL.setTel( cursor.getString(4));
    	NomiL.setValue( cursor.getString(5));
    	NomiL.setTag( cursor.getString(6));

        return NomiL;
    }
}