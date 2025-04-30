package com.pdf.generate;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;

import java.io.File;
import java.io.IOException;

public class AddImageToPDF {
    public static void main(String[] args) {
        // Define the path to the image and the output PDF
        String imagePath = "logo.png";  // Replace with your image file path
        String outputPdfPath = "output.pdf";          // Path where you want to save the PDF

        try {
            // Create a PdfWriter and PdfDocument
            PdfWriter writer = new PdfWriter(outputPdfPath);
            PdfDocument pdf = new PdfDocument(writer);

            // Create a Document object to add content
            Document document = new Document(pdf);

            // Load the image
            Image img = new Image(ImageDataFactory.create(imagePath));

            // Add the image to the document
            document.add(img);

            // Close the document (this will write the content to the file)
            document.close();

            System.out.println("PDF created successfully with the image!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating PDF: " + e.getMessage());
        }
    }
}
