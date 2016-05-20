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

    // Step 2.1: Load GenBank TinySeq XML input to Spark DataFrame
    DataFrame dfTinySeq = sqlContext.read()
        .format("com.databricks.spark.xml")
        .option("rowTag", "TSeq")
        .load("src/main/resources/genbank.fasta.xml");

    dfTinySeq.printSchema();

    // Step 2.2: Load GenBank XML input to Spark DataFrame
    DataFrame dfXML = sqlContext.read()
        .format("com.databricks.spark.xml")
        .option("rowTag", "Seq-entry")
        .load("src/main/resources/genbank.xml");

    dfXML.printSchema();

    // Step 2.3: Load GenBank XML input to Spark DataFrame
    DataFrame dfINSDSeq = sqlContext.read()
        .format("com.databricks.spark.xml")
        .option("rowTag", "INSDSeq")
        .load("src/main/resources/genbank.gbc.xml");

    dfINSDSeq.printSchema();


    // Step 3: Write the selected entries from TinySeq data source to XML output file
    dfTinySeq.select("TSeq_gi", "TSeq_sequence").write()
        .format("com.databricks.spark.xml")
        .option("rootTag", "TSeqSet")
        .option("rowTag", "TSeq")
        .save("newGenbank.xml");
  }
}
