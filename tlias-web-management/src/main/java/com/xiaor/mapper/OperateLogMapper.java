package com.xiaor.mapper;

import com.xiaor.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    /**
     * 为各种DAO层操作插入操作日志记录
     * @param operateLog
     */
    @Insert("insert into operate_log(operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time)" +
            "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog operateLog);
}
