package findTextInPDFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDFTextFinder {

    public static Map<String, Boolean> findTextInPDFDocument(String path, List<String> searchWords) throws IOException {
        Map<String, Boolean> results = new HashMap<String, Boolean>();
        File inputFile = new File(path);
        PDDocument pdfFile = PDDocument.load(inputFile);
        PDFTextStripper stripper = new PDFTextStripper();

        String insidePdf = stripper.getText(pdfFile);
        pdfFile.close();

        boolean isThere = false;
        for (int i = 0; i < searchWords.size(); i++) {
            if (insidePdf.contains(searchWords.get(i))) {
                isThere = true;

                results.put(searchWords.get(i), isThere);
            } else {
                isThere = false;
                results.put(searchWords.get(i), isThere);
            }
        }
        //System.out.println(results);
        return results;
    }
}