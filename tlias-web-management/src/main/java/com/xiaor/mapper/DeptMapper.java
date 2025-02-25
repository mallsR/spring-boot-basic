package com.xiaor.mapper;

import com.xiaor.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部的部门信息
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    int deleteById(Integer id);

    @Insert("Insert into dept(id, name, create_time, update_time) values(#{id}, #{name}, #{createTime}, #{updateTime})")
    int addDepte(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept queryDeptById(Integer id);

    // 此处有点儿问题,需要修正
    @Update("update dept set name = #{name} where id = 1")
    void updateDept(Dept dept);
}

