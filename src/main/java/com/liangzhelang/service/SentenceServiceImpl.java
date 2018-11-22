package com.liangzhelang.service;

import java.util.List;
import java.util.Random;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SentenceServiceImpl extends ServiceImpl<SentenceMapper, Sentence> implements SentenceService {

	private static Logger LOGGER = LoggerFactory.getLogger(SentenceServiceImpl.class);

	@Autowired
	private SentenceMapper sentenceMapper;


	@Override
	public Integer randomOneId() {
		List<Integer> li = sentenceMapper.selectAllIds();
		//数据库中没有句子
		if(li.size()==0){
			LOGGER.warn("没有从数据库中获得任何句子ID");
			return -1;
		}else{
			LOGGER.info("成功获取了数据库所有句子的ID");
			Random random = new Random(System.currentTimeMillis());
			Integer i = li.get(random.nextInt(li.size()));
			LOGGER.info("随机获取的句子ID为"+i);
			return i;
		}

	}

}
