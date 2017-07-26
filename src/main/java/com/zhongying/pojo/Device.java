package com.zhongying.pojo;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {
	
	private String deviceID;

	private String deviceName;

	private String loopAddress;

	private String deviceTypeCode;

	private String deviceModelCode;

	private String detailModelCode;

	private String devicePropCode;

	private String isNew;

	private String nodeCode;
	
	public Device(){}
	
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getLoopAddress() {
		return loopAddress;
	}
	public void setLoopAddress(String loopAddress) {
		this.loopAddress = loopAddress;
	}
	public String getDeviceTypeCode() {
		return deviceTypeCode;
	}
	public void setDeviceTypeCode(String deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}
	public String getDeviceModelCode() {
		return deviceModelCode;
	}
	public void setDeviceModelCode(String deviceModelCode) {
		this.deviceModelCode = deviceModelCode;
	}
	public String getDetailModelCode() {
		return detailModelCode;
	}
	public void setDetailModelCode(String detailModelCode) {
		this.detailModelCode = detailModelCode;
	}
	public String getDevicePropCode() {
		return devicePropCode;
	}
	public void setDevicePropCode(String devicePropCode) {
		this.devicePropCode = devicePropCode;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	@Override
	public String toString() {
		return "Device [deviceID=" + deviceID + ", deviceName=" + deviceName
				+ ", loopAddress=" + loopAddress + ", deviceTypeCode="
				+ deviceTypeCode + ", deviceModelCode=" + deviceModelCode
				+ ", detailModelCode=" + detailModelCode + ", devicePropCode="
				+ devicePropCode + ", isNew=" + isNew + ", nodeCode="
				+ nodeCode + "]";
	}
	
	
}
