import findTextInWordDocument.MSWordTextFinder;
import findTextInPDFDocument.PDFTextFinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFinder {

    public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);
    List<String> mySearches = new ArrayList<String>();
        System.out.println("Set the Keyword for Searching\nGive next Keyword by pressing [ENTER]\nPress [ENTER] TWICE to finish ");
    String word = null;
        while ((word = input.nextLine()).length() > 0) {
        mySearches.add(word);
    }
     //   input.close();

        System.out.println("You Want to Search " + mySearches.size() + " Elements Which are:");
        System.out.println(mySearches);


        Scanner user = new Scanner( System.in );
        String  inputFileName;
        System.out.print("\nType the full File Path along with its suffix: ");
        inputFileName = user.nextLine().trim();
    //    user.close();
        // System.out.println(" File : " + inputFileName);
        File tempFile = new File(inputFileName);

        if ((MSWordTextFinder.getFileEnding(tempFile).equals("docx"))||(MSWordTextFinder.getFileEnding(tempFile).equals("doc"))){
            System.out.println("Results for the desired document file are:");
            System.out.println(MSWordTextFinder.findTextInWordDocument(inputFileName, mySearches));
        } else if (MSWordTextFinder.getFileEnding(tempFile).equals("pdf")) {
            System.out.println("Results for the desired pdf file are:");
            System.out.println(PDFTextFinder.findTextInPDFDocument(inputFileName, mySearches));
        } else {
            System.out.println("Not The desired file-type");
        }


}
}
