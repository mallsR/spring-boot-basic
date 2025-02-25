package com.xiaor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaor.mapper.EmpMapper;
import com.xiaor.pojo.Emp;
import com.xiaor.pojo.PageBean;
import com.xiaor.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /*@Override
    public PageBean getPage(Integer page, Integer pageSize) {
        // 1. 获取总记录数
        Long pageNum = empMapper.count();
        // 2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> pageBeans = empMapper.getPage(start, pageSize);

        // 3. 封装PageBean对象
        PageBean pageBean = new PageBean(pageNum, pageBeans);performance_schema
        return pageBean;
    }*/

    /**
     * 使用PageHelper插件
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                            LocalDate begin, LocalDate end) {
        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 2. 获取分页查询结果列表
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> empPage = (Page<Emp>) empList;    // 强制类型转换
        // 3. 封装PageBean对象
        PageBean pageBean = new PageBean(empPage.getTotal(), empPage.getResult());
        return pageBean;
    }

    /**
     * 删除员工信息
     * @param ids
     */
    @Override
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmp(ids);
    }

    /**
     * 新增员工
     * @param emp
     */
    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }

    /**
     * 查询员工信息
     * @param id
     * @return
     */
    @Override
    public Emp getById(Integer id) {
       return empMapper.getById(id);
    }

    /**
     * 更新员工信息
     * @param emp
     */
    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

    /**
     * 用户登录
     * @param emp
     * @return
     */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByAccount(emp);
    }
}
