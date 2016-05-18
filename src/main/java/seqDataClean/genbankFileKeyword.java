package seqDataClean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yqb7 on 5/9/16.
 */
public class genbankFileKeyword {
    public static Map<String, String> genbankFileKeyword = new HashMap<String, String>();
    public static Map<String, Integer> gbFileKeywordIndex = new HashMap<String, Integer>();
    public genbankFileKeyword(){
        genbankFileKeyword.put("LOCUS", "locus"); //0
        genbankFileKeyword.put("DEFINITION", "definition"); //1
        genbankFileKeyword.put("ACCESSION", "accession");//2
        genbankFileKeyword.put("VERSION", "version");//3
        genbankFileKeyword.put("GI", "giNumber");//4
        genbankFileKeyword.put("KEYWORDS", "keyWords");//5
        genbankFileKeyword.put("SOURCE", "sourceOrganism");//6
        genbankFileKeyword.put("ORGANISM", "organism");//7
        genbankFileKeyword.put("REFERENCE", "reference");//8
        genbankFileKeyword.put("AUTHORS", "authors");//9
        genbankFileKeyword.put("TITLE", "title");//10
        genbankFileKeyword.put("JOURNAL", "journal");//11
        genbankFileKeyword.put("COMMENT", "comment");//12
        genbankFileKeyword.put("FEATURES", "feature");//13
        genbankFileKeyword.put("source", "sourceFeature");//14
        genbankFileKeyword.put("ORIGIN", "originSequence");//15
        genbankFileKeyword.put("NULLValue", "nullValue");//16
    }
    static{
        gbFileKeywordIndex.put("LOCUS", 0); //0
        gbFileKeywordIndex.put("DEFINITION", 1); //1
        gbFileKeywordIndex.put("ACCESSION", 2);//2
        gbFileKeywordIndex.put("VERSION", 3);//3
        gbFileKeywordIndex.put("GI", 4);//4
        gbFileKeywordIndex.put("KEYWORDS", 5);//5
        gbFileKeywordIndex.put("SOURCE", 6);//6
        gbFileKeywordIndex.put("ORGANISM", 7);//7
        gbFileKeywordIndex.put("REFERENCE", 8);//8
        gbFileKeywordIndex.put("AUTHORS", 9);//9
        gbFileKeywordIndex.put("TITLE", 10);//10
        gbFileKeywordIndex.put("JOURNAL", 11);//11
        gbFileKeywordIndex.put("COMMENT", 12);//12
        gbFileKeywordIndex.put("FEATURES", 13);//13
        gbFileKeywordIndex.put("source", 14);//14
        gbFileKeywordIndex.put("ORIGIN", 15);//15
        gbFileKeywordIndex.put("NULLValue", 16);//16
    }


    public static String findKeyWord(String firstLineWord){
        for(Map.Entry<String, String> entry : genbankFileKeyword.entrySet()){
            if(firstLineWord.equals(entry.getKey())){
                //System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        /*gbFileKeywordIndex.forEach((k,v) ->{
            //System.out.println("Item: " + k + " count " + v);
            if(firstLineWord.equals(k)){
                return v;
            }
        });*/
        return "nullValue";
    }

    public static Integer findKeyWordIndex(String firstLineWord){
        for(Map.Entry<String, Integer> entry : gbFileKeywordIndex.entrySet()){
            if(firstLineWord.equals(entry.getKey())){
                //System.out.println(entry.getKey());
                return entry.getValue();
            }
        }
        return -2;
    }

    public int checkRepeatedKeyWord(String[] elementHolder, String keyWord){
        for (int i = 0; i < elementHolder.length; i ++){
            String[] allElement = elementHolder[i].split(" ");
            if (allElement[0].equals(keyWord)){
                //System.out.println("found not -1");
                return i;
            }


        }
        return -1;
    }

}
