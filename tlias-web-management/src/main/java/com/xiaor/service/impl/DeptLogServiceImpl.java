package com.xiaor.service.impl;

import com.xiaor.mapper.DeptLogMapper;
import com.xiaor.pojo.DeptLog;
import com.xiaor.service.DeptLogServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogServive {
    @Autowired
    private DeptLogMapper deptLogMapper;    // 日志操作对象

    /**
     * 日志记录
     * @param deptLog
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)      // 添加一个新的事务,即使上级操作异常,不会影响此事务
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
