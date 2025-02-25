package com.xiaor.controller;

import com.xiaor.pojo.Emp;
import com.xiaor.pojo.PageBean;
import com.xiaor.pojo.Result;
import com.xiaor.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


//@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    // 日志记录对象
    private static Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * 根据条件查询员工信息
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name, Short gender,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询, 参数 : {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        // 调用service分页查询
        PageBean pageBean = empService.getPage(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 删除员工信息
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable List<Integer> ids) {
        log.info("删除员工信息");
        empService.deleteEmp(ids);
        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("新增员工 : {}", emp);
        empService.addEmp(emp);
        return Result.success();
    }

    /**
     * 查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询员工信息, id : {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     * @param emp
     * @return
     */
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("更新员工信息, emp : {}", emp);
        empService.updateEmp(emp);
        return Result.success();
    }
}
