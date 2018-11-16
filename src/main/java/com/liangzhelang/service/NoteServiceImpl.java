package com.liangzhelang.service;

import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import com.liangzhelang.util.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;






@Service
public class NoteServiceImpl implements NoteService{

	private static Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);

	@Autowired
	private SentenceMapper sentenceMapper;
	
	
	public Integer add(Sentence s) {

        Integer i = sentenceMapper.insert(s);
        if(i==1){
            LOGGER.info("成功添加了一条句子：" + MyJson.obj2Str(s));
        }else{
            // TODO: 2018/11/16 Exception?
            LOGGER.error("未能添加句子：" + MyJson.obj2Str(s));
        }
        return i;

	}

	

}
