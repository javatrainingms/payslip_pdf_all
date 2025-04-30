package com.pdf.generate.soc;

import java.io.IOException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class SocPayslipEmployeeDetailsServices
{
	static String fontPath = "fonts/CALIBRI.TTF"; // Path to Arial Bold font file
	

	public static Paragraph forMonth(String month,String year) throws IOException
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		
		Paragraph details = new Paragraph()
				.add("PaySlip For the Month of "+month+" "+year)
				.setFontSize(10)
                .setMultipliedLeading(1)  // Multiplier for default line spacing
                .setFixedLeading(7) // Set fixed line spacing
				.setFont(arialBold)
				.setBold()
				.setFontColor(new DeviceRgb(0, 0, 0))
				.setTextAlignment(TextAlignment.CENTER);
		
		return details;
	}
	
	public static Cell addCellKey(String data) throws IOException
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Cell cell=new Cell().add(data)
				.setFontColor(Color.BLACK)
				.setFontSize(10)
				.setFont(arialBold)
				.setBold()
                .setPadding(0)    // Remove padding inside the cell
                .setMargin(0)     // Remove margin outside the cell
				.setBorder(Border.NO_BORDER);
		
		return cell;
	}
	
	public static Cell addCellValue(String data) throws IOException
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		
		Cell cell=new Cell().add(data)
				.setFontSize(10)
				.setFont(arialBold)
	            .setPadding(0)    // Remove padding inside the cell
	            .setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setBorder(Border.NO_BORDER);

		
		return cell;
	}
	
}