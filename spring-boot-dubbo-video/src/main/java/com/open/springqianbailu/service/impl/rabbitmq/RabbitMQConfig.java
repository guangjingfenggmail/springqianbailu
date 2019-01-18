package com.open.springqianbailu.service.impl.rabbitmq;

import com.alibaba.dubbo.config.annotation.Reference;
import com.open.springqianbailu.model.table.rabbitmq.RabbitMessage;
import com.open.springqianbailu.model.table.rabbitmq.RabbitQueue;
import com.open.springqianbailu.service.rabbitmq.RabbitMessageService;
import com.open.springqianbailu.service.rabbitmq.RabbitQueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static com.open.springqianbailu.rabbitmq.QueueConfig.*;


@Configuration
public class RabbitMQConfig {
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

//    public final static String EXCHANGE_NAME = "amq.topic";
//    public  final static String QUEUE_NAME = "topic.baqgl.*.*";
//    public final static String ROUTING_KEY = "topic.baqgl.#";


    @Bean
    Queue queue() {
        return new Queue(QUEUENAME_NOVEL, false);
    }

    @Bean
    Queue queueg() {
        return new Queue(QUEUENAME_GALLERY, false);
    }
    @Bean
    Queue queuev() {
        return new Queue(QUEUENAME_VIDEO, false);
    }

    @Value("${spring.rabbitmq.host}")
    private String addresses;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

//    @Value("${spring.rabbitmq.queues}")
//    private String queues;

    @Reference
    private RabbitQueueService rabbitQueueService;

    @Reference
    private RabbitMessageService rabbitMessageService;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(publisherConfirms);

        logger.info(TAG+ " connectionFactory:addresses==" + addresses + ":" + port + "\n username===" + username+"\n password==="+password
                +"\n publisherConfirms==="+publisherConfirms+"\n");
        return connectionFactory;
    }

    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                logger.info(TAG+" id=="+correlationData.getId()+"s==="+s+"b=="+b);

                List<RabbitMessage> list =  rabbitMessageService.selectByUUId(correlationData.getId());
                if (list!=null && list.size()>0) {
                    RabbitQueue msg = new RabbitQueue();
                    msg.setStatus(2);
                    msg.setRabbit_mq_id(list.get(0).getId());
                    msg.setUuid(correlationData.getId());
                    msg.setRoutingKey(list.get(0).getRoutingKey());
                    msg.setCause(s);
                    msg.setAck(b == true ? 1 : 0);
                    rabbitQueueService.insert(msg);
                }
            }
        });
        return template;
    }

//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
//    }


//    @Bean
//    public SimpleMessageListenerContainer messageContainer() {
//		/*Queue[] q = new Queue[queues.split(",").length];
//		for (int i = 0; i < queues.split(",").length; i++) {
//			q[i] = new Queue(queues.split(",")[i]);
//		}*/
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
//        container.setQueues(queue());
//        container.setExposeListenerChannel(true);
//        container.setMaxConcurrentConsumers(1);
//        container.setConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new ChannelAwareMessageListener() {
//
//            public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
//                try {
//
//                    RabbitMessage rabbitMessage = new RabbitMessage();
//                    rabbitMessage.setStatus(3);
//                    rabbitMessage.setUuid(message.getMessageProperties().getMessageId());
//                    rabbitMessage.setUpdateTime(System.currentTimeMillis()+"");
//                    rabbitMessageService.updateById(rabbitMessage);
//
//                    logger.info(TAG+ " 消费端接收到消息:" + message.getMessageProperties() + ":" + new String(message.getBody()));
//                    logger.info(TAG+ " topic:"+message.getMessageProperties().getReceivedRoutingKey());
//                    // deliveryTag是消息传送的次数，我这里是为了让消息队列的第一个消息到达的时候抛出异常，处理异常让消息重新回到队列，然后再次抛出异常，处理异常拒绝让消息重回队列
//					/*if (message.getMessageProperties().getDeliveryTag() == 1
//							|| message.getMessageProperties().getDeliveryTag() == 2) {
//						throw new Exception();
//					}*/
//
//                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // false只确认当前一个消息收到，true确认所有consumer获得的消息
//                } catch (Exception e) {
//                    e.printStackTrace();
//
//                    if (message.getMessageProperties().getRedelivered()) {
//                        RabbitMessage rabbitMessage = new RabbitMessage();
//                        rabbitMessage.setStatus(4);
//                        rabbitMessage.setUuid(message.getMessageProperties().getMessageId());
//                        rabbitMessage.setUpdateTime(System.currentTimeMillis()+"");
//                        rabbitMessageService.updateById(rabbitMessage);
//                        logger.error(TAG+" 消息已重复处理失败,拒绝再次接收...");
//                        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
//                    } else {
//                        RabbitMessage rabbitMessage = new RabbitMessage();
//                        rabbitMessage.setStatus(-2);
//                        rabbitMessage.setUuid(message.getMessageProperties().getMessageId());
//                        rabbitMessage.setUpdateTime(System.currentTimeMillis()+"");
//                        rabbitMessageService.updateById(rabbitMessage);
//                        logger.error(TAG+" 消息即将再次返回队列处理...");
//                        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // requeue为是否重新回到队列
//                    }
//                }
//            }
//        });
//        return container;
//    }

}
