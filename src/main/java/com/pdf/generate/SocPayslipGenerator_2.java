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
import com.itextpdf.layout.element.Link;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class SocPayslipGenerator_2 {
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

			addHeader(document, pdfDoc);

			// Close Document
			document.close();

			System.out.println("Payslip generated successfully at " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	private static void addHeader(Document document, PdfDocument pdfDoc) throws Exception {
		
		Image logo = SocPayslipHeaderServices.logo(); // Position the logo in the header
		document.add(logo);

		Paragraph companyName = SocPayslipHeaderServices.headerParagraph("\n\n\n\nSoc Software Private Limited",10,26);
		document.add(companyName);

		Paragraph companyAddress = SocPayslipHeaderServices.headerParagraph("Plot no.101,R Square Building,Kukatpally,Hyderabad-500072.",7,11);
		document.add(companyAddress);

		// Email link
		Paragraph companyEmail =SocPayslipHeaderServices.headerEmail();
		document.add(companyEmail);
		
		// draw the line
		SocPayslipHeaderServices.strightline(pdfDoc,36,700);
	}




}


class SocPayslipHeaderServices
{
	static String fontPath = "fonts/CALIBRI.TTF"; // Path to Arial Bold font file
	
	public static void strightline(PdfDocument pdfDoc,int x_start,int y_start)
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
	public static Paragraph headerParagraph(String name,int fixed,int fontsize) throws Exception
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Paragraph paragraph = new Paragraph(name)
				.setFont(arialBold)
				.setMultipliedLeading(1)  // Multiplier for default line spacing
				.setFixedLeading(fixed) // Set fixed line spacing
				.setFontSize(fontsize)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);

		return paragraph;
	}
	
	public static Paragraph headerEmail()throws Exception
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
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
		
		return paragraph;

	}
	
	public static Image logo()throws Exception
	{
		String imagePath = "soclogo.png"; // Replace with your image path
		ImageData logoData = ImageDataFactory.create(imagePath);
		Image logo = new Image(logoData)
				.scaleToFit(150, 100) // Scale logo to fit the header
				.setFixedPosition(50, 770); // Position the logo in the header
		return logo;

	}
	
}