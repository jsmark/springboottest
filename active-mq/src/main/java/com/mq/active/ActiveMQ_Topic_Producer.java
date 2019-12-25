package com.mq.active;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQ_Topic_Producer {
    public void producer() throws Exception{
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin","admin","tcp://192.168.164.128:61616");
        // 连接工厂
        // 使用默认用户名、密码、路径
        // 路径 tcp://host:61616
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        // 获取一个连接
        Connection connection = connectionFactory.createConnection();
        // 建立会话  第一个参数是事务，第二个叫签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 创建队列或者话题对象
        Topic queue = session.createTopic("topic-consumer1");
        // 创建生产者 或者 消费者
        MessageProducer producer = session.createProducer(queue);

        // 发送消息
        for (int i = 0; i < 10; i++) {
            producer.send(session.createTextMessage("你好，activeMQ_topic:" + i));
        }
        // 提交操作
        session.commit();
        producer.close();
        session.close();
        connection.close();
    }
    public static void main (String [] args) throws Exception{
        ActiveMQ_Topic_Producer activeMQConsumer =new ActiveMQ_Topic_Producer();
        activeMQConsumer.producer();
    }
}
