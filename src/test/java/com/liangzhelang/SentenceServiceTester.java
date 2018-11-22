package com.liangzhelang;

import com.liangzhelang.service.SentenceService;
import com.liangzhelang.util.MyJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceServiceTester {
    @Autowired
    SentenceService sentenceService;

    @Test
    public void randomOneTest(){
        Integer i  = sentenceService.randomOneId();
        System.out.println(MyJson.obj2Str(i));
    }


}
