package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    /**
    * @author Banner
    * @time 17:16 2025/8/7
    * @Param categoryPageQueryDTO
    * @return com.sky.result.PageResult
    * @Description 分类页面分页查询
    */
    PageResult page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
    * @author Banner
    * @time 17:36 2025/8/7
    * @Param categoryDTO
    * @return
    * @Description 新增分类
    */
    void save(CategoryDTO categoryDTO);

    /**
    * @author Banner
    * @time 18:08 2025/8/7
    * @Param categoryDTO
    * @return
    * @Description 修改分类
    */
    void update(CategoryDTO categoryDTO);

    /**
    * @author Banner
    * @time 18:23 2025/8/7
    * @Param statusid
    * @return
    * @Description 启用/禁用 分类状态
    */
    void startOrStop(Integer status, Long id);

    /**
    * @author Banner
    * @time 19:05 2025/8/7
    * @Param id
    * @return 
    * @Description 
    */
    void deleteById(Long id);

    /**
    * @author Banner
    * @time 20:49 2025/8/7
    * @Param type
    * @return java.util.List<com.sky.entity.Category>
    * @Description 根据类型查询分类
    */
    List<Category> list(Integer type);
}
