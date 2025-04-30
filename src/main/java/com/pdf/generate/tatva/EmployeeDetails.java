package com.pdf.generate.tatva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
	private String empid;
	private String empname;
	private String doj;
	private String designation;
	private String gender;
	private long bankaccountNo;
	private String panNo;
	private String bankName;
	private int lop;
	private int totalDays;
	private long uanNo;

	private double basicSalary;
	private double hra;
	private double medicalAllowance;
	private double specialAllowance;
	private double salaryArrear;
	private double totalEarningsRs;
	private double pt;
	private double pf;
	private double insurence;
	private double lopDeductions;
	private double totalDeductionsRs;
	private double netAmount;
	private String email;
	private String month;
	private int year;
	private String dob;


}
