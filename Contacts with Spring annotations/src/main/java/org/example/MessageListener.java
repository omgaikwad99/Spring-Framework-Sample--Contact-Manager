package org.example;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;


@Component
public class MessageListener {
    private static CountDownLatch latch = new CountDownLatch(1);
    @RabbitListener(queues = MessagingRabbitmqApplication.queueName)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }
    public static CountDownLatch getLatch() {
        System.out.println("Received: "+latch);
        return latch;
    }

}
