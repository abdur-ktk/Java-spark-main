package de.edatasystems.sparkloadtest.writer;

import de.edatasystems.sparkloadtest.domain.SparkTestData;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.*;

import java.util.List;

@Slf4j
public class SparkWriter implements Runnable {

    private final List<SparkTestData> sparkTestDataList;

    public SparkWriter(List<SparkTestData> sparkTestDataList) {
        this.sparkTestDataList = sparkTestDataList;
    }

    @Override
    public void run() {
        writeData();
    }

    private void writeData() {

        SparkSession spark = SparkSession
                .builder()
                .getOrCreate();

        log.info("Spark version: {}", spark.version());

        String outputPathString = "./spark-test";

        Encoder<SparkTestData> sparkTestDataEncoder = Encoders.bean(SparkTestData.class);

        Dataset<SparkTestData> dataset = spark.createDataset(sparkTestDataList, sparkTestDataEncoder);

        log.info("Created dataset {}", dataset);
        dataset.write().mode(SaveMode.Append).option("nullValue", null).partitionBy("group").json(outputPathString);
        log.info("Finished writing data for list");
    }
}

