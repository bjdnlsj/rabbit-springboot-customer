package com.bjdnlsj.rabbitspringboot.consumer;

import com.bjdnlsj.rabbitspringboot.entity.MsgWebNoticeRelation;
import com.bjdnlsj.rabbitspringboot.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RabbitReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",durable = "true"),
            exchange = @Exchange(value = "exchange-1",
                    durable = "true",
                    type = "topic",
                    ignoreDeclarationExceptions = "true"),
                    key = "springboot.*"
            )
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception{
        System.err.println("-----------------------------------------");
        System.err.println("消费端："+message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        // 手工ack
        channel.basicAck(deliveryTag,false);
    }

    //${spring.rabbitmq.listener.order.queue.name}
    //${spring.rabbitmq.listener.order.queue.durable}
    //${spring.rabbitmq.listener.order.exchange.name}
    //${spring.rabbitmq.listener.order.exchange.durable}
    //${spring.rabbitmq.listener.order.exchange.type}
    //${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}
    //${spring.rabbitmq.listener.order.key}

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${spring.rabbitmq.listener.order.queue.name}",durable = "${spring.rabbitmq.listener.order.queue.durable}"),
            exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}",
                    durable = "${spring.rabbitmq.listener.order.exchange.durable}",
                    type = "${spring.rabbitmq.listener.order.exchange.type}",
                    ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}"),
            key = "${spring.rabbitmq.listener.order.key}"
        ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order oder, Channel channel, @Headers Map<String ,Object> headers) throws Exception{
        System.err.println("-----------------------------------------");
        System.err.println("消费端："+oder.getId());
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手工ack
        channel.basicAck(deliveryTag,false);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "emis_message_topic_queue",durable = "true"),
            exchange = @Exchange(
                    value = "emis_message_topic_exchange",
                    durable = "true",
                    type = "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "emis.message.ewsd0001"
    ))
    @RabbitHandler
    public void onMsgMessage(@Payload MsgWebNoticeRelation oder, Channel channel, @Headers Map<String ,Object> headers) throws Exception{
        System.err.println("-----------------------------------------");
        System.err.println("消费端："+oder.getWebNoticeUuid());
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手工ack
        channel.basicAck(deliveryTag,false);
    }
}
