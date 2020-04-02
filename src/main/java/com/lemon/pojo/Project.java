package com.lemon.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * InnoDB free: 3072 kB
 * </p>
 *
 * @author kk
 * @since 2020-02-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

   
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

   
    private String name;

   
    private String host;

   
    private String description;

 
    private Integer createUser;

 
    private Date createTime;


}
