package com.example.tabtest;

import java.io.Serializable;



public class NLog implements Serializable{
	//テーブル名
	public static final String TABLE_NAME = "NLog";
	
	
	//カラム名
	public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SHOP_NAME = "shop_name";
    public static final String COLUMN_ZIP = "zip";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_TEL = "tel";
    public static final String COLUMN_VALUE = "value";
    public static final String COLUMN_TAG = "tag";
    
    
    //プロパティ
    private Long rowid = null;
    private String ShopName = null;
    private String zip = null;
    private String address = null;
    private String tel = null;
    private String value = null;
    private String tag = null;
	public Long getRowid() {
		return rowid;
	}
	public void setRowid(Long rowid) {
		this.rowid = rowid;
	}
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}
