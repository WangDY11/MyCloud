package com.wdy.rmq.consumer.canal;

import com.alibaba.fastjson.JSONObject;
import com.wdy.login.entity.User;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RocketMQMessageListener(
        topic = "LoginTopic", consumerGroup = "G1-LoginConsumer",
        consumeMode = ConsumeMode.ORDERLY, enableMsgTrace = true
)
public class LoginConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {
    /**
     * 最大重试次数
     */
    @Value("${rocketmq.consumer.maxReconsumeTimes}")
    private Integer maxReconsumeTimes;

    @Override
    public void onMessage(MessageExt message) {
        User user = JSONObject.parseObject(new String(message.getBody()), User.class);
        log.info("topic-CanalTestTopic，msgId={}，reconsumeTimes={}，msgBody={}",
                message.getMsgId(), message.getReconsumeTimes(), user);

        System.out.println("消费成功");
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {

        consumer.setMaxReconsumeTimes(maxReconsumeTimes);
    }
}
