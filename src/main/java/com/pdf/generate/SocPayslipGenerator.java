package com.pdf.generate;
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
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class SocPayslipGenerator {
	static String fontPath = "fonts/CALIBRI.TTF"; // Path to Arial Bold font file

	public static void main(String[] args) {
		String filePath = "Payslip-Nikhileswari_soc.pdf";


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
		float yStart = 345; // starting y position
		float xEnd = PageSize.A4.getWidth() - 36;  // ending x position (width of A4 - margin)
		float lineThickness = 1.5f; // line thickness
		Color lineColor = new DeviceRgb(235, 235, 235); // Light gray
		pdfCanvas.setLineWidth(lineThickness)
		.setFillColor(lineColor)
		.moveTo(xStart, yStart)  // set start point
		.lineTo(xEnd, yStart)    // set end point
		.stroke();               // draw the line

		Paragraph footer = new Paragraph()
				.add("This is computer generated payslip signature not required.")
				.setFontColor(Color.BLACK)
				.setFixedPosition(50, 330, 400) // Position text next to the logo
				.setFontSize(8)
				.setMarginTop(30)
				.setTextAlignment(TextAlignment.LEFT);
		document.add(footer);
	}
	private static void addEarningsAndDeductions(Document document) throws Exception{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
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
		// Add Rows
		table.addCell(new Cell().add("Basic Pay")
				.setFontSize(10)
				.setFont(arialBold)
                .setPaddingLeft(5)    // Remove padding inside the cell
                .setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("21000")
				.setFontSize(10)
				.setFont(arialBold)
                .setPaddingLeft(5)    // Remove padding inside the cell
                .setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add(" PT")
				.setFontSize(10)
				.setFont(arialBold)
                .setPaddingLeft(5)    // Remove padding inside the cell
                .setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("200")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add(" HRA")
				.setFontSize(10)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
                .setPaddingLeft(5)    // Remove padding inside the cell
                .setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("7000")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add(" PF")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("1800")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add(" Conveyance")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("0")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));

		// Add Rows
		table.addCell(new Cell().add(" Medical Allowance")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("1250")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add(" Special Allowance")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("7753")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderRight(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderLeft(Border.NO_BORDER)
				.setBorderBottom(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));

		// Add Rows
		table.addCell(new Cell().add("\n\n\n")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("\n\n\n")
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("")
				.setFontColor(Color.BLACK)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setBorderLeft(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		// Add Rows
		table.addCell(new Cell().add(" Total Earnings Rs")
				.setFontSize(9)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setBorderTop(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("47732")
				.setFontSize(9)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));
		table.addCell(new Cell().add(" Total Deductions Rs")
				.setFontSize(9)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderRight(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));

		table.addCell(new Cell().add("2000")
				.setFontSize(9)
				.setFont(arialBold)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorderLeft(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE));



		document.add(table);

		// Totals
		float columnWidth2[] = {50,150};
		Table table2 = new Table(columnWidth2)
				.setFixedPosition(50, 350, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)

		table2.addCell(new Cell().add("Net Amount")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		table2.addCell(new Cell().add("45732")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));


		table2.addCell(new Cell().add("Net Pay in Words")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE));
		table2.addCell(new Cell().add("Forty Five Thousand Seven Hundred Thirty Two Rupees Only")
				.setFontSize(10)
				.setPaddingLeft(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
                .setPaddingTop(0)
                .setMargin(0)     // Remove margin outside the cell
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
				.add("PaySlip For the Month of October 2024")
				.setFontSize(10)
                .setMultipliedLeading(1)  // Multiplier for default line spacing
                .setFixedLeading(7) // Set fixed line spacing

				.setFont(arialBold)
				.setBold()
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);
		document.add(details);
		float columnWidth1[] = {60,150,70,120};
		Table custinfo = new Table(columnWidth1)
				.setBorder(Border.NO_BORDER)
				.setFixedPosition(60, 595, 400) // Position text next to the logo
				.setWidth(500); // Set the total width of the table (in units, typically points)


		custinfo.addCell(new Cell().add("Employee ID")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("SOC02043")
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Department")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("IT")
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Employee Name")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("K Praneeth")
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Date Of joining")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("05/04/2024")
				.setFontSize(10)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Designation")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Digital Marketing Executive")
				.setFontSize(10)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));

		custinfo.addCell(new Cell().add("Bank Name")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Federal Bank")
				.setFontSize(10)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("Total Days")
				.setFontColor(Color.BLACK)
				.setFontSize(10)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFont(arialBold)
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("31")
				.setFontSize(9)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("Bank A/c No")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBold()
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("77770119827067")
				.setFontSize(9)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));



		custinfo.addCell(new Cell().add("Lop Days")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("0")
				.setFontSize(9)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER));


		custinfo.addCell(new Cell().add("UAN No")
				.setFontColor(Color.BLACK)
				.setFontSize(9)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("101994812607")
				.setFontSize(9)
				.setFont(arialBold)
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
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
			String imagePath = "soclogo.png"; // Replace with your image path
			ImageData logoData = ImageDataFactory.create(imagePath);
			Image logo = new Image(logoData)
					.scaleToFit(150, 100); // Scale logo to fit the header
			logo.setFixedPosition(50, 770); // Position the logo in the header
			document.add(logo);
		} catch (Exception e) {
			System.out.println("Error loading logo: " + e.getMessage());
		}
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);

		// Add the company name next to the logo
		Paragraph companyName = new Paragraph("\n\n\n\nSoc Software Private Limited")
				.setFont(arialBold)
                .setMultipliedLeading(1)  // Multiplier for default line spacing
                .setFixedLeading(10) // Set fixed line spacing
				.setFontSize(26)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);
//				.setFixedPosition(173, 673,400); // Position text next to the logo
		document.add(companyName);

		Paragraph companyAddress = new Paragraph("Plot no.101,R Square Building,Kukatpally,Hyderabad-500072.")
				.setFont(arialBold)
                .setMultipliedLeading(1)  // Multiplier for default line spacing
                .setFixedLeading(7) // Set fixed line spacing
				.setFontSize(11)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);
//				.setFixedPosition(218, 769, 400); // Position text next to the logo
		document.add(companyAddress);

		// Create an email link
		// Email link
		String email = "mailto:Info@socsoftware.in";
		String linkText = "Info@socsoftware.in";

        // Create a paragraph with normal text
        Paragraph paragraph = new Paragraph("Email:");

        // Create the email link text
        Text emailText = new Text(linkText)
                .setFontColor(Color.BLUE)
                .setUnderline();

        // Add an action to the email text
        emailText.setAction(PdfAction.createURI(email));

        // Add both normal text and styled email text to the paragraph
        paragraph.add(emailText);
        paragraph.add("|| ph:040-23354336")
		.setFont(arialBold)
        .setMultipliedLeading(1)  // Multiplier for default line spacing
        .setFixedLeading(7) // Set fixed line spacing
		.setFontSize(11)
		.setFontColor(new DeviceRgb(0, 0, 0))
		.setTextAlignment(TextAlignment.CENTER);


        document.add(paragraph);
		// Add a horizontal line on the first page using PdfCanvas
		float xStart = 36; // starting x position
		float yStart = 700; // starting y position
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
