package com.wzu.sharebike.common.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 * @date 2017/10/17   18:22
 * 分类结果实体
 */
public class PagingResult<T> implements Serializable {
    //当前页
    private int currentPage;
    //总共记录条数
    private long totalSize;
    //总共页数
    private int totalPage;
    //结果集
    private List<T> resultList = new ArrayList<T>();
    //本次返回数据页前一个数据的order
    private Integer preOrder;
    //本次返回数据页后一个数据的order
    private Integer postOrder;

    private Long accessTime;

    public PagingResult() {
    }

    public PagingResult(int currentPage, long totalSize, int totalPage, List<T> resultList, Long accessTime) {
        this.currentPage = currentPage;
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.resultList = resultList;
        this.accessTime = accessTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }

    public Integer getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Integer preOrder) {
        this.preOrder = preOrder;
    }

    public Integer getPostOrder() {
        return postOrder;
    }

    public void setPostOrder(Integer postOrder) {
        this.postOrder = postOrder;
    }

    public static PagingResult emptyPage(long accessTime) {
        PagingResult pagingResult = new PagingResult();
        pagingResult.setAccessTime(accessTime);
        pagingResult.setResultList(Collections.emptyList());
        return pagingResult;
    }
}