package com.liangzhelang.core.web.controller;


import com.liangzhelang.core.entity.Type;
import com.liangzhelang.core.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping()
    public List<Type> getList(){
        return typeService.list(null);
    }

    @GetMapping("/{id}")
    public Type getById(@PathVariable Integer id){
        return typeService.getById(id);
    }

    @PostMapping()
    public void saveOne(Type type){
        typeService.save(type);
    }

    @PutMapping()
    public void updateById(Type type){
        typeService.updateById(type);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Integer id){
        typeService.removeById(id);
    }
}

