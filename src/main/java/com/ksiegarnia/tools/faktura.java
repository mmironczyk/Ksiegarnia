package com.ksiegarnia.tools;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class faktura {

    public static void main(String[] args) throws IOException {
        //Creating PDF document object
        PDDocument doc = new PDDocument();

        for (int i=0; i<5; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            doc.addPage( blankPage );
        }

        PDPage page = doc.getPage(0);
        PDImageXObject pdImage = PDImageXObject.createFromFile("C:/xampp/htdocs/Projekt2/Ksiegarnia/src/main/webapp/images/logo.PNG",doc);
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        contents.drawImage(pdImage, 5, 550);
        contents.close();

        //Saving the document
        doc.save("C:/Users/Xrahex/Desktop/faktura.pdf");

        System.out.println("PDF created");

        //Closing the document
        doc.close();
    }
}
