package br.com.rabbitmq.producer.core.amqp;

public interface ProducerAmqp<T> {

	void producer(T t);
}
