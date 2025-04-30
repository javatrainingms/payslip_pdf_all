package com.pdf.generate.tatva;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class TatvaPayslipHeaderFooterServices
{
	static String fontPath = "fonts/Arial.ttf"; // Path to Arial Bold font file
	
	public static Paragraph headerParagraph(String name,int fontsize) throws Exception
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Paragraph paragraph = new Paragraph(name)
				.setFont(arialBold)
				.setFontSize(fontsize)
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setBold()
				.setTextAlignment(TextAlignment.LEFT);

		return paragraph;
	}
	
	public static Paragraph headerEmail(String linkText, int fontsize)throws Exception
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		String email = "mailto:"+linkText;

		// Create a paragraph with normal text
		Paragraph paragraph = new Paragraph("Bengaluru, Karnataka-560066||Email:");

		// Create the email link text
		Text emailText = new Text(linkText)
				.setFontColor(Color.BLUE)
				.setUnderline();

		// Add an action to the email text
		emailText.setAction(PdfAction.createURI(email));

		// Add both normal text and styled email text to the paragraph
		paragraph.add(emailText)
		.setFont(arialBold)
		.setFontSize(fontsize)
		.setFontColor(new DeviceRgb(0, 0, 0))
		.setTextAlignment(TextAlignment.LEFT);
		
		
		return paragraph;

	}
	
	public static Image logo()throws Exception
	{
		String imagePath = "tatvalogo.png";
		ImageData logoData = ImageDataFactory.create(imagePath);
		Image logo = new Image(logoData).scaleToFit(78, 44); // Scale logo to fit the header
		return logo;

	}
	public static Paragraph footerParagraph(String name,int fontsize) throws Exception
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Paragraph footer = new Paragraph()
				.add(name)
				.setFont(arialBold)
				.setFontColor(Color.BLACK)
				.setFontSize(fontsize)
				.setMarginTop(30)
				.setTextAlignment(TextAlignment.LEFT);
		return footer;
	}
	
}