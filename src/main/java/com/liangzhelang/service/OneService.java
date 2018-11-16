package com.liangzhelang.service;


import com.liangzhelang.entity.Sentence;

public interface OneService {
	public Sentence selectOne(Integer sid);

	public Integer updateOne(Sentence s);

	public Integer deleteOne(Integer sid);

	public Integer randomOneId();
}
