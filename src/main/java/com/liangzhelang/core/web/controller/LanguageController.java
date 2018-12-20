package com.liangzhelang.core.web.controller;


import com.liangzhelang.core.entity.Language;
import com.liangzhelang.core.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangzhelang
 * @since 2018-12-20
 */
@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping()
    public List<Language> getList(){
        return languageService.list(null);
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable Integer id){
        return languageService.getById(id);
    }

    @PostMapping()
    public void saveOne(Language language){
        languageService.save(language);
    }

    @PutMapping()
    public void updateById(Language language){
        languageService.updateById(language);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Integer id){
        languageService.removeById(id);
    }
}

