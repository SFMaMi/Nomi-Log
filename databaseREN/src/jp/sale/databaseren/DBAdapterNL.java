package jp.sale.databaseren;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapterNL {
	static final String DATABASE_NAME = "DBNL.db";
	  static final int DATABASE_VERSION = 1;
	  
	  public static final String TABLE_NAME = "DBNL";
	  public static final String COL_ID = "_id";
	  public static final String COL_SHOP = "shop";
	  public static final String COL_ZIPCODE = "zipcode";
	  public static final String COL_ADDRESS = "address";
	  public static final String COL_TEL = "tel";
	  public static final String COL_EVALUATION = "evaluation";
	  public static final String COL_MEMO = "memo";
	  public static final String COL_TAG = "tag";
	  public static final String COL_LASTUPDATE = "lastupdate";

	  protected final Context context;
	  protected DatabaseHelper dbHelper;
	  protected SQLiteDatabase db;
	  
	  public DBAdapterNL(Context context){
	    this.context = context;
	    dbHelper = new DatabaseHelper(this.context);
	  }
	  
	  //
	  // SQLiteOpenHelper
	  //
	  
	  private static class DatabaseHelper extends SQLiteOpenHelper {

	    public DatabaseHelper(Context context) {
	      super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	    
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	      db.execSQL(
	        "CREATE TABLE " + TABLE_NAME + " ("
	        + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
	        + COL_SHOP + " TEXT NOT NULL,"
	        + COL_ZIPCODE + " TEXT NOT NULL,"
	        + COL_ADDRESS + " TEXT NOT NULL,"
	        + COL_TEL + " TEXT NOT NULL,"
	        + COL_EVALUATION + " TEXT NOT NULL,"
	        + COL_MEMO + " TEXT NOT NULL,"
	        + COL_TAG + " TEXT NOT NULL,"
	        + COL_LASTUPDATE + " TEXT NOT NULL);");
	    }
	    

	    @Override
	    public void onUpgrade(
	      SQLiteDatabase db,
	      int oldVersion,
	      int newVersion) {
	      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	      onCreate(db);
	    }
	    
	  }
	    
	  //
	  // Adapter Methods
	  //
	  
	  public DBAdapterNL open() {
	    db = dbHelper.getWritableDatabase();
	    return this;
	  }
	  
	  
	  public void close(){
	    dbHelper.close();
	  }
	  

	  //
	  // App Methods
	  //
	  
	  
	  public boolean deleteAllNotes(){
	    return db.delete(TABLE_NAME, null, null) > 0;
	  }
	  
	  public boolean deleteNote(int id){
	    return db.delete(TABLE_NAME, COL_ID + "=" + id, null) > 0;
	  }
	  
	  public Cursor getAllNotes(){
	    return db.query(TABLE_NAME, null, null, null, null, null, null);
	  }
	  /*
	  public void saveINFO(String shop, String zipcode, String address, String tel){
	    Date dateNow = new Date ();
	    ContentValues values = new ContentValues();
	    values.put(COL_SHOP, shop);
	    values.put(COL_ZIPCODE, zipcode);
	    values.put(COL_ADDRESS, address);
	    values.put(COL_TEL, tel);
	    values.put(COL_LASTUPDATE, dateNow.toLocaleString());
	    db.insertOrThrow(TABLE_NAME, null, values);
	  }
	  
	  public void saveEVA(String eva){
		  Date dateNow = new Date ();
		  ContentValues values = new ContentValues();
		  values.put(COL_EVALUATION, eva);
		  values.put(COL_LASTUPDATE, dateNow.toLocaleString());
		  db.insertOrThrow(TABLE_NAME, null, values);
	  }
	  
	  public void saveMEMO(String memo){
		  Date dateNow = new Date ();
		  ContentValues values = new ContentValues();
		  values.put(COL_MEMO, memo);
		  values.put(COL_LASTUPDATE, dateNow.toLocaleString());
		  db.insertOrThrow(TABLE_NAME, null, values);
	  }
	  
	  public void saveTAG(String tag){
		  Date dateNow = new Date ();
		  ContentValues values = new ContentValues();
		  values.put(COL_TAG, tag);
		  values.put(COL_LASTUPDATE, dateNow.toLocaleString());
		  db.insertOrThrow(TABLE_NAME, null, values);
	  }
	  */
}
