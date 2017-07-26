package com.zhongying.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.zhongying.pojo.Device;

public class DeviceClient {
	
	private static String url = "http://127.0.0.1:8080/Jersey/rest";
	
	public static void getWithHttpClient() throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url+"/device/get/DEV00000,DEV00001");
		getRequest.addHeader("accept", "application/xml");
		HttpResponse response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode()+ " " +response.getStatusLine().getReasonPhrase());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		System.out.println("Output from Server .... \n");
		String output = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		httpClient.getConnectionManager().shutdown();

	}
	
	public static void postWithHttpClient() throws ClientProtocolException, IOException, JAXBException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(url+"/device/insert1");
		
		Device d = new Device();
		d.setDetailModelCode("test1");
		d.setDeviceID("device1");
		d.setDeviceModelCode("test2");
		d.setDeviceName("test3");
		d.setDevicePropCode("test4");
		d.setDeviceTypeCode("test5");
		d.setIsNew("0");
		d.setLoopAddress("1.2.3.5");
		d.setNodeCode("NOD999");
		
//		JAXBContext context = JAXBContext.newInstance(Device.class);  
//        Marshaller marshaller = context.createMarshaller(); 
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(d, writer);
//        System.out.println(writer.toString());
//        StringEntity input = new StringEntity(writer.toString());
//		input.setContentType("application/xml");
		
		JSONObject json = JSONObject.fromObject(d);
		StringEntity input = new StringEntity(json.toString());
		input.setContentType("application/json");

		postRequest.setEntity(input);
		HttpResponse response = httpClient.execute(postRequest);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		System.out.println("Output from Server .... \n");
		String output = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		httpClient.getConnectionManager().shutdown();
	}
	
	public static void putWithHttpClient() throws ClientProtocolException, IOException, JAXBException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPut putRequest = new HttpPut(url+"/device/update");
		
		Device d = new Device();
		d.setDetailModelCode("test1");
		d.setDeviceID("device1");
		d.setDeviceModelCode("test2");
		d.setDeviceName("test3");
		d.setDevicePropCode("test4");
		d.setDeviceTypeCode("test5");
		d.setIsNew("0");
		d.setLoopAddress("1.2.3.5");
		d.setNodeCode("NOD999");
		
//		JAXBContext context = JAXBContext.newInstance(Device.class);  
//        Marshaller marshaller = context.createMarshaller(); 
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(d, writer);
//        System.out.println(writer.toString());
//        StringEntity input = new StringEntity(writer.toString());
//		input.setContentType("application/xml");
		
		JSONObject json = JSONObject.fromObject(d);
		StringEntity input = new StringEntity(json.toString());
		input.setContentType("application/json");

		putRequest.setEntity(input);
		HttpResponse response = httpClient.execute(putRequest);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		System.out.println("Output from Server .... \n");
		String output = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		httpClient.getConnectionManager().shutdown();
	}
	
	public static void deleteWithHttpClient() throws ClientProtocolException, IOException, JAXBException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpDelete deleteRequest = new HttpDelete(url+"/device/delete/DEV0000");

		deleteRequest.addHeader("accept", "application/xml");
		HttpResponse response = httpClient.execute(deleteRequest);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		System.out.println("Output from Server .... \n");
		String output = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		httpClient.getConnectionManager().shutdown();
	}
	
	public static void beanToXml(){
		try {  
			Device d = new Device();
			d.setDetailModelCode("test1");
			d.setDeviceID("device1");
			d.setDeviceModelCode("test2");
			d.setDeviceName("test3");
			d.setDevicePropCode("test4");
			d.setDeviceTypeCode("test5");
			d.setIsNew("0");
			d.setLoopAddress("1.2.3.5");
			d.setNodeCode("NOD999");
            JAXBContext context = JAXBContext.newInstance(Device.class);  
            Marshaller marshaller = context.createMarshaller(); 
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            StringWriter writer = new StringWriter();
            marshaller.marshal(d, writer);
            System.out.println(writer.toString());
            
          //反序列化
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            StringReader reader = new StringReader(writer.toString());
//            Device de = (Device) unmarshaller.unmarshal(reader);
//            System.out.println(de);
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }   
	}
	
	public static void get(){
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
		WebTarget target = client.target(url + "/device/get1/DEV00000,DEV00001"); 
		Response response = target.request().get();
//		String s = response.readEntity(String.class);
		List<Device> l = response.readEntity(List.class);
		System.out.println(l);
		response.close();
	}
	
	public static void put(){
		Device d = new Device();
		d.setDetailModelCode("qwe");
		d.setDeviceID("132");
		d.setDeviceModelCode("951");
		d.setDeviceName("wqe");
		d.setDevicePropCode("dssf");
		d.setDeviceTypeCode("43r34");
		d.setIsNew("0");
		d.setLoopAddress("1.2.3.4");
		d.setNodeCode("NOD000");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url + "/device/insert/"); 
		Response response = target.request().buildPost(Entity.entity(d, MediaType.APPLICATION_JSON)).invoke();
		Map<String, String> m = response.readEntity(Map.class);
		System.out.println(m);
		response.close();
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException, JAXBException{
//		beanToXml();
//		getWithHttpClient();
//		postWithHttpClient();
//		putWithHttpClient();
		deleteWithHttpClient();
//		get();
//		put();
	}
}
