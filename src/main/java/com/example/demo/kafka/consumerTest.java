package com.example.demo.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/9  | 修改内容
 */
@Component
public class consumerTest {

    @KafkaListener(topics = "demo-test")
    public void consumer(ConsumerRecord<?, ?> consumer){
        System.out.println("topic名称:" + consumer.topic() + ",key:" +
                consumer.key() + "," +
                "分区位置:" + consumer.partition()
                + ", 下标" + consumer.offset() + "," + consumer.value());
        String json = (String) consumer.value();
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject);
    }

}
