package com.itgrids.voterdata;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: ralapaty
 * Date: 30/10/2012
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public class ConvertVoterDataFromPdfToText {
    public static void main(String args[]) throws IOException {
        PDDocument pd;
        List<VoterInfo> voterList = new ArrayList<VoterInfo>();
        try {
            //  PDF file from where the voter data is extracted
            File input = new File("/Users/ralapaty/Projects/ITGrids/Adilabad/3-Bellampalle (SC)-79-Bellampally.pdf");

            // StringBuilder to store the extracted text
            StringBuilder sb = new StringBuilder();
            pd = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();

            // Add text to the StringBuilder from the PDF
            sb.append(stripper.getText(pd));

            // Regex. For those who do not know. The Pattern refers to the format you are looking for.
            // In our example, we are looking for voter data
            //Pattern p = Pattern.compile("Age:\\sSex:\\s([a-zA-Z]*)\\n(AJP\\d*|AP\\d*)\\nElector's Name:\\n(Husband's Name:|Father's Name:)\\nHouse No:\\n([A-Z\\s\\n]*)\\n([A-Z\\s]*)\\n([0-9\\-_/]*)\\n([\\s0-9]*)\\n[\\s0-9]*\\n");
            //  Pattern p = Pattern.compile("Age:\\sSex:\\s([a-zA-Z]*)\\n(KLQ\\d*|AJP\\d*|AP\\d*)\\nElector's Name:\\n(Husband's Name:|Father's Name:|Mother's Name:)\\nHouse No:\\n([A-Z\\s\\n]*)\\n([A-Z\\s]*)\\n([0-9\\-_/A-Za-z]*)\\n([\\s0-9]*)\\n[\\s0-9]*\\n");
            Pattern p = Pattern.compile("Age:\\sSex:\\s([a-zA-Z]*)\\n([A-Z\\d]*)\\nElector's Name:\\n(Husband's Name:|Father's Name:|Mother's Name:|Other's Name:)\\nHouse No:\\n([A-Za-z\\.\\s\\n]*)\\n([A-Za-z\\.\\s]*)\\n([0-9\\-_/A-Za-z]*)\\n([\\s0-9]*)\\n([\\s0-9a-zA-Z]*)\\n");
            // Matcher refers to the actual text where the pattern will be found
            Matcher m = p.matcher(sb);
            int i = 0;
            VoterInfo voter = null;
            while (m.find()) {
                voter = new VoterInfo();
                // group() method refers to the next number that follows the pattern we have specified.
                voter.setAge(m.group(7).trim());
                voter.setSex(m.group(1).trim());
                voter.setVoterId(m.group(2).trim());
                voter.setVoterName(m.group(4).trim());
                voter.setGuardianName(m.group(5).trim());
                voter.setGuardianRelation(m.group(3).substring(0, m.group(3).indexOf("'s Name")).trim());
                voter.setHouseNumber(m.group(6).trim());
                System.out.println("Voter Info:" + voter.toString());
                voterList.add(voter);
            }
            System.out.println("Total No of Voters:" + voterList.size());
            if (pd != null) {
                pd.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
