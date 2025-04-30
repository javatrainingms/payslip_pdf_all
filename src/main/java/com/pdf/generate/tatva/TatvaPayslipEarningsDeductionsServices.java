package com.pdf.generate.tatva;

import java.io.IOException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class TatvaPayslipEarningsDeductionsServices
{
	static String fontPath = "fonts/CALIBRI.TTF"; // Path to Arial Bold font file

	public static Cell addCellKey(String data,int flag) throws IOException
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);
		Cell cell=new Cell().add(data)
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingLeft(10)    // Remove padding inside the cell
				.setPaddingBottom(0)
				.setPaddingTop(0)
				.setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
				.setTextAlignment(TextAlignment.LEFT)
				.setBold().setBackgroundColor(Color.WHITE);	
		if(flag==0)
		{
			cell.setBorderRight(Border.NO_BORDER)
			.setBorderBottom(Border.NO_BORDER)
			.setBorderTop(Border.NO_BORDER);
		}
		else
		{
			cell.setBorderRight(Border.NO_BORDER);
		}

		return cell;
	}
	
	
	
	
	public static Cell addCellValue(String data,int flag) throws IOException
	{
		PdfFont arialBold = PdfFontFactory.createFont(fontPath, "WinAnsi", true);

		Cell cell=new Cell().add(data)
				.setFontSize(10)
				.setFont(arialBold)
				.setPaddingRight(5)    // Remove padding inside the cell
				.setPaddingBottom(0)
				.setPaddingTop(0)
				.setMargin(0)     // Remove margin outside the cell
				.setFontColor(Color.BLACK)
						.setTextAlignment(TextAlignment.RIGHT)
				.setBold().setBackgroundColor(Color.WHITE);

		if(flag==0)
		{
			cell.setBorderLeft(Border.NO_BORDER)
			.setBorderBottom(Border.NO_BORDER)
			.setBorderTop(Border.NO_BORDER);

		}
		else
		{
			cell.setBorderLeft(Border.NO_BORDER);
		}
		return cell;
	}

}