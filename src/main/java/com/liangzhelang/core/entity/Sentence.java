package com.liangzhelang.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangzhelang
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sentence implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String text;

    private String reflection;

    private String work;

    private String author;

    private String vocalizer;

    private String labels;

    private String location;

    private Integer typeId;

    private Integer languageId;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;


}
