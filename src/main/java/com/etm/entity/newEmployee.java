package com.etm.entity;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class newEmployee implements Serializable {

	private String empId;
	private String empName;
	private long empPhone;
	private String empEmail;
	private String empDoj;
	private double empSalary;
	private String bloodType;
	private String gender;
	private String maritalStatus;
	private String address;
	private String roleName;
	private String mgrId;
	private String userName;
	private String userPassword;

	public newEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public newEmployee(String empId, String empName, long empPhone, String empEmail, String empDoj, double empSalary,
			String bloodType, String gender, String maritalStatus, String address, String roleName, String mgrId,
			String userName, String userPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.empDoj = empDoj;
		this.empSalary = empSalary;
		this.bloodType = bloodType;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.roleName = roleName;
		this.mgrId = mgrId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "newEmployee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empEmail="
				+ empEmail + ", empDoj=" + empDoj + ", empSalary=" + empSalary + ", bloodType=" + bloodType
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", address=" + address + ", roleName="
				+ roleName + ", mgrId=" + mgrId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}


	
	
}
