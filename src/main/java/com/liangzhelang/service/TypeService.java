package com.liangzhelang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzhelang.entity.Type;

public interface TypeService extends IService<Type> {

    public String getListAsJson();

}
