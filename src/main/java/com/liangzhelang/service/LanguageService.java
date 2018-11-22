package com.liangzhelang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzhelang.entity.Language;

public interface LanguageService extends IService<Language> {

    public String getListAsJson();
}
