package com.pdf.generate;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDetails {
	private String empid;
	private String empname;
	private String department;
	private LocalDate doj;
	private String designation;
	private String bankName;
	private int totalDays;
	private int lop;
	private long bankaccountNo;
	private long uanNo;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public int getLop() {
		return lop;
	}
	public void setLop(int lop) {
		this.lop = lop;
	}
	public long getBankaccountNo() {
		return bankaccountNo;
	}
	public void setBankaccountNo(long bankaccountNo) {
		this.bankaccountNo = bankaccountNo;
	}
	public long getUanNo() {
		return uanNo;
	}
	public void setUanNo(long uanNo) {
		this.uanNo = uanNo;
	}
	public EmployeeDetails(String empid, String empname, String department, LocalDate doj, String designation,
			String bankName, int totalDays, int lop, long bankaccountNo, long uanNo) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.department = department;
		this.doj = doj;
		this.designation = designation;
		this.bankName = bankName;
		this.totalDays = totalDays;
		this.lop = lop;
		this.bankaccountNo = bankaccountNo;
		this.uanNo = uanNo;
	}
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empid=" + empid + ", empname=" + empname + ", department=" + department + ", doj="
				+ doj + ", designation=" + designation + ", bankName=" + bankName + ", totalDays=" + totalDays
				+ ", lop=" + lop + ", bankaccountNo=" + bankaccountNo + ", uanNo=" + uanNo + "]";
	}
	
	
	
	
	

}
