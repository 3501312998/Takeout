package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author li
 * @Date 2025/8/7 17:09
 */
@RestController
@Slf4j
@Api(tags = "分类管理")
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * @return com.sky.result.Result<com.sky.result.PageResult>
     * @author Banner
     * @time 17:16 2025/8/7
     * @Param categoryPageQueryDTO
     * @Description 分类页面分页查询
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询:{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.page(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * @return com.sky.result.Result
     * @author Banner
     * @time 17:35 2025/8/7
     * @Param categoryDTO
     * @Description 新增分类
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类:{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * @return com.sky.result.Result
     * @author Banner
     * @time 18:08 2025/8/7
     * @Param categoryDTO
     * @Description 修改分类
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类:{}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * @return com.sky.result.Result
     * @author Banner
     * @time 18:23 2025/8/7
     * @Param statusid
     * @Description 启用/禁用 分类状态
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用/禁用 分类状态")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        log.info("启用或禁用分类:{}", id);
        categoryService.startOrStop(status, id);
        return Result.success();
    }


    /**
    * @author Banner
    * @time 19:05 2025/8/7
    * @Param id
    * @return com.sky.result.Result
    * @Description 删除分类
    */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result delete(Long id) {
        log.info("删除分类的ID:{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
    * @author Banner
    * @time 20:49 2025/8/7
    * @Param type
    * @return com.sky.result.Result<java.util.List<com.sky.entity.Category>>
    * @Description 根据类型查询分类
    */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类:{}", type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

}