package de.edatasystems.sparkloadtest.controller;

import de.edatasystems.sparkloadtest.domain.SparkTestData;
import de.edatasystems.sparkloadtest.rest.ISparkController;
import de.edatasystems.sparkloadtest.writer.SparkWriter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SparkController implements ISparkController {

    @Override
    public void provokeException(long listSize, long amountOfLists) {

        List<List<SparkTestData>> testDataList = new LinkedList<>();

        for (long i = 0; i < amountOfLists; i++) {
            List<SparkTestData> sparkTestDataList = new LinkedList<>();
            for (long j = 0; j < listSize; j++) {
                sparkTestDataList
                        .add(new SparkTestData(i, "name_" + j, "datalist_" + i + ". Entry: " + j, i));
            }
            testDataList.add(sparkTestDataList);
        }

        for (List<SparkTestData> sparkTestDataList : testDataList) {
            new Thread(new SparkWriter(sparkTestDataList)).start();
        }
    }
}

