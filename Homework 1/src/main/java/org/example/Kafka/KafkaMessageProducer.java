package org.example.Kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class KafkaMessageProducer {
    public static void main(String[] args) {
        Properties props = KafkaSSLConfig.getProps();
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введите сообщение для отправки в Kafka (введите 'exit' для выхода):");

            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Завершение отправки сообщений.");
                    break;
                }

                ProducerRecord<String, String> record = new ProducerRecord<>("PUBLISH", null, message);
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        System.out.printf("✔ Отправлено в %s partition %d offset %d%n",
                                metadata.topic(), metadata.partition(), metadata.offset());
                    } else {
                        System.err.println("Ошибка при отправке сообщения:");
                        exception.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            System.err.println("Ошибка при работе с Kafka:");
            e.printStackTrace();
        }
    }
}