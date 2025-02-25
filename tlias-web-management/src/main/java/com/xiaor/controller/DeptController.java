package com.xiaor.controller;

import com.xiaor.pojo.Dept;
import com.xiaor.pojo.Result;
import com.xiaor.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 部门管理
//@Slf4j      // 声明日志记录对象的注解
@RestController // 与前端交互的类
@RequestMapping("/depts")
public class DeptController {

    // 日志记录对象
    private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门操作
     * @return
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)   // 路由,设置为GET方法
    @GetMapping     // 也阔以替换为GetMapping
    public Result getDeptList(){
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/{id}")  // 使用@PathVariable接收路径参数
    public Result deleteDeptById(@PathVariable Integer id){
        log.info("根据id删除部门");
        Integer deleteRow = deptService.delete(id);
        if (1 != deleteRow){
            return Result.error("删除部门失败");
        }
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     */
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("新增部门");
        Integer insertRow = deptService.addDept(dept);
        if (1 != insertRow){
            return Result.error("新增部门失败");
        }
        return Result.success();
    }

    /**
     * 查询部门
     * @param id    部门id
     * @return
     */
    @GetMapping("/{id}")
    public Result queryDeptById(@PathVariable Integer id){
        log.info("查询部门");
        Dept dept = deptService.queryDeptById(id);
//        if (null == dept){
//            return Result.error("没有此部门");
//        }
        return Result.success(dept);
    }

    /**
     * 更新部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("更新部门");
        deptService.updateDept(dept);
        return Result.success();
    }
}
