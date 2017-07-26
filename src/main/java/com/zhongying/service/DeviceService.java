package com.zhongying.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zhongying.pojo.Device;
import com.zhongying.pojo.DeviceForm;
import com.zhongying.pojo.Result;

@Path("/device")
public class DeviceService {
	
	//查询, 浏览器和client都可以访问
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	@Path("/get/{deviceID}")
	public List<Device> queryDevice(@PathParam("deviceID")String deviceIDs, @Context HttpServletResponse response){
		System.out.println("method queryDevice is called...");
		System.out.println("deviceIDs="+deviceIDs);
		//通过这句话解决Access-Control-Allow-Origin跨域问题  但是安全性不好
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Device> list = new ArrayList<Device>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.173:1521:dbnms", "slview", "slview");
			String sql = "select * from device where deviceid in ('"+deviceIDs.replace(",", "','")+"')";
			System.out.println("sql="+sql);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Device d = new Device();
				d.setDetailModelCode(rs.getString("detailmodelcode"));
				d.setDeviceID(rs.getString("deviceid"));
				d.setDeviceModelCode(rs.getString("DeviceModelCode"));
				d.setDeviceName(rs.getString("devicename"));
				d.setDevicePropCode(rs.getString("DevicePropCode"));
				d.setDeviceTypeCode(rs.getString("DeviceTypeCode"));
				d.setIsNew(rs.getString("isnew"));
				d.setLoopAddress(rs.getString("loopaddress"));
				d.setNodeCode(rs.getString("nodecode"));
				list.add(d);
			}
		} catch(Exception e){
			System.out.println("queryDevice has occured an error...");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("result: "+list);
		System.out.println("method queryDevice is end...");
		return list;
	}
	
	//添加    MediaType.APPLICATION_FORM_URLENCODED会报415?
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML})
//	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	@Path("/insert")
	public Result insertDevice(@Context Device d,@Context Request request,@Context UriInfo uriInfo,@Context HttpHeaders httpHeader, @Context HttpServletResponse response){
		System.out.println("method insertDevice is called...");
		System.out.println("Device="+d);

		//通过这句话解决Access-Control-Allow-Origin跨域问题  但是安全性不好
		response.setHeader("Access-Control-Allow-Origin", "*");
		
//		System.out.println("deviceID="+d.getDeviceID());
//		System.out.println("deviceName="+d.getDeviceName());
//		System.out.println("loopaddress="+d.getLoopAddress());
		
		Result result = new Result();
		result.setResCode("0");
		result.setResDesc("ok");
		
		System.out.println("result: "+result);
		System.out.println("method insertDevice is end...");
		return result;
	}
	
	
	
	
	//insert  浏览器直接提交可用
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	@Path("/insert1")
	public Result insertDevice1(@BeanParam DeviceForm d,@Context Request request,@Context UriInfo uriInfo,@Context HttpHeaders httpHeader, @Context HttpServletResponse response){
		System.out.println("method insertDevice1 is called...");
		System.out.println("Device="+d);
		
		//通过这句话解决Access-Control-Allow-Origin跨域问题  但是安全性不好
		response.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("deviceID="+d.getDeviceID());
		System.out.println("deviceName="+d.getDeviceName());
		System.out.println("loopaddress="+d.getLoopAddress());
		Result result = new Result();
		result.setResCode("0");
		result.setResDesc("ok");
		
		System.out.println("result: "+result);
		System.out.println("method insertDevice1 is end...");
		return result;
	}
	
	//update 客户端可用  浏览器调用会报415
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	@Path("/update")
	public Result updateDevice(Device d,@Context Request request,@Context UriInfo uriInfo,@Context HttpHeaders httpHeader, @Context HttpServletResponse response){
		System.out.println("method updateDevice is called...");
		System.out.println("Device="+d);

		System.out.println("deviceID="+d.getDeviceID());
		System.out.println("deviceName="+d.getDeviceName());
		System.out.println("loopaddress="+d.getLoopAddress());
		Result result = new Result();
		result.setResCode("0");
		result.setResDesc("ok");
		
		System.out.println("result: "+result);
		System.out.println("method updateDevice is end...");
		return result;
	}
	
	//delete 客户端可用  浏览器调用会报415
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	@Path("/delete/{deviceID}")
	public Result deleteDevice(@PathParam("deviceID") String deviceID,@Context Request request,@Context UriInfo uriInfo,@Context HttpHeaders httpHeader, @Context HttpServletResponse response){
		System.out.println("method deleteDevice is called...");
		System.out.println("Device="+deviceID);

		System.out.println("deviceID="+deviceID);

		Result result = new Result();
		result.setResCode("0");
		result.setResDesc("ok");
		
		System.out.println("result: "+result);
		System.out.println("method deleteDevice is end...");
		return result;
	}
}
