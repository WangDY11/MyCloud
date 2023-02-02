package com.wdy.rmq.consumer.canal;

import com.alibaba.fastjson.JSONObject;
import com.wdy.login.service.ICanalTestService;
import com.wdy.rmq.bean.CanalBinLogBean;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Log4j2
@Service
@RocketMQMessageListener(
        topic = "CanalTestTopic", consumerGroup = "G1-CanalTestConsumer",
        consumeMode = ConsumeMode.ORDERLY, enableMsgTrace = true
)
public class CanalTestConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {


    @Resource(name = "canalTestServiceImpl")
    private ICanalTestService canalTestService;

    /**
     * 最大重试次数
     */
    @Value("${rocketmq.consumer.maxReconsumeTimes}")
    private Integer maxReconsumeTimes;


    @Override
    public void onMessage(MessageExt message) {
        CanalBinLogBean canalBinLogBean = JSONObject.parseObject(new String(message.getBody()), CanalBinLogBean.class);
        log.warn("canal-RMQMessage = " + message);
        log.warn("canal-RMQBody = " + canalBinLogBean);
        log.info("topic-CanalTestTopic，msgId={}，reconsumeTimes={}，msgBody={}",
                message.getMsgId(), message.getReconsumeTimes(), canalBinLogBean);

        String type = canalBinLogBean.getType();
        if (type.equals("INSERT")) {
            canalTestService.canalTestInsert(canalBinLogBean.getData());
        }else if (type.equals("UPDATE")){
            canalTestService.canalTestUpdate(canalBinLogBean.getData());
        }

    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setMaxReconsumeTimes(maxReconsumeTimes);
    }
}
