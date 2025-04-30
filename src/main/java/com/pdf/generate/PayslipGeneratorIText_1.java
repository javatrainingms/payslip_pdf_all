package com.pdf.generate;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class PayslipGeneratorIText_1 {
    public static void main(String[] args) {
        String filePath = "Payslip-Nikhileswari.pdf";

        try {
            // Create PDF document
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            document.setMargins(20, 20, 20, 20);

            // Add Header Section
            addHeader(document);

            // Add Employee Details
            addEmployeeDetails(document);

            // Add Earnings and Deductions
            addEarningsAndDeductions(document);

            // Add Footer
            addFooter(document);

            // Close document
            document.close();
            System.out.println("Payslip generated successfully at " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void addHeader(Document document) {
        PdfDocument pdfDoc = document.getPdfDocument();

        // Create a rectangle for the header background
        Rectangle headerRect = new Rectangle(0, 780, pdfDoc.getDefaultPageSize().getWidth(), 50);
        Color headerBackground = new DeviceRgb(220, 220, 220); // Light gray

        // Use PdfCanvas to draw the rectangle
        PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getFirstPage());
        pdfCanvas.setFillColor(headerBackground)
                .rectangle(headerRect)
                .fill();

        // Add an image (Company Logo)
        try {
            String imagePath = "logo.png"; // Replace with your image path
            ImageData logoData = ImageDataFactory.create(imagePath);
            Image logo = new Image(logoData).scaleToFit(40, 40); // Scale logo to fit the header
            logo.setFixedPosition(20, 785); // Position the logo in the header
            document.add(logo);
        } catch (Exception e) {
            System.out.println("Error loading logo: " + e.getMessage());
        }

        // Add the company name next to the logo
        Paragraph companyName = new Paragraph("Tatva Software Services Private Limited")
                .setFontSize(14)
                .setBold()
                .setTextAlignment(TextAlignment.LEFT)
                .setFixedPosition(70, 790, 400); // Position text next to the logo
        document.add(companyName);
    }


//    private static void addHeader(Document document) {
//        // Set up the header background
//        float width = document.getPdfDocument().getDefaultPageSize().getWidth();
//        Rectangle rect = new Rectangle(0, 780, width, 50);
////        Color headerBackground = new DeviceRgb(220, 220, 220); // Light Gray
////        document.add(new Rectangle(rect));
//
//        // Add an image (Company Logo)
//        try {
//            String imagePath = "Images/logo.png"; // Replace with your image path
//            ImageData logoData = ImageDataFactory.create(imagePath);
//            Image logo = new Image(logoData).scaleToFit(40, 40); // Scale logo to fit the header
//            logo.setFixedPosition(20, 785); // Position the logo in the header
//            document.add(logo);
//        } catch (Exception e) {
//            System.out.println("Error loading logo: " + e.getMessage());
//        }
//
//        // Add the company name next to the logo
//        Paragraph companyName = new Paragraph("Tatva Software Services Private Limited")
//                .setFontSize(14)
//                .setBold()
//                .setTextAlignment(TextAlignment.LEFT)
//                .setFixedPosition(70, 790, 400); // Position text next to the logo
//        document.add(companyName);
//
//        // Add a dividing line below the header
//        LineSeparator line = new LineSeparator(new SolidLine());
//        line.setWidth(width - 40);
//        line.setMarginTop(5);
//        document.add(line);
//    }


//    private static void addHeader(Document document) {
//        // Add a rectangle background for header
//        float width = document.getPdfDocument().getDefaultPageSize().getWidth();
//        Rectangle rect = new Rectangle(0, 780, width, 50);
////        Color headerBackground = new DeviceRgb(220, 220, 220); // Light Gray
////        document.add(new Rectangle(rect));
//
//        // Add header text
//        Paragraph header = new Paragraph("PaySlip - October 2024")
//                .setFontSize(18)
//                .setBold()
//                .setTextAlignment(TextAlignment.CENTER)
//                .setMarginTop(-40);
//        document.add(header);
//
//        // Add a dividing line below the header
//        LineSeparator line = new LineSeparator(new SolidLine());
//        line.setWidth(width - 40);
//        line.setMarginTop(10);
//        document.add(line);
//    }

    private static void addEmployeeDetails(Document document) {
        Paragraph details = new Paragraph()
                .add("Employee No: TAT2502     Emp Name: D Nikileswari\n")
                .add("Date of Joining: 23/07/2024     Designation: Software Engineer\n")
                .add("Gender: Female     Bank Acc. No: 159676592606\n")
                .add("PAN No: BWBPN4094D     Bank Name: INDUSIND\n")
                .add("LOP: 0.00     Salary Paid: 45732\n")
                .add("Total Days: 31.00     UAN No: 102114836153\n")
                .setFontSize(12)
                .setMarginTop(20);
        document.add(details);
    }

    private static void addEarningsAndDeductions(Document document) {
        // Earnings and Deductions Section Title
        Paragraph sectionTitle = new Paragraph("Earnings                          Deductions")
                .setBold()
                .setMarginTop(20)
                .setMarginBottom(10);
        document.add(sectionTitle);

        // Earnings and Deductions Details
        Table table = new Table(4);
        table.setWidthPercent(100);

        // Add Table Headers
        table.addCell(new Cell().add("Earnings").setBold().setBackgroundColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add("").setBackgroundColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add("Deductions").setBold().setBackgroundColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add("").setBackgroundColor(Color.LIGHT_GRAY));

        // Add Rows
        table.addCell("BASIC");
        table.addCell("12433");
        table.addCell("PROFESSIONAL TAX");
        table.addCell("200");

        table.addCell("HOUSE RENT ALLOWANCE");
        table.addCell("3430");
        table.addCell("PROVIDENT FUND");
        table.addCell("1800");

        table.addCell("MEDICAL ALLOWANCE");
        table.addCell("1250");
        table.addCell("");
        table.addCell("");

        table.addCell("SPECIAL ALLOWANCE");
        table.addCell("7753");
        table.addCell("");
        table.addCell("");

        table.addCell("SALARY ARREAR");
        table.addCell("22866");
        table.addCell("");
        table.addCell("");

        document.add(table);

        // Totals
        Paragraph totals = new Paragraph("Total Earnings: Rs 47732     Total Deductions: Rs 2000\n")
                .add("Net Amount: 45732\n")
                .add("Net Pay in Words: Forty Five Thousand Seven Hundred Thirty Two Rupees Only")
                .setFontSize(12)
                .setMarginTop(10);
        document.add(totals);
    }

    private static void addFooter(Document document) {
        Paragraph footer = new Paragraph()
                .add("This is a computer-generated payslip. Signature not required.\n")
                .add("Tatva Software Services Private Limited\n")
                .add("Tower B, Brigade Tech Park, Pattandur Agrahara, Whitefield,\n")
                .add("Bengaluru, Karnataka-560066, Email: Hr@tatvasoftwareservices.com")
                .setFontSize(10)
                .setMarginTop(30)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(footer);
    }
}
