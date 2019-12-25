package com.mq.active.persistence;

import com.mq.active.ActiveMQConsumer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQ_Queue_Consumer {

    public void consumer() throws Exception{
        // 连接工厂
        // 使用默认用户名、密码、路径
        // 路径 tcp://host:61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.164.128:61616");
        // 获取一个连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();
        // 建立会话
        // 第一个参数，是否使用事务，如果设置true，操作消息队列后，必须使用 session.commit();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列或者话题对象
        Queue queue = session.createQueue("HelloWorld");
        // 创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        while (true) {
//            TextMessage message = (TextMessage) messageConsumer.receive(10000);
            TextMessage message = (TextMessage) messageConsumer.receive();
            if (message != null) {
                System.out.println(message.getText());
            } else {
                break;
            }
        }

//        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }

    public static void main (String [] args) throws Exception{
        ActiveMQConsumer activeMQConsumer =new ActiveMQConsumer();
        activeMQConsumer.consumer();
    }
}
