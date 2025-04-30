package com.pdf.generate;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class PdfWithTable {
    public static void main(String[] args) {
        try {
            // Create a PdfDocument
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter("table_example.pdf"));
            Document document = new Document(pdfDoc);

            // Create a table with 3 columns
            float[] columnWidths = {1, 200, 3}; // Define the column widths (relative)
            Table table = new Table(columnWidths);

            // Add header cells
            table.addCell(new Cell().add("Header 1").setTextAlignment(TextAlignment.CENTER).setBold());
            table.addCell(new Cell().add("Header 2").setTextAlignment(TextAlignment.CENTER).setBold());
            table.addCell(new Cell().add("Header 3").setTextAlignment(TextAlignment.CENTER).setBold());

            // Add data rows
            table.addCell("Data 1");
            table.addCell("Data 2");
            table.addCell("Data 3");

            table.addCell("Data 4");
            table.addCell("Data 5");
            table.addCell("Data 6");

            table.addCell("Data 7");
            table.addCell("Data 8");
            table.addCell("Data 9");

            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();

            System.out.println("PDF with table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
