package com.etm.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@XmlRootElement
@Table(name="Employee")
public class Employee implements Serializable {

	@Id
	@Column(name="emp_id")
	private String empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_phone")
	private int empPhone;
	
	@Column(name="emp_email")
	private String empEmail;
	
	@Column(name="emp_doj")
	private String empDoj;
	
	@Column(name="emp_salary")
	private double empSalary;
	
	@Column(name="blood_type")
	private String bloodType;
	
	private String gender;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	private String address;
	
	@Column(name="role_name")
	private String roleName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String empName, int empPhone, String empEmail, String empDoj, double empSalary,
			String bloodType, String gender, String maritalStatus, String address, String roleName) {
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

	public int getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(int empPhone) {
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empEmail=" + empEmail
				+ ", empDoj=" + empDoj + ", empSalary=" + empSalary + ", bloodType=" + bloodType + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", address=" + address + ", roleName=" + roleName + "]";
	}
	
	
	
	
}
