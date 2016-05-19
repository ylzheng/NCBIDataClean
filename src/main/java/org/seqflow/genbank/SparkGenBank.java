package org.seqflow.genbank;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

/**
 * Created by ylzheng on 5/19/16.
 */
public class SparkGenBank {
  public static void main(String[] args) {
    // Step 1: Create a Java Spark Context
    SparkConf conf = new SparkConf().setAppName("Spark-Genbank Example").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);
    SQLContext sqlContext = new SQLContext(sc);

    // Step 2: Load genbank XML input to Spark DataFrame
    DataFrame df = sqlContext.read()
        .format("com.databricks.spark.xml")
        .option("rowTag", "TSeq")
        .load("src/main/resources/genbank.fasta.xml");

    // Step 3: Write extracted information to xml output file
    df.select("TSeq_gi", "TSeq_sequence").write()
        .format("com.databricks.spark.xml")
        .option("rootTag", "TSeqSet")
        .option("rowTag", "TSeq")
        .save("newGenbank.xml");
  }
}
