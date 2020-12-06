package com.bjpowernode;

import lombok.Data;

/**
 * @author 侯旭东
 * @version 1.0
 * @date 2020/12/5 20:41
 */
@Data
public class PageInfo {
    //总数据条数
    private Integer totalRows;
    //总数据页数
    private Integer pageNo;
    //每页数据条数
    private Integer pageSize;
    //总页数
    private Integer totalPages;

    public Integer getTotalPages() {
        //计算总页数
        if( totalRows > 0 && pageSize > 0 ){
            totalPages = totalRows % pageSize;
            if( totalPages > 0 ){
                totalPages = (totalRows / pageSize) + 1;
            } else {
                totalPages = (totalRows / pageSize);
            }
        }
        return totalPages;
    }
}
