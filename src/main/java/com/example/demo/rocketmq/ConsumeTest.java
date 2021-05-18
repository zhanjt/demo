//package com.example.demo.rocketmq;
//
//import cn.anicert.rocketmq.IPullConsumer;
//import cn.anicert.rocketmq.bean.MQConfig;
//import cn.anicert.rocketmq.impl.PullConsumer;
//import com.example.demo.utils.SpringUtil;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * <功能说明>
// * rocketmq消费者
// *
// * @author zhanjiantong
// * @version Revision 1.0.0
// * 修改时间 2021/5/11  | 修改内容
// */
//@Component
//public class ConsumeTest implements Runnable{
//
//    private MQConfig mqConfig;
//
//    @Value("${ctid.maintenance.ReceiveMq.topicNameBusiness}")
//    private String topicName;
//
//    /**
//     * pull模式消费者
//     */
//    private IPullConsumer pullConsumerPerformance;
//
//    private boolean connect;
//
//
//    public ConsumeTest() {
//        LogMessageConfig logMessageConfig = SpringUtil.getBean(LogMessageConfig.class);
//        mqConfig = new MQConfig();
//        mqConfig.setNamesrvAddr(logMessageConfig.getNamesrvAddr());
//        mqConfig.setConsumerGroupName(logMessageConfig.getConsumerGroupName());
//        mqConfig.setInstanceName(logMessageConfig.getInstanceName());
//        mqConfig.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        pullConsumerPerformance = new PullConsumer(mqConfig);
//        this.connect = pullConsumerPerformance.connect();
//    }
//
//
//    @Override
//    public void run() {
//        System.out.println("日志消费中...");
//        while (this.connect){
//
//        }
//    }
//}
