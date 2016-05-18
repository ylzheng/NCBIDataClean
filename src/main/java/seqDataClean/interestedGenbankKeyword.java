package seqDataClean;

/**
 * Created by yqb7 on 5/17/16.
 */
/*public class interestedGenbankKeyword {
    public static Map<String, String> interestedKeyWord = new HashMap<String, String>();
    public static Map<String, Integer> intereKeyWordIndex = new HashMap<String, Integer>();
    static{
        interestedKeyWord.put("LOCUS", "locus"); //0
        //interestedKeyWord.put("DEFINITION", "definition"); //1
        //interestedKeyWord.put("ACCESSION", "accession");//2
        //interestedKeyWord.put("VERSION", "version");//3
        interestedKeyWord.put("GI", "giNumber");//4
        //interestedKeyWord.put("KEYWORDS", "keyWords");//5
        interestedKeyWord.put("SOURCE", "sourceOrganism");//6
        //interestedKeyWord.put("ORGANISM", "organism");//7
        //interestedKeyWord.put("REFERENCE", "reference");//8
        //interestedKeyWord.put("AUTHORS", "authors");//9
        //interestedKeyWord.put("TITLE", "title");//10
        interestedKeyWord.put("JOURNAL", "journal");//11
        //interestedKeyWord.put("COMMENT", "comment");//12
        //interestedKeyWord.put("FEATURES", "feature");//13
        //interestedKeyWord.put("source", "sourceFeature");//14
        //interestedKeyWord.put("ORIGIN", "originSequence");//15
        //interestedKeyWord.put("NULLValue", "nullValue");//16
    }
    static{
        intereKeyWordIndex.put("LOCUS", 0); //0
        //intereKeyWordIndex.put("DEFINITION", 1); //1
        //intereKeyWordIndex.put("ACCESSION", 2);//2
        //intereKeyWordIndex.put("VERSION", 3);//3
        intereKeyWordIndex.put("GI", 4);//4
        //intereKeyWordIndex.put("KEYWORDS", 5);//5
        intereKeyWordIndex.put("SOURCE", 6);//6
        //intereKeyWordIndex.put("ORGANISM", 7);//7
        //intereKeyWordIndex.put("REFERENCE", 8);//8
        //intereKeyWordIndex.put("AUTHORS", 9);//9
        //intereKeyWordIndex.put("TITLE", 10);//10
        intereKeyWordIndex.put("JOURNAL", 11);//11
        //intereKeyWordIndex.put("COMMENT", 12);//12
        //intereKeyWordIndex.put("FEATURES", 13);//13
        //intereKeyWordIndex.put("source", 14);//14
        //intereKeyWordIndex.put("ORIGIN", 15);//15
        //intereKeyWordIndex.put("NULLValue", 16);//16
    }


    public static String findKeyWord(String firstLineWord){
        for(Map.Entry<String, String> entry : interestedKeyWord.entrySet()){
            if(firstLineWord.equals(entry.getKey())){
                //System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        *//*intereKeyWordIndex.forEach((k,v) ->{
            //System.out.println("Item: " + k + " count " + v);
            if(firstLineWord.equals(k)){
                return v;
            }
        });*//*
        return "nullValue";
    }

    public static Integer findKeyWordIndex(String firstLineWord){
        for(Map.Entry<String, Integer> entry : intereKeyWordIndex.entrySet()){
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
}*/
