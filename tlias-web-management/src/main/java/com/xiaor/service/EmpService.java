package com.xiaor.service;

import com.xiaor.pojo.Emp;
import com.xiaor.pojo.PageBean;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {

    PageBean getPage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmp(List<Integer> ids);

    void addEmp(Emp emp);

    Emp getById(Integer id);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
