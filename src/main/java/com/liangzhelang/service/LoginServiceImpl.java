package com.liangzhelang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzhelang.dao.LanguageMapper;
import com.liangzhelang.dao.TypeMapper;
import com.liangzhelang.entity.Language;
import com.liangzhelang.entity.Type;
import com.liangzhelang.util.MyJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;






@Service("loginService")
public class LoginServiceImpl implements LoginService{
	private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	private static int SINGLETON_CUSTOMER = 1;

	@Autowired
	private LanguageMapper languageMapper;
	@Autowired
	private TypeMapper typeMapper;

//	public Integer validate(String password) {
//		Customer cust = customerMapper.selectByPrimaryKey(SINGLETON_CUSTOMER);
//		if(!(cust.getPassword().equals(password))) {
//			return -1;
//		}else {
//			return SINGLETON_CUSTOMER;
//		}
//	}
	
	@Override
	public String getLangsJson() {
		List<Language> li = languageMapper.selectList(new QueryWrapper<Language>());
		String str = MyJson.obj2Str(li);
		// TODO: 2018/11/16 Exception?
		LOGGER.info("获取了语言类型列表的Json");
		return str;
	}

	@Override
	public String getTypesJson() {
		List<Type> li = typeMapper.selectList(new QueryWrapper<Type>());
		String str = MyJson.obj2Str(li);
		// TODO: 2018/11/16 Exception?
		LOGGER.info("获取了体裁类型列表的Json");
		return str;
	}

}
