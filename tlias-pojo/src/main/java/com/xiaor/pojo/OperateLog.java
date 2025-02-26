package com.xiaor.pojo;

import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class OperateLog {
    private Integer id; //ID
    private Integer operateUser; //操作人ID
    private LocalDateTime operateTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
    private Long costTime; //操作耗时

    public OperateLog() {
    }

    public OperateLog(Integer id, Integer operateUser, LocalDateTime operateTime, String className, String methodName, String methodParams, String returnValue, Long costTime) {
        this.id = id;
        this.operateUser = operateUser;
        this.operateTime = operateTime;
        this.className = className;
        this.methodName = methodName;
        this.methodParams = methodParams;
        this.returnValue = returnValue;
        this.costTime = costTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(Integer operateUser) {
        this.operateUser = operateUser;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "OperateLog{" +
                "id=" + id +
                ", operateUser=" + operateUser +
                ", operateTime=" + operateTime +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodParams='" + methodParams + '\'' +
                ", returnValue='" + returnValue + '\'' +
                ", costTime=" + costTime +
                '}';
    }
}
