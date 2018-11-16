package com.liangzhelang.service;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzhelang.dao.LanguageMapper;
import com.liangzhelang.dao.TypeMapper;
import com.liangzhelang.entity.Language;
import com.liangzhelang.entity.Type;
import com.liangzhelang.util.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;






@Service("loginService")
public class LoginServiceImpl implements LoginService{

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
	
	public String getLangsJson() {
		List<Language> li = languageMapper.selectList(new QueryWrapper<Language>());
		String str = MyJson.obj2Str(li);
		return str;
				
	}

	public String getTypesJson() {
		List<Type> li = typeMapper.selectList(new QueryWrapper<Type>());
		String str = MyJson.obj2Str(li);
		return str;
	}

}
