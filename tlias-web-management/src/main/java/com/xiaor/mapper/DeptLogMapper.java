package com.xiaor.mapper;

import com.xiaor.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    /**
     * 插入dept表删除操作的日志记录
     * @param deptLog
     */
    @Insert("insert into dept_log(create_time, description) values(#{createTime}, #{description})")
    void insert(DeptLog deptLog);
}
