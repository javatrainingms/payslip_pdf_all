package com.pdf.generate;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class GeneratePDF {

	public static void main(String[] args) throws Exception {
		String imagePath = "logo.png"; 
		String path="innvoice.pdf";
		PdfWriter pdfWriter=new PdfWriter(path);
		PdfDocument pdfDocument=new PdfDocument(pdfWriter);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		Document document=new Document(pdfDocument);
		String imgSrc = "Images\\logo.png";
		ImageData data = ImageDataFactory.create(imgSrc);
		Image image1 = new Image(data);
		image1.scaleAbsolute(78,44);


//		float col = 400f;
		float columnWidth[] = {461f,78f};
		Table table3 = new Table(columnWidth);
		table3.setFontColor(Color.BLACK);


		table3.addCell(new Cell().add(image1)
				.setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.TOP)
				.setMarginBottom(15)
				.setBorder(Border.NO_BORDER)
				);

		table3.addCell(new Cell().add("Tatva Software Services Private Limited \n"
				+ "Tower B, Brigade Tech Park, Pattandur Agrahara, Whitefield,\n"
				+ "Bengaluru, Karnataka-560066,||Email: Hr@tatvasoftwareservices.com"
				)
				.setFontSize(15f)
				.setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.TOP)
				.setMarginBottom(15)
				.setBorder(Border.NO_BORDER)
				);
		

		document.add(table3);


		document.close();

	}

}
