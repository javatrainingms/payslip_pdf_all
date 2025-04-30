package com.pdf.generate;

public class EarningsAndDeduction {

	private String employeeId;
	private int basicSalary;
	private int hra;
	private int conveyance;
	private int medicalAllowance;
	private int specialAllowance;
	private int totalEarningsRs;
	private int pt;
	private int pf;
	private int totalDeductionsRs;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getConveyance() {
		return conveyance;
	}
	public void setConveyance(int conveyance) {
		this.conveyance = conveyance;
	}
	public int getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(int medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public int getSpecialAllowance() {
		return specialAllowance;
	}
	public void setSpecialAllowance(int specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	public int getTotalEarningsRs() {
		return totalEarningsRs;
	}
	public void setTotalEarningsRs(int totalEarningsRs) {
		this.totalEarningsRs = totalEarningsRs;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getTotalDeductionsRs() {
		return totalDeductionsRs;
	}
	public void setTotalDeductionsRs(int totalDeductionsRs) {
		this.totalDeductionsRs = totalDeductionsRs;
	}
	public EarningsAndDeduction(String employeeId, int basicSalary, int hra, int conveyance, int medicalAllowance,
			int specialAllowance, int totalEarningsRs, int pt, int pf, int totalDeductionsRs) {
		super();
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyance = conveyance;
		this.medicalAllowance = medicalAllowance;
		this.specialAllowance = specialAllowance;
		this.totalEarningsRs = totalEarningsRs;
		this.pt = pt;
		this.pf = pf;
		this.totalDeductionsRs = totalDeductionsRs;
	}
	public EarningsAndDeduction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EarningsAndDeduction [employeeId=" + employeeId + ", basicSalary=" + basicSalary + ", hra=" + hra
				+ ", conveyance=" + conveyance + ", medicalAllowance=" + medicalAllowance + ", specialAllowance="
				+ specialAllowance + ", totalEarningsRs=" + totalEarningsRs + ", pt=" + pt + ", pf=" + pf
				+ ", totalDeductionsRs=" + totalDeductionsRs + "]";
	}
	
	
	
	
}
