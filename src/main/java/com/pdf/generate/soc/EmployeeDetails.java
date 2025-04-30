package com.pdf.generate.soc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
	private String empid;
	private String empname;
	private String department;
	private String doj;
	private String designation;
	private String bankName;
	private int totalDays;
	private int lop;
	private long bankaccountNo;
	private long uanNo;
	private double basicSalary;
	private double hra;
	private double conveyance;
	private double medicalAllowance;
	private double specialAllowance;
	private double totalEarningsRs;
	private double pt;
	private double pf;
	private double salaryArrear;
	private double totalDeductionsRs;
	private double netAmount;
	private String email;
	private String month;
	private int year;
	private String dob;
	private String panNo;
	
}
