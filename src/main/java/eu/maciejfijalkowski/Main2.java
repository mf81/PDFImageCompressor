package eu.maciejfijalkowski;

import java.io.IOException;
import com.itextpdf.text.DocumentException;

public class Main2 {
    public static void main(String[] args) throws IOException, DocumentException {

        PDFImageCompressor.manipulatePdf("dummy.pdf", "image-compress-dummy.pdf");

    }
}




