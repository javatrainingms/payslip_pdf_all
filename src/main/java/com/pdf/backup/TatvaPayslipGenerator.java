package com.pdf.backup;
import java.io.IOException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Link;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class TatvaPayslipGenerator {
	static String fontPath = "fonts/Arial.ttf"; // Path to Arial Bold font file

	public static void main(String[] args) {
		String filePath = "Payslip-Nikhileswari.pdf";


		try {
			// Create PDF Writer
			PdfWriter writer = new PdfWriter(filePath);

			// Create PDF Document
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Add a new page to the document
			PdfPage page = pdfDoc.addNewPage();

			// Create Document layout
			Document document = new Document(pdfDoc,PageSize.A4);

			// Add Header
			addHeader(document, pdfDoc);

			// Add Employee Details
			addEmployeeDetails(document);

			// Add Earnings and Deductions
			addEarningsAndDeductions(document);


			// Add Footer
			addFooter(document,pdfDoc);

			// Close Document
			document.close();

			System.out.println("Payslip generated successfully at " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addFooter(Document document,PdfDocument pdfDoc) throws IOException {
		// Create a rectangle for the footer background
		PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Add a horizontal line on the first page using PdfCanvas
		float xStart = 36; // starting x position
		float yStart = 300; // starting y position
		float xEnd = PageSize.A4.getWidth() - 36;  // ending x position (width of A4 - margin)
		float lineThickness = 1.5f; // line thickness
		Color lineColor = new DeviceRgb(235, 235, 235); // Light gray
		pdfCanvas.setLineWidth(lineThickness)
		.setFillColor(lineColor)
		.moveTo(xStart, yStart)  // set start point
		.lineTo(xEnd, yStart)    // set end point
		.stroke();               // draw the line

		Paragraph footer = new Paragraph()
				.add("This is computer generated payslip signature not required.\n")
				.setFontColor(Color.BLACK)
				.setFixedPosition(50, 285, 400) // Position text next to the logo
				.setFontSize(8)
				.setMarginTop(30)
				.setTextAlignment(TextAlignment.LEFT);
		document.add(footer);
	}
	private static void addEarningsAndDeductions(Document document) throws Exception{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		float columnWidth1[] = {60,150,60,120};
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
		// Add Rows
		table.addCell(new Cell().add("BASIC")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("12345")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("PROFESSIONAL TAX")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("200")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add("HOUSE RENT ALLOWANCE")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("3430")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("PROVIDENT FUND")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("1800")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));

		// Add Rows
		table.addCell(new Cell().add("MEDICAL ALLOWANCE")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("1250")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add("SPECIAL ALLOWANCE")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("7753")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));

		// Add Rows
		table.addCell(new Cell().add("\n\n\nSALARY ARREAR")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("\n\n\n22866")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add("Total Earnings Rs")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("47732")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("Total Deductions Rs")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("2000")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));



		document.add(table);

		// Totals
		float columnWidth2[] = {50,150};
		Table table2 = new Table(columnWidth2)
				.setFixedPosition(50, 300, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)

		table2.addCell(new Cell().add("Net Amount")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		table2.addCell(new Cell().add("45732")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));


		table2.addCell(new Cell().add("Net Pay in Words")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		table2.addCell(new Cell().add("Forty Five Thousand Seven Hundred Thirty Two Rupees Only")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		document.add(table2);


	}


	private static void addEmployeeDetails(Document document) throws Exception {

		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Paragraph details = new Paragraph()
				.add("\n\n\n\nPaySlip For the Month of October 2024")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);
		document.add(details);
		float columnWidth1[] = {60,150,60,120};
		Table custinfo = new Table(columnWidth1)
				.setBorder(Border.NO_BORDER)
				.setFixedPosition(100, 600, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)


		custinfo.addCell(new Cell().add("Employee No")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("TAT2502")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Emp Name")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("D Nikileswari")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Date of Joining")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("23/07/2024")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Designation")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Software Engineer")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Gender")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Female")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Bank Acc. No.")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("159676592606")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("PAN No.")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("BWBPN4094D")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("Bank Name")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("INDUSIND")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));



		custinfo.addCell(new Cell().add("LOP.")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("0.00")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("Salary Paid")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("45732")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("Total Days")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("31.00")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Uan No")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("102114836153")
				.setFontSize(9)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		document.add(custinfo);

	}


	private static void addHeader(Document document, PdfDocument pdfDoc) throws IOException {
		// Create a rectangle for the header background

		// Use PdfCanvas to draw the rectangle
		PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Add an image (Company Logo)
		try {
			String imagePath = "logo.png"; // Replace with your image path
			ImageData logoData = ImageDataFactory.create(imagePath);
			Image logo = new Image(logoData).scaleToFit(78, 44); // Scale logo to fit the header
			logo.setFixedPosition(127, 760); // Position the logo in the header
			document.add(logo);
		} catch (Exception e) {
			System.out.println("Error loading logo: " + e.getMessage());
		}
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);

		// Add the company name next to the logo
		Paragraph companyName = new Paragraph("Tatva Software Services Private Limited")
				.setFont(arialBold)
				.setFontSize(11)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setBold()
				.setTextAlignment(TextAlignment.LEFT)
				.setFixedPosition(234, 784,400); // Position text next to the logo
		document.add(companyName);

		Paragraph companyAddress = new Paragraph("Tower B, Brigade Tech Park, Pattandur Agrahara, Whitefield,")
				.setFont(arialBold)
				.setFontSize(9)
				.setFontColor(new DeviceRgb(0, 0, 0))
				//				.setBold()
				.setTextAlignment(TextAlignment.LEFT)
				.setFixedPosition(218, 769, 400); // Position text next to the logo
		document.add(companyAddress);

		// Create an email link
		String email = "mailto:Hr@tatvasoftwareservices.com";
		String linkText = "Hr@tatvasoftwareservices.com";

		// Create a Link element and set the PdfAction
		Link emailLink = new Link(linkText, PdfAction.createURI(email));
		emailLink.setFontColor(new DeviceRgb(0, 0, 100)) // Set text color to black
		.setUnderline(); // Underline the link text


		Paragraph companyEmail = new Paragraph("Bengaluru, Karnataka-560066,||Email: ")
				.add(emailLink)
				.setFont(arialBold)
				.setFontSize(9)
				.setFontColor(new DeviceRgb(0, 0, 0))
				//		.setBold()
				.setTextAlignment(TextAlignment.LEFT)
				.setFixedPosition(200, 756, 400); // Position text next to the logo
		document.add(companyEmail);
		// Add a horizontal line on the first page using PdfCanvas
		float xStart = 36; // starting x position
		float yStart = 750; // starting y position
		float xEnd = PageSize.A4.getWidth() - 36;  // ending x position (width of A4 - margin)
		float lineThickness = 1.5f; // line thickness
		Color lineColor = new DeviceRgb(235, 235, 235); // Light gray
		pdfCanvas.setLineWidth(lineThickness)
		.setFillColor(lineColor)
		.moveTo(xStart, yStart)  // set start point
		.lineTo(xEnd, yStart)    // set end point
		.stroke();               // draw the line
	}
}
