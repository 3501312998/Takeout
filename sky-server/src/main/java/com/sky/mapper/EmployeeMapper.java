package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status)\n" +
            "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    void insert(Employee employee);

    /**
    * @author Banner
    * @time 23:28
    * @Param employeePageQueryDTO
    * @return com.github.pagehelper.Page<com.sky.entity.Employee>
    * @Description 员工信息分页条件查询
    */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
    * @author Banner
    * @time 12:17
    * @Param employee
    * @return
    * @Description 根据员工ID修改员工信息
    */
    void update(Employee employee);
}
