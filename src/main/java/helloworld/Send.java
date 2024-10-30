package helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Send {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) {
		sendMessage(RabbitMqConnectionUtils.makeConnection());
	}

	private static void sendMessage(ConnectionFactory factory) {
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			System.out.println(" [x] Sent '" + message + "'");
		} catch (IOException | TimeoutException exception){
			System.out.println(exception.getMessage());
		}
	}
}
