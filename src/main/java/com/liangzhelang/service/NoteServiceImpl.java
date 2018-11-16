package com.liangzhelang.service;

import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;






@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private SentenceMapper sentenceMapper;
	
	
	public Integer add(Sentence s) {
		return sentenceMapper.insert(s);
	}

	

}
