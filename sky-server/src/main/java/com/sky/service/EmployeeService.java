package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return Employee
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 保存员工
     * @param employeeDTO
     * @return
     */
    void save(EmployeeDTO employeeDTO);


    /**
    * @author Banner
    * @time 23:25
    * @Param employeePageQueryDTO
    * @return com.sky.result.PageResult
    * @Description 员工信息分页查询
    */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
    * @author Banner
    * @time 12:14
    * @Param statusid
    * @return
    * @Description 修改员工状态
    */
    void startOrStop(Integer status, Long id);

    /**
    * @author Banner
    * @time 14:28
    * @Param id
    * @return com.sky.entity.Employee
    * @Description 根据ID查询员工信息
    */
    Employee getById(Long id);

    /**
    * @author Banner
    * @time 14:39
    * @Param employeeDTO
    * @return
    * @Description
    */
    void update(EmployeeDTO employeeDTO);
}
