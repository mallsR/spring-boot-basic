package com.xiaor.pojo;

import java.util.List;

/**
 * 分页查询结果封装类
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PageBean {
    private long total;     // 总记录数
    private List rows;

    public PageBean() {
    }

    public PageBean(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public List getRows() {
        return rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
