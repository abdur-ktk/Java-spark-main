package de.edatasystems.sparkloadtest.domain;

import lombok.Data;

@Data
public class SparkTestData {
    private Long id;
    private String name;
    private String description;
    private Long group;

    public SparkTestData(Long id, String name, String description, Long group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.group = group;
    }
}
