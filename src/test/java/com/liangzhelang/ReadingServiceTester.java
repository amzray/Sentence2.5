package com.liangzhelang;

import com.liangzhelang.entity.Sentence;
import com.liangzhelang.service.ReadingService;
import com.liangzhelang.util.MyJson;
import com.liangzhelang.util.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadingServiceTester {
    @Autowired
    ReadingService readingService;

    @Test
    public void selectCountTest(){
        Sentence s = new Sentence();
        s.setLanguageId(3);
        Assert.assertEquals(new Integer(0), readingService.getSentencesCount(s));
    }

    @Test
    public void selectPageTest(){
        Sentence s = new Sentence();
        Integer totalRecord = readingService.getSentencesCount(s);
        Page<Sentence> p = new Page<Sentence>(1, 10, totalRecord);
        p = readingService.getSentencesInPage(p, s);
        Iterator<Sentence> it = p.getList().iterator();
        while(it.hasNext()){
            System.out.println(MyJson.obj2Str(it.next()));
        }

    }
}
