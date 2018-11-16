package com.liangzhelang;

import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import com.liangzhelang.util.MyJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceMapperTester {

    @Autowired
    SentenceMapper mySentenceMapper;

    @Test
    public void insertTest(){
        Sentence s = new Sentence();
        s.setText("句子");
        s.setAuthor("作者");
        s.setWorks("作品");
        s.setLabels("标签");
        s.setSpeaker("歌者");
        s.setTypeId(1);
        s.setLanguageId(1);
        s.setReflection("心得");
        s.setLocation("段落");
        mySentenceMapper.insert(s);
    }

    @Test
    public void selectTest(){
        Sentence s = mySentenceMapper.selectById(2);
        System.out.println(MyJson.obj2Str(s));
    }

    @Test
    public void selectAllIdTest(){
        List<Integer> li = mySentenceMapper.selectAllIds();
        Iterator<Integer> it = li.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void updateTest(){
        Sentence s = new Sentence();
        s.setId(2);
        s.setText("改了");
        mySentenceMapper.updateById(s);
    }

    @Test
    public void deleteTest(){
        mySentenceMapper.deleteById(1);
    }
}
