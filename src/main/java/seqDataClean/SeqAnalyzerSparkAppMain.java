package seqDataClean;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;

/**
 * Created by yqb7 on 5/17/16.
 */
public class SeqAnalyzerSparkAppMain {




    public static void main(String args) throws IOException{
        SparkConf conf = new SparkConf().setAppName("NCBI data analysis");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> content = sc.textFile("/scicomp/home/yqb7/LPRB/ncbi_meningitis_encephalitis" +
                "/sequence_encephalitis_15571/tmp/" +
                "sequence_encephalitis_15571_part2_L7058880_part2_995323.gb").cache();



                /*SparkConf conf = new SparkConf().setAppName("seqCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> input = sc.textFile("/scicomp/home/yqb7/" +
                "allData/hepatitis/kstep/small_test/HOC_P02_1b.fas").cache();
        JavaRDD<String> words = input.flatMap(
                new FlatMapFunction<String, String>() {
                    public Iterable<String> call(String x) throws Exception {
                        return Arrays.asList(x.split("\n"));
                    }});


        *//*SeqCollections_spark(String fasFileDir, String distanceVectorDir) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get(fasFileDir)));
            BufferedReader reader2 = new BufferedReader(new FileReader(new File(distanceVectorDir)));

        }*//**/
    }

}
