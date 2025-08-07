package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description TODO
 * @Author li
 * @Date 2025/8/7 17:12
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private SetmealMapper setmealMapper;

    /**
    * @author Banner
    * @time 17:36 2025/8/7
    * @Param categoryDTO
    * @return
    * @Description 新增分类
    */
    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setStatus(StatusConstant.DISABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.insert(category);
    }

    @Override
    public List<Category> list(Integer type) {
        List<Category> list =  categoryMapper.list(type);
        return list;
    }

    /**
    * @author Banner
    * @time 19:05 2025/8/7
    * @Param id
    * @return
    * @Description 删除分类
    */
    @Override
    public void deleteById(Long id) {
        //判断当前分类是否关联了菜品
        if (dishMapper.countByCategoryId(id) > 0){
            //当前分类关联了菜品则不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }
        //判断当前分类是否关联了套餐
        if (setmealMapper.countByCategoryId(id) > 0){
            //当前分类关联了套餐则不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }
        //删除分类
        categoryMapper.deleteById(id);
    }

    /**
    * @author Banner
    * @time 18:23 2025/8/7
    * @Param statusid
    * @return
    * @Description 启用/禁用 分类状态
    */
    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = Category.builder().status(status).id(id).build();
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.update(category);
    }

    /**
    * @author Banner
    * @time 18:09 2025/8/7
    * @Param categoryDTO
    * @return
    * @Description 修改分类
    */
    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    /**
    * @author Banner
    * @time 17:17 2025/8/7
    * @Param categoryPageQueryDTO
    * @return com.sky.result.PageResult
    * @Description 分类页面分页查询
    */
    @Override
    public PageResult page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page =  categoryMapper.page(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}