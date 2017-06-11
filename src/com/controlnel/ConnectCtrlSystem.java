package com.controlnel;

import java.util.ResourceBundle;

import com.jcraft.jsch.jce.MD5;

public class ConnectCtrlSystem {
	public String type = null;
	public String hostname = null;
	public String status = null;
	
	public String auth = null;
	public String server = null;
	public String func = null;
	
	private static ResourceBundle httpconfig = ResourceBundle.getBundle("com.controlnel.httpconfig");
	
	public ConnectCtrlSystem(){
		this.auth = httpconfig.getString("auth");
		this.server = httpconfig.getString("server");
		this.func = httpconfig.getString("func");
	}
	
	public int GetConnectCtrl(String type,String hostname,String status){
		String url = "";
		if (type.toString() == "" || hostname.toString() == "" || status.toString() == ""){
			return 0;
		} else {
			url = this.server +"/"+this.func+"/"+type+"/"+hostname+"/"+this.auth+"/"+status;
		}
		System.out.println(url);
		HttpApache httpa = new HttpApache();
		String flag = httpa.httpGet(url);
		if (flag.equals("1")){
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args)  {
    	ConnectCtrlSystem test = new ConnectCtrlSystem();
    	int i = test.GetConnectCtrl("hd", "HD-1", "0");
    	System.out.println(i);
    }
}
