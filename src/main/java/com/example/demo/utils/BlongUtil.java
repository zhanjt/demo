package com.example.demo.utils;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;

/**
 * <功能说明>
 * 布隆过滤器 测试
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/10/28  | 修改内容
 */
public class BlongUtil {



    /**
     * 在布隆中存放100万条数据
     */
    private static Integer size = 1000000;

    public static void main(String[] args) {
        BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.01);
        for (int i = 0; i < size; i++) {
            integerBloomFilter.put(i);
        }
        // 从布隆中查询数据是否存在
        ArrayList<Integer> strings = new ArrayList<>();
        for (int j = size; j < size + 10000; j++) {
            if (integerBloomFilter.mightContain(j)) {
                strings.add(j);
            }
        }
        System.out.println("误判数量:" + strings.size());

    }

}
