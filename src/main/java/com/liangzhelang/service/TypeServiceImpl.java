package com.liangzhelang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzhelang.dao.TypeMapper;
import com.liangzhelang.entity.Type;
import com.liangzhelang.util.MyJson;

public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Override
    public String getListAsJson(){
        return MyJson.obj2Str(this.list(null));
    }
}
