package com.example.demo.rocketmq;


import cn.anicert.rocketmq.IProducer;
import cn.anicert.rocketmq.bean.MQConfig;
import cn.anicert.rocketmq.bean.MQMessage;
import cn.anicert.rocketmq.bean.MQSendResult;
import cn.anicert.rocketmq.bean.MQSendStatus;
import cn.anicert.rocketmq.impl.ProducerImpl;
import com.example.demo.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <功能说明>
 *
 * @author yuchenhuang@anicert.cn
 * @version Revision 1.0.0
 * 修改时间 2019/4/25  | 修改内容
 */
public class MQUtil {
    private static final Logger logger = LoggerFactory.getLogger(MQUtil.class);

    private static IProducer producer ;
    private static MQConfig mqConfig;
    static {
        LogMessageConfig logMessageConfig = SpringUtil.getBean(LogMessageConfig.class);
        mqConfig=new MQConfig();
        mqConfig.setNamesrvAddr(logMessageConfig.getNamesrvAddr());
        mqConfig.setProducerGroupName(logMessageConfig.getConsumerGroupName());
        mqConfig.setInstanceName(logMessageConfig.getInstanceName());
        producer=new ProducerImpl(mqConfig);
        producer.connect();
    }

    public static void sendMessage(String Topic, String param) throws Exception {
        MQMessage message = new MQMessage();
        message.setTopic(Topic);
        message.setBody(param.getBytes());
        MQSendResult sendResult = producer.sendMessage(message);
        if (!MQSendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            System.out.println("发送失败, messageID: " + sendResult.getMessageId() + "sendStatus: " + sendResult.getSendStatus());
            throw new Exception();
        }
    }
}
