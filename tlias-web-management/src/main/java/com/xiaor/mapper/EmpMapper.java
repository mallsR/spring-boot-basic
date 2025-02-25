package com.xiaor.mapper;

import com.xiaor.pojo.Emp;
import com.xiaor.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
//    /**
//     * 获取总记录数
//     * @return
//    @Select("select count(*) from emp")
//    Long count();

//    /**
//     * 查询目标页数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start}, #{pageSize};")
//    public List<Emp> getPage(Integer start, Integer pageSize);

    /**
     * 查询员工信息
     * @return
     */
//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除员工
     * @param ids
     */
    void deleteEmp(List<Integer> ids);

    /**
     * 插入员工
     * @param emp
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void addEmp(Emp emp);

    /**
     * 查询员工信息
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void updateEmp(Emp emp);

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByAccount(Emp user);

    /**
     * 根据部门id删除员工信息
     * @param deptId
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
