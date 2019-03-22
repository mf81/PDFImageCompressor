package eu.maciejfijalkowski;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
        public static void main(String[] args) throws Exception {
            PdfReader reader = new PdfReader("dummy.pdf");
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("my-dummy.pdf"), PdfWriter.VERSION_1_5);
            stamper.setFullCompression();
            stamper.close();

            reader = new PdfReader("dummy.pdf");
            stamper = new PdfStamper(reader, new FileOutputStream("myDecompressed-dummy.pdf"), '1');
            Document.compress = false;
            int total = reader.getNumberOfPages() + 1;
            for (int i = 1; i < total; i++) {
                reader.setPageContent(i, reader.getPageContent(i));
            }
            stamper.close();

            showFileSize("dummy.pdf");
            showFileSize("my-dummy.pdf");
            showFileSize("myDecompressed-dummy.pdf");

        }

        private static void showFileSize(String filename) throws IOException {
            PdfReader reader = new PdfReader(filename);
            System.out.print("Size ");
            System.out.print(filename);
            System.out.print(": ");
            System.out.println(reader.getFileLength());
        }
}

