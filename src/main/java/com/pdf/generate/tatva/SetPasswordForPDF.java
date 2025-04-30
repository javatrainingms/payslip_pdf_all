package com.pdf.generate.tatva;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.WriterProperties;

public class SetPasswordForPDF {
    public static void passwordProtected(String nonprotectedPath,String ProtectedPath,String userPassword,String ownerPassword) {
        // Path to the original PDF
        String src = nonprotectedPath;
        // Path to the output PDF
        String dest = ProtectedPath;
        // User password (to open the PDF)
//        String userPassword = "user123";
        // Owner password (to change permissions)
//        String ownerPassword = "owner123";

        try {
            // Open the original PDF
            PdfReader reader = new PdfReader(src);
            // Set writer properties for encryption
            WriterProperties writerProperties = new WriterProperties()
                    .setStandardEncryption(
                            userPassword.getBytes(),
                            ownerPassword.getBytes(),
                            EncryptionConstants.ALLOW_PRINTING,
                            EncryptionConstants.ENCRYPTION_AES_256);

            // Create a PdfDocument with encryption
            PdfDocument pdfDoc = new PdfDocument(reader, new PdfWriter(dest, writerProperties));

            // Close the document
            pdfDoc.close();

            System.out.println("PDF password-protected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
