package com.liangzhelang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liangzhelang.entity.*;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface SentenceMapper extends BaseMapper<Sentence> {
    @Select("SELECT id FROM sentence")
    List<Integer> selectAllIds();

}
