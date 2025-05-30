package org.example.Kafka;

import java.util.Properties;

public class KafkaSSLConfig {
    public static Properties getProps()
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "80.85.250.67:9091");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config",
                "org.apache.kafka.common.security.plain.PlainLoginModule required " +
                        "username=\"adminkafka\" password=\"39QCgYrPLU\";");

        props.put("ssl.truststore.location", "C:/Certificates/keystore_reg.pfx");
        props.put("ssl.truststore.password", "Q1w2e3r4");
        props.put("ssl.truststore.type", "PKCS12");

        props.put("ssl.keystore.location", "C:/Certificates/keystore_reg.pfx");
        props.put("ssl.keystore.password", "Q1w2e3r4");
        props.put("ssl.keystore.type", "PKCS12");

        return props;
    }
}