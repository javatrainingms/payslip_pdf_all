package com.pdf.generate.soc;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	 public static String toTitleCase(String fullName) {
	        return Arrays.stream(fullName.split("\\s+"))  // Split by spaces
	                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()) // Capitalize first letter
	                .collect(Collectors.joining(" "));  // Join back to a single string
	    }
    public static List<EmployeeDetails> readEmployeeData(String filePath) {
        List<EmployeeDetails> employees = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            // Skip the header row (index 0)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                EmployeeDetails employee = new EmployeeDetails();
                employee.setEmpid(getCellValue(row,0));
                employee.setEmpname(getCellValue(row,1));
                employee.setEmpname(toTitleCase(employee.getEmpname()));
                
                employee.setDepartment(getCellValue(row,2));
                employee.setDesignation(getCellValue(row,3));

                employee.setDoj(getCellValue(row,4));
                
                employee.setBankName(getCellValue(row,5));
                employee.setBankaccountNo((long) getCellNumericValue(row,6));
                employee.setUanNo((long) getCellNumericValue(row,7));
                
                employee.setTotalDays((int) getCellNumericValue(row,8));
                employee.setLop((int) getCellNumericValue(row,9));

               
                // Handle possible null cells with default values
                employee.setBasicSalary(getCellNumericValue(row, 10));
                employee.setHra(getCellNumericValue(row, 11));
                employee.setConveyance(getCellNumericValue(row, 12));
                employee.setMedicalAllowance(getCellNumericValue(row, 13));
                employee.setSpecialAllowance(getCellNumericValue(row, 14));
                employee.setPt(getCellNumericValue(row, 15));
                employee.setPf(getCellNumericValue(row, 16));
                employee.setSalaryArrear(getCellNumericValue(row, 17));
                
                employee.setTotalEarningsRs(employee.getBasicSalary()+employee.getHra()
    			+employee.getConveyance()+employee.getMedicalAllowance()+employee.getSpecialAllowance()+employee.getSalaryArrear());

                employee.setTotalDeductionsRs(employee.getPf()+employee.getPt());

                employee.setNetAmount(employee.getTotalEarningsRs()-employee.getTotalDeductionsRs());

                employee.setEmail(getCellValue(row, 18));
                employee.setMonth(getCellValue(row, 19));
                employee.setYear((int)getCellNumericValue(row, 20));
                employee.setDob(getCellValue(row, 21));
                employee.setPanNo(getCellValue(row, 22));
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }


 // Utility method to safely get numeric value from a cell, returning 0 if the cell is null or has an error
    private static double getCellNumericValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            return 0; // Return 0 if the cell is null
        }

        // Using the updated method to get the cell type
        switch (cell.getCellTypeEnum()) { // Use getCellTypeEnum() in older versions of Apache POI (pre-5.0)
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0; // If the value can't be parsed as a number, return 0
                }
            default:
                return 0; // Default to 0 for other cases (e.g., boolean, formula)
        }
    }

    private static String getCellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            return ""; // Return empty string if the cell is null
        }

        // Handle different cell types
        switch (cell.getCellTypeEnum()) { // Use getCellType() for POI 5.x or newer
            case STRING:
                return cell.getStringCellValue(); // Return the string value directly
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // If the numeric value represents a date
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Desired date format
                    return sdf.format(date); // Format the date as a string
                } else {
                    // If it's not a date, return the numeric value as string
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // Convert boolean to string
            default:
                return ""; // Return empty string for other cases (e.g., formula)
        }
    }
    
    public static void main(String[] args) {
        String filePath = "EmpDetails.xlsx";
        List<EmployeeDetails> employeeList = readEmployeeData(filePath);

        // Print the employee details
        for (EmployeeDetails emp : employeeList) {
            System.out.println("ID: " + emp.getEmpid());
            System.out.println("Name: " + emp.getEmpname());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("DOJ: " + emp.getDoj());
            System.out.println("Designation: " + emp.getDesignation());
            System.out.println("Bank Name: " + emp.getBankName());
            System.out.println("Total Days: " + emp.getTotalDays());
            System.out.println("LOP: " + emp.getLop());
            System.out.println("Bank Account No: " + emp.getBankaccountNo());
            System.out.println("UAN No: " + emp.getUanNo());
            System.out.println("------------");
        }
    }


}

