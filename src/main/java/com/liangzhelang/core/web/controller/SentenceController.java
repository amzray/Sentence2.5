package com.liangzhelang.core.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liangzhelang.core.entity.Sentence;
import com.liangzhelang.core.service.SentenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangzhelang
 * @since 2018-12-20
 */
@Slf4j
@RestController
@RequestMapping("/sentence")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService;

    @GetMapping()
    public IPage<Sentence> getPage(Page page,
                                   String text,
                                   String author,
                                   String work,
                                   String vocalizer,
                                   String location,
                                   String labels,
                                   String reflection,
                                   Integer typeId,
                                   Integer languageId
                                   ){
        QueryWrapper<Sentence> wrapper = new QueryWrapper<Sentence>();
        wrapper.like(text!=null, "text", text);
        wrapper.like(work!=null, "work", work);
        wrapper.like(author!=null, "author", author);
        wrapper.like(vocalizer!=null, "vocalizer", vocalizer);
        wrapper.like(location!=null, "location", location);
        wrapper.like(labels!=null, "labels", labels);
        wrapper.like(reflection!=null, "reflection", reflection);
        wrapper.eq(typeId!=null, "typeId", typeId);
        wrapper.eq(languageId!=null, "languageId", languageId);
        return sentenceService.page(page, wrapper);
    }

    @GetMapping("/{id}")
    public Sentence getById(@PathVariable Integer id){
        return sentenceService.getById(id);
    }

    @PostMapping()
    public void saveOne(Sentence sentence){
        sentenceService.save(sentence);
    }

    @PutMapping()
    public void updateById(Sentence sentence){
        sentenceService.updateById(sentence);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable Integer id){
        sentenceService.removeById(id);
    }

}

