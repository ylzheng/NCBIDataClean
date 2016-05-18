package seqDataClean;

import java.io.File;
import java.io.IOException;

/**
 * Created by yqb7 on 5/16/16.
 */

/**This class is used to process multiple files in the same time, because the gb file is
 * too big so divide it into small parts*/
public class maintoRunMultipleFiles {
    maintoRunMultipleFiles(String inputDirectory, String outputFile) throws IOException {
        File inputDir = new File(inputDirectory);
        File[] inputFiles = inputDir.listFiles();
        /*for(int i = 0; i < inputFiles.length; i++){
            if(inputFiles[i].getPath().contains(".gb")){
                System.out.println(inputFiles[i].getName());
                String fileName = inputFiles[i].getPath();
                String[] fileNameNoGB = inputFiles[i].getName().split("\\.");
                seqDataClean obect = new seqDataClean(fileName, outputFile + "_" + fileNameNoGB[0]);
                System.out.println("finish one file");
            }
        }*/
        for(File eachFile : inputFiles){
            if(eachFile.getPath().contains(".gb")){
                System.out.println(eachFile.getName());
                String fileName = eachFile.getPath();
                String[] fileNameNoGB = eachFile.getName().split("\\.");
                seqDataClean obect = new seqDataClean(fileName, outputFile + "_" + fileNameNoGB[0]);
                System.out.println("finish one file");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        maintoRunMultipleFiles ob = new maintoRunMultipleFiles(args[0], args[1]) ;
    }
}
