package com.mongo.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="car")
public class CarDoc implements Serializable {

	/**
	 * car do
	 */
	private static final long serialVersionUID = -2521905776373135264L;
	@Field("id")
	private String id;
	private String carName;
	private Integer cityId;
	private Long price;
	private Date sessionTime;
	private Date registerTime;
	private Date checkTime;
	private Integer brandId;
	private Integer carDepartmentId;
	private Integer carModelId;
	private Long mileage;// 里程数
	private String license;//车牌号
	private Integer conditionGrade;//车况评级
	public CarDoc() {
		super();
	}
	public CarDoc(String id, String carName, Integer cityId, Long price, Date sessionTime, Date registerTime,
			Date checkTime, Integer brandId, Integer carDepartmentId, Integer carModelId, Long mileage,
			String license, Integer conditionGrade) {
		super();
		this.id = id;
		this.carName = carName;
		this.cityId = cityId;
		this.price = price;
		this.sessionTime = sessionTime;
		this.registerTime = registerTime;
		this.checkTime = checkTime;
		this.brandId = brandId;
		this.carDepartmentId = carDepartmentId;
		this.carModelId = carModelId;
		this.mileage = mileage;
		this.license = license;
		this.conditionGrade = conditionGrade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Date getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getCarDepartmentId() {
		return carDepartmentId;
	}
	public void setCarDepartmentId(Integer carDepartmentId) {
		this.carDepartmentId = carDepartmentId;
	}
	public Integer getCarModelId() {
		return carModelId;
	}
	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Integer getConditionGrade() {
		return conditionGrade;
	}
	public void setConditionGrade(Integer conditionGrade) {
		this.conditionGrade = conditionGrade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
