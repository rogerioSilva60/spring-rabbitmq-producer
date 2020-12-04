package br.com.rabbitmq.producer.core.ampq;

public interface ProducerAmpq<T> {

	void producer(T t);
}
