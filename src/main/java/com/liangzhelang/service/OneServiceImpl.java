package com.liangzhelang.service;

import java.util.List;
import java.util.Random;
import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OneServiceImpl implements OneService {
	
	@Autowired
	private SentenceMapper sentenceMapper;
	
	public Sentence selectOne(Integer sid) {
		return sentenceMapper.selectById(sid);
	}

	public Integer updateOne(Sentence s) {
		return sentenceMapper.updateById(s);
	}

	public Integer deleteOne(Integer sid) {
		return sentenceMapper.deleteById(sid);
	}

	public Integer randomOneId() {
		List<Integer> li = sentenceMapper.selectAllIds();
		//数据库中没有句子
		if(li.size()==0){
			return -1;
		}else{
			Random random = new Random(System.currentTimeMillis());
			return li.get(random.nextInt(li.size()));
		}

	}

}
