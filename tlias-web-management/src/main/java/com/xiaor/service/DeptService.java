package com.xiaor.service;

import com.xiaor.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> list();

    int delete(Integer id);

    int addDept(Dept dept);

    Dept queryDeptById(Integer id);

    void updateDept(Dept dept);
}
