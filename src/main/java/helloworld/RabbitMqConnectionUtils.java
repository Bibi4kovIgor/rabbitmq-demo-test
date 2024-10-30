package helloworld;

import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqConnectionUtils {
	public static ConnectionFactory makeConnection() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		return factory;
	}
}
