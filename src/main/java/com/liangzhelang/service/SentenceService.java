package com.liangzhelang.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzhelang.entity.Sentence;

public interface SentenceService extends IService<Sentence> {

	public Integer randomOneId();
}
