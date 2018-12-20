package com.liangzhelang.core.service.impl;

import com.liangzhelang.core.entity.Person;
import com.liangzhelang.core.mapper.PersonMapper;
import com.liangzhelang.core.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangzhelang
 * @since 2018-12-20
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
