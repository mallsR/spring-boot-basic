package com.xiaor.service.impl;

import com.xiaor.anno.Log;
import com.xiaor.mapper.DeptMapper;
import com.xiaor.mapper.EmpMapper;
import com.xiaor.pojo.Dept;
import com.xiaor.pojo.DeptLog;
import com.xiaor.service.DeptLogServive;
import com.xiaor.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    // 注入mapper接口,访问数据库
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogServive deptLogServive;      // 操作dept表的日志记录对象

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Log        // 记录数据库管理日志
    @Transactional(rollbackFor = Exception.class)  // spring的事务管理  propagation属性默认为Propagation.REQUIRED
    @Override
    public int delete( Integer id) {
//        System.currentTimeMillis()
        try {
            // 1. 删除部门
            deptMapper.deleteById(id);
//            int i = 1 / 0;   // 模拟抛出异常
            // 此处必须因出错抛出异常,而不是手动抛出异常
//        if (true) {
//            throw new Exception("出错啦...");
//        }
            // 2. 根据部门id,删除部门下的员工信息
            empMapper.deleteByDeptId(id);
        } finally {
            // 提交删除部门的日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是" + id + "号部门");
            deptLogServive.insert(deptLog);
        }
        return 1;
    }

    @Log
    @Override
    public int addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        return deptMapper.addDepte(dept);
    }

    @Override
    public Dept queryDeptById(Integer id) {
        return deptMapper.queryDeptById(id);
    }

    @Log
    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}
