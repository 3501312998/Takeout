package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * @return com.github.pagehelper.Page<com.sky.entity.Category>
     * @author Banner
     * @time 17:23 2025/8/7
     * @Param categoryPageQueryDTO
     * @Description 分类页面分页查询
     */
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * @return
     * @author Banner
     * @time 17:40 2025/8/7
     * @Param category
     * @Description 新增分类
     */
    @Insert("insert into category(type, name, sort, status, create_time, update_time, create_user, update_user)\n" +
            "values (#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Category category);

    /**
     * @return
     * @author Banner
     * @time 18:11 2025/8/7
     * @Param category
     * @Description 修改分类
     */
    void update(Category category);

    /**
     * @return
     * @author Banner
     * @time 19:26 2025/8/7
     * @Param id
     * @Description 根据ID删除分类
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * @return
     * @author Banner
     * @time 19:26 2025/8/7
     * @Param type
     * @Description 根据类型查询分类
     */
    List<Category> list(Integer type);
}
