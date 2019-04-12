package com.zsx.processor;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by ZSX on 2018/7/16.
 *
 * @author ZSX
 */
public class TestItemProcessor implements ItemProcessor<Integer, Integer> {

    public Integer process(Integer num) throws Exception {
        return num++;
    }
}
