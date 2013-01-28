package jp.sale.databaseren;

public class DBNL {
	protected int id;
	protected String shop;
	protected String zipcode;
	protected String address;
	protected String tel;
	protected String eva;
	protected String memo;
	protected String tag;
	protected String lastupdate;
	
	public DBNL(int id, String shop, String zipcode, String address, String tel, 
			String eva, String memo, String tag, String lastupdate){
	    this.id = id;
	    this.shop = shop;
	    this.zipcode = zipcode;
	    this.address = address;
	    this.tel = tel;
	    this.eva = eva;
	    this.memo = memo;
	    this.tag = tag;
	    this.lastupdate = lastupdate;
	}
	
	public String getshop(){
	    return shop;
	}
	
	public String getzipcode(){
	    return zipcode;
	}
	
	public String getaddress(){
	    return address;
	}
	
	public String gettel(){
	    return tel;
	}
	
	public String geteva(){
	    return eva;
	}
	
	public String getmemo(){
	    return memo;
	}
	
	public String gettag(){
	    return tag;
	}
	
	public String getLastupdate(){
		    return lastupdate;
	}
		  
	public int getId(){
		    return id;
	}
}
