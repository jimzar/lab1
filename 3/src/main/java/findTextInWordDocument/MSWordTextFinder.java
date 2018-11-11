package findTextInWordDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MSWordTextFinder {

    //check the suffix after the last dot it finds
    public static String getFileEnding(File f) {
        int index = f.getName().lastIndexOf(".");
        return f.getName().substring(index + 1);
    }

    public  static Map<String, Boolean> findTextInWordDocument(String path, List<String> searchWord) throws IOException {
        Map<String, Boolean> results = new HashMap<String, Boolean>();
        File myDoc = new File(path);
        FileInputStream importFile = new FileInputStream(myDoc);
        String content = null;

        if (getFileEnding(myDoc).equals("docx")) {
            XWPFDocument docFile = new XWPFDocument(importFile);
            XWPFWordExtractor stripper = new XWPFWordExtractor(docFile);
            content = stripper.getText();
            docFile.close();
        } else if(getFileEnding(myDoc).equals("doc")){
            HWPFDocument docFile = new HWPFDocument(importFile);
            WordExtractor stripper = new WordExtractor(docFile);
            content = stripper.getText();
            docFile.close();
        }
        boolean isThere = false;
        for (int i=0; i<searchWord.size(); i++){
            if (content.contains(searchWord.get(i))){
                isThere = true;

            } else if (!content.contains(searchWord.get(i))){
                isThere = false;

            }
            results.put(searchWord.get(i),isThere);
        }

        return results;
    }

}