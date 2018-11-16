package com.liangzhelang.service;

import java.util.Arrays;
import java.util.List;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzhelang.dao.SentenceMapper;
import com.liangzhelang.entity.Sentence;
import com.liangzhelang.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


@Service
public class ReadingServiceImpl implements ReadingService{

	@Autowired
	private SentenceMapper sentenceMapper;
	
	public Integer getSentencesCount(Sentence condition) {
		QueryWrapper<Sentence> wrapper = this.generateWrapper(condition);
		Integer i = sentenceMapper.selectCount(wrapper);
		return i;
	}


	private QueryWrapper<Sentence> defaultOrer(QueryWrapper<Sentence> wrapper){
		wrapper.orderByDesc("create_time");
		return wrapper;
	}

	public Page<Sentence> getSentencesInPage(Page<Sentence> p, Sentence condition) {
		QueryWrapper<Sentence> wrapper = new QueryWrapper<Sentence>();
		//逆序
		wrapper = this.defaultOrer(wrapper);
		//分页
		wrapper.last("LIMIT "+p.getStartRow()+", " +p.getPageSize());
		p.setList(sentenceMapper.selectList(wrapper));
		return p;
	}


	public QueryWrapper<Sentence> generateWrapper(Sentence condition) {
		QueryWrapper<Sentence> wrapper = new QueryWrapper<Sentence>();

		if(condition!=null) {

			//语言类型，精确匹配
			if(condition.getLanguageId()!=null) {
				wrapper.eq("language_id", condition.getLanguageId());
			}
			//体裁类型，精确匹配
			if(condition.getTypeId()!=null) {
				wrapper.eq("type_id", condition.getTypeId());
			}
			//文本内容，模糊查询
			if(condition.getText()!=null) {
				wrapper.like("text", condition.getText());
			}
			//作者名称，模糊查询
			if(condition.getAuthor()!=null) {
				wrapper.like("author", condition.getAuthor());
			}
			//出处名称，模糊查询
			if(condition.getWorks()!=null) {
				wrapper.like("works", condition.getWorks());
			}
			//心得内容，模糊查询
			if(condition.getReflection()!=null) {
				wrapper.like("reflection", condition.getReflection());
			}
			//标签（单次查询只限单个标签），模糊查询
			if(condition.getLabels()!=null) {
				wrapper.like("labels", condition.getLabels());
			}

		}
		return wrapper;
		
	}


	
	

}
