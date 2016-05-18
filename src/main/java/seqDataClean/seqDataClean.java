package seqDataClean;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by yqb7 on 5/6/16.
 */
public class seqDataClean
{
    /**This class is used to load the genbank file and separate the content to the corresponding parts
     * genbank file is the downloaded file from NCBI, it contains 16 unique keywords and some repeated keyword.
     * content is the loaded genbank file of all
     * contentArray is the variable which is the content separated by \n
     * */

    //ArrayList<genbankfile> genbankfiles = new ArrayList<genbankfile>();
    String[] contentArray;
    genbankFileKeyword filekeyword = new genbankFileKeyword();
    public seqDataClean(String gbFileName, String outputFile) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(gbFileName)));
        seperateContent(content, outputFile);
    }

    public void seperateContent(String content, String outputFile) throws IOException {
        /** elementHolder is a variable to hold the each line element after find the matched keywords*/
        String[] elementHolder = new String[16];
        for(int i = 0; i < 16; i++){
            elementHolder[i] = "";
        }
        contentArray = content.split("LOCUS"); /**Split the file content according to the "LOCUS" to filter the item
         which is only human sequence
         every ncbi item include 16 keywords */
        int currentKeyword = 0;
        int itemCounter = 0;
        for(String oneItem : contentArray){
            itemCounter++;
            if(!oneItem.contains("SOURCE      Homo sapiens (human)") &&
                    !oneItem.contains("Inducing Lamb") && oneItem.length() > 1){
                System.out.println("not contain the words");
                String[] anItemArray = oneItem.split("\n");
                anItemArray[0] = "LOCUS "+ anItemArray[0]; //add "LOCUS" into the line
                for(String aline : anItemArray){
                    if(!aline.contains("//") && aline.length() > 0 ){/**split each line of the item and find its keyword*/
                        String[] lineElement = aline.trim().split(" ");
                        String returnedKeyValue = filekeyword.findKeyWord(lineElement[0]);
                        Integer returnedKeyValueIndex = genbankFileKeyword.findKeyWordIndex(lineElement[0]);

                        if (!returnedKeyValue.equals("nullValue") && returnedKeyValueIndex != -2) {
                            /**Check if the keyword is repeated in the genbank file. if it is repeated , the second keyword
                             * content will be added into the first one */
                            currentKeyword = returnedKeyValueIndex;
                            for (int i = 0; i < lineElement.length; i++) {
                                if(!lineElement[i].equals("")){
                                    elementHolder[returnedKeyValueIndex] = elementHolder[returnedKeyValueIndex] +
                                            lineElement[i].trim() + " ";
                                }
                            }

                        }
                        if(returnedKeyValue.equals("VERSION")){
                            elementHolder[returnedKeyValueIndex + 1]=lineElement[lineElement.length-1];
                        }

                        else if (returnedKeyValue.equals("nullValue")){
                            elementHolder[currentKeyword] = elementHolder[currentKeyword]
                                    + " " + aline.trim();
                        }

                    }
                    if (aline.contains("//") && aline.length() == 2){

                        String cleanSeq = cleanOriginSequence.cleanOriginSequence(elementHolder[15]);
                        genbankfile aGBFile = new genbankfile(elementHolder[0],
                                elementHolder[1], elementHolder[2], elementHolder[3],
                                elementHolder[4], elementHolder[5], elementHolder[6],
                                elementHolder[7], elementHolder[8], elementHolder[9],
                                elementHolder[10], elementHolder[11], elementHolder[12],
                                elementHolder[13], elementHolder[14], cleanSeq);
                        //genbankfiles.add(aGBFile);
                        for(int i = 0; i < 16; i++){
                            elementHolder[i] = "";
                        }


                        //if(!aGBFile.sourceOrganism.replaceAll("\\s+","").contains("SOURCEHomosapiens(human)")){
                        if(!aGBFile.sourceOrganism.contains("SOURCE Homo sapiens (human)")){
                            printOutInterestedInfo(aGBFile, outputFile);
                            System.out.println("itemCounter " + itemCounter + " sourceOtganism " + aGBFile.sourceOrganism
                                    + " GI " + aGBFile.giNumber);
                            System.out.println("not contain");

                        }else{
                            System.out.println("contain");
                        }
                    }
                }
            }
        }

        System.out.println("separate");
    }

    public void printOutInterestedInfo(genbankfile afile, String outFile)
            throws IOException {
        FileWriter outputStream = null;
        outputStream = new FileWriter(outFile, true);
        outputStream.write(afile.locus+"\n" +
                afile.giNumber + "\n" +
                afile.sourceOrganism + "\n" +
                afile.journal + "\n" + "\n");
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        seqDataClean object = new seqDataClean(args[0], args[1]);
    }
}
