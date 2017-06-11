package com.controlnel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.view.t;

public class HttpApache {
	protected HttpResponse httpResponse;
	protected Header[] httpheaders ;
	protected Header content_long;
	
	public String httpGet(String url)
	{
		String response = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//HttpClient httpclient = new DefaultHttpClient();
		//创建HttpGet对象
		HttpGet httpGet = new HttpGet(url);
		
		try
		{
			//使用execute方法发送HTTP GET请求，并返回HttpResponse对象
			httpResponse = httpclient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			httpheaders= httpResponse.getAllHeaders();
			content_long = httpResponse.getFirstHeader("Content-Length");
			if(statusCode==HttpStatus.SC_OK)
			{
				//获得返回结果
				response = EntityUtils.toString(httpResponse.getEntity());
			}
			else
			{
				response = "0";
				
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
			response = "0";
		}
		//System.out.println(response);
		return response;
	}
	
	    public static void main(String[] args)  {
	    	HttpApache f = new HttpApache();
	    	f.httpGet("http://127.0.0.1:7081/makeuphost/hd/HD1");
	    }
}