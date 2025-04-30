package com.pdf.generate.soc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class SocPayslipGenerator {
	static String fontPath = "fonts/CALIBRI.TTF"; // Path to Arial Bold font file
	
	

	public static void main(String[] args) {


		List<EmployeeDetails> employeeList = ExcelReader.readEmployeeData("SOC Sample Excel Sheet.xlsx");
		

		for (EmployeeDetails empDetails : employeeList) {
			Optional<String> empid = Optional.ofNullable(empDetails.getEmpid());
			if(empid.isPresent() && !empDetails.getEmpid().isEmpty())
			{
				
				try {
					String filePath = "Payslip-"+empDetails.getEmpid()+"_soc_"+empDetails.getMonth()+"-"+empDetails.getYear()+".pdf";
					// Create PDF Writer
					PdfWriter writer = new PdfWriter(filePath);

					// Create PDF Document
					PdfDocument pdfDoc = new PdfDocument(writer);

					// Add a new page to the document
					PdfPage page = pdfDoc.addNewPage();

					// Create Document layout
					Document document = new Document(pdfDoc,PageSize.A4);

					addHeader(document, pdfDoc);
					addEmployeeDetails(document,empDetails);
					addEarningsAndDeductions(document,empDetails);
					addFooter(document,pdfDoc);

					// Close Document
					document.close();

					System.out.println("Payslip generated successfully at " + filePath);
					String protectedfilePath = "Payslip-"+empDetails.getEmpid()+"_soc_"+empDetails.getMonth()+"-"+empDetails.getYear()+"-protected.pdf";
					System.out.println(empDetails);
					String password=empDetails.getPanNo().substring(0,4);
					String dd[]=empDetails.getDob().split("-");

					password=password+dd[0]+dd[1];
					System.out.println("password>>>"+password);
					SetPasswordForPDF.passwordProtected(filePath, protectedfilePath,password,"Java@123");

					File f=new File(filePath);
					if(f.exists())
					{
						f.deleteOnExit();
					}
					EmailSender.emailSend(empDetails,protectedfilePath);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}




	private static void addEmployeeDetails(Document document,EmployeeDetails empDetails) throws Exception {


		Paragraph details = SocPayslipEmployeeDetailsServices.forMonth(empDetails.getMonth(), empDetails.getYear()+"");
		document.add(details);

		float columnWidth1[] = {60,150,70,120};
		Table table = new Table(columnWidth1)
				.setBorder(Border.NO_BORDER)
				.setFixedPosition(60, 595, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)

		addRowWithNoBorder(table,"Employee ID",empDetails.getEmpid());
		addRowWithNoBorder(table,"Department",empDetails.getDepartment());

		addRowWithNoBorder(table,"Employee Name",empDetails.getEmpname());
		addRowWithNoBorder(table,"Date Of joining",empDetails.getDoj()+"");

		addRowWithNoBorder(table,"Designation",empDetails.getDesignation());
		addRowWithNoBorder(table,"Bank Name",empDetails.getBankName());

		addRowWithNoBorder(table,"Total Days",empDetails.getTotalDays()+"");
		addRowWithNoBorder(table,"Bank A/c No",empDetails.getBankaccountNo()+"");

		addRowWithNoBorder(table,"Lop Days",empDetails.getLop()+"");
		addRowWithNoBorder(table,"UAN No",empDetails.getUanNo()+"");

		document.add(table);

	}

	private static void addEarningsAndDeductions(Document document,EmployeeDetails empDetails) throws Exception{
		float columnWidth1[] = {100,100,100,120};
		Table table = new Table(columnWidth1)
				.setFixedPosition(50, 400, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)

		// Add Table Headers
		table.addCell(new Cell(1,2).add("Earnings")
				.setFontColor(Color.BLACK)
				.setTextAlignment(TextAlignment.CENTER)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell(1,2).add("Deductions")
				.setFontColor(Color.BLACK)
				.setTextAlignment(TextAlignment.CENTER)
				.setBold().setBackgroundColor(Color.WHITE));

		addRow(table,"Basic Pay",empDetails.getBasicSalary()+"");
		addRow(table,"PT",empDetails.getPt()+"");

		addRow(table,"HRA",empDetails.getHra()+"");
		addRow(table,"PF",empDetails.getPf()+"");

		addRow(table,"Conveyance",empDetails.getConveyance()+"");
		addRow(table,"","");
		

		addRow(table,"Medical Allowance",empDetails.getMedicalAllowance()+"");
		addRow(table,"","");

		addRow(table,"Special Allowance",empDetails.getSpecialAllowance()+"");
		addRow(table,"","");
		addRow(table,"\n\n\n","\n\n\n");
		addRow(table,"","");
		addRow(table,"Salary Arrear",empDetails.getSalaryArrear()+"");
		addRow(table,"","");

		addRow(table,"Total Earnings Rs",empDetails.getTotalEarningsRs()+"");

		addRow(table,"Total Deductions Rs",empDetails.getTotalDeductionsRs()+"");

		document.add(table);


		float columnWidth2[] = {50,150};
		Table table2 = new Table(columnWidth2)
				.setFixedPosition(60, 350, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)


		addRowWithNoBorder(table2,"Net Amount",empDetails.getNetAmount()+"");
		addRowWithNoBorder(table2,"Net Pay in Words",NumberToWordsIndian.numberToWords((int)empDetails.getNetAmount()));
		document.add(table2);
	}

	private static void addHeader(Document document, PdfDocument pdfDoc) throws Exception {

		Image logo = SocPayslipHeaderFooterServices.logo(); // Position the logo in the header
		document.add(logo);

		Paragraph companyName = SocPayslipHeaderFooterServices
				.headerParagraph("\n\n\n\nSoc Software Private Limited",10,26);
		document.add(companyName);

		Paragraph companyAddress = SocPayslipHeaderFooterServices
				.headerParagraph("Plot no.101,R Square Building,Kukatpally,Hyderabad-500072.",7,11);
		document.add(companyAddress);

		// Email link
		Paragraph companyEmail =SocPayslipHeaderFooterServices
				.headerEmail("Info@socsoftware.in","040-23354336");
		document.add(companyEmail);

		// draw the line
		strightline(pdfDoc,36,700);
	}

	private static void addFooter(Document document,PdfDocument pdfDoc) throws Exception {
		// Add a horizontal line on the first page using PdfCanvas
		strightline(pdfDoc,36,345);
		Paragraph footer =SocPayslipHeaderFooterServices
				.footerParagraph("This is computer generated payslip signature not required.",8);
		document.add(footer);
	}

	private static void addRow(Table table, String key, String value) throws IOException {
		if(!(key.contains("Total Earnings Rs") || (key.contains("Total Deductions Rs"))))
		{
			table.addCell(SocPayslipEarningsDeductionsServices.addCellKey(key,0));
			table.addCell(SocPayslipEarningsDeductionsServices.addCellValue(value,0));
		}
		else
		{
			table.addCell(SocPayslipEarningsDeductionsServices.addCellKey(key,1));
			table.addCell(SocPayslipEarningsDeductionsServices.addCellValue(value,1));
		}
	}

	private static void addRowWithNoBorder(Table table, String key, String value) throws IOException {
		table.addCell(SocPayslipEmployeeDetailsServices.addCellKey(key));
		table.addCell(SocPayslipEmployeeDetailsServices.addCellValue(value));
	}


	private static void strightline(PdfDocument pdfDoc,int x_start,int y_start)
	{
		PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getFirstPage());
		float xStart = x_start; // starting x position
		float yStart = y_start; // starting y position
		float xEnd = PageSize.A4.getWidth() - x_start;  // ending x position (width of A4 - margin)
		float lineThickness = 1.5f; // line thickness
		Color lineColor = new DeviceRgb(235, 235, 235); // Light gray
		pdfCanvas.setLineWidth(lineThickness)
		.setFillColor(lineColor)
		.moveTo(xStart, yStart)  // set start point
		.lineTo(xEnd, yStart)    // set end point
		.stroke();   
	}
}
