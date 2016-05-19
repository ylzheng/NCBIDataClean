package seqDataClean;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by yqb7 on 5/11/16.
 */
/*This class is used to clean the sequence data under origin in genbank file and was called
* by seqDataClean class*/
public class CleanOriginSequence {
    public static String cleanOriginSequence(String sequence){
        String[] seqArray = sequence.split(" ");
        String cleanSequence = "";
        for(String seqElement: seqArray){
            if(!NumberUtils.isNumber(seqElement) && !seqElement.equals("ORIGIN")){
                cleanSequence = cleanSequence + seqElement.toUpperCase();
            }
        }
        return cleanSequence;
    }
}
