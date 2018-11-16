package com.liangzhelang.service;

import java.util.List;
import java.util.Random;
import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import com.liangzhelang.util.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OneServiceImpl implements OneService {

	private static Logger LOGGER = LoggerFactory.getLogger(OneServiceImpl.class);


	@Autowired
	private SentenceMapper sentenceMapper;
	
	@Override
	public Sentence selectOne(Integer sid) {
		Sentence s = sentenceMapper.selectById(sid);
		if(s!=null){
			LOGGER.info("成功获取到了一条句子：" + MyJson.obj2Str(s));
		}else{
			// TODO: 2018/11/16 Exception?
			LOGGER.error("未能获取句子");
		}
		return s;
	}

	@Override
	public Integer updateOne(Sentence s) {
		Sentence old = sentenceMapper.selectById(s.getId());
		Integer i = sentenceMapper.updateById(s);
		if(i==1){
			LOGGER.info("成功更新了一条句子：" + MyJson.obj2Str(old) + "更新为："+ MyJson.obj2Str(s));
		}else{
			// TODO: 2018/11/16 Exception?
			LOGGER.error("未能更新句子：" + MyJson.obj2Str(old));
		}
		return i;
	}

	@Override
	public Integer deleteOne(Integer sid) {
		Sentence s = sentenceMapper.selectById(sid);
		Integer i = sentenceMapper.deleteById(sid);
		if(i==1){
			LOGGER.info("成功删除了一条句子：" + MyJson.obj2Str(s));
		}else{
			// TODO: 2018/11/16 Exception?
			LOGGER.error("未能删除句子：" + MyJson.obj2Str(s));
		}
		return i;
	}

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
