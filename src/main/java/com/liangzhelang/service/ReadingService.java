package com.liangzhelang.service;


import com.liangzhelang.entity.Sentence;
import com.liangzhelang.util.Page;

import java.util.List;

public interface ReadingService {
	
	public Integer getSentencesCount(Sentence condition);

	public Page<Sentence> getSentencesInPage(Page<Sentence> p, Sentence condition);

	
	
}
