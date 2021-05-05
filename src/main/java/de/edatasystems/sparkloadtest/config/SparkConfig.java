package de.edatasystems.sparkloadtest.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${spark.master:local[4]}")
    private String masterUri;

    @Value("${spark.enabled:false}")
    private String sparkEnabled;

    @Value("${spark.home:./}")
    private String sparkHome;

    @Value("${spark.driver.bindAddress:127.0.0.1}")
    private String sparkBindingAddress;

    @Value("${spark.driver.host:127.0.0.1}")
    private String sparkHost;

    @Bean(name = "spark_conf")
    public SparkConf conf() {
        return new SparkConf()
                .setAppName(appName)
                .setMaster(masterUri)
                .setSparkHome(sparkHome)
                .set("spark.driver.bindAddress",sparkBindingAddress)
                .set("spark.driver.host", sparkHost)
                .set("spark.driver.extraJavaOptions", "-Duser.timezone=Europe/Berlin")
                .set("spark.executor.extraJavaOptions", "-Duser.timezone=Europe/Berlin");
    }

    @Bean(name = "spark_sc")
    public JavaSparkContext sc() {
        if (sparkEnabled.equalsIgnoreCase("true")) {
            return new JavaSparkContext(conf());
        } else {
            return null;
        }
    }


}
