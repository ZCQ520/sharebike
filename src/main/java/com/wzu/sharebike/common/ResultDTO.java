package com.wzu.sharebike.common;

import com.wzu.sharebike.common.emum.ResultCode;
import com.wzu.sharebike.common.mybatis.PagingResult;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jack on 2017/10/18.
 */
public class ResultDTO<T> {
    @ApiModelProperty(value = "状态 (404:失败 200:成功)", dataType = "int", required = true)
    private int code;

    @ApiModelProperty(value = "状态消息", dataType = "String", required = true)
    private String message;

    @ApiModelProperty(value = "返回数据", required = false)
    private Object data;

    @ApiModelProperty(value = "页码", required = false)
    private Integer currentPage;
    @ApiModelProperty(value = "总条数", required = false)
    private Long totalSize;
    @ApiModelProperty(value = "总页码", required = false)
    private Integer totalPage;
    @ApiModelProperty(value = "获取分页时间", required = false)
    private Long accessTime;

    public ResultDTO() {
    }

    public ResultDTO(Object data) {
        this.data = data;
    }

    public ResultDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultDTO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDTO code(int code) {
        this.code = code;
        this.message = ResultCode.findMessageByCode(code);
        return this;
    }

    public ResultDTO message(String message) {
        this.message = message;
        return this;
    }

    public ResultDTO data(Object data) {
        this.data = data;
        return this;
    }

    public ResultDTO(boolean result) {
        if (result) {
            this.code = ResultCode.CODE_200.code;
            this.message = ResultCode.CODE_200.msg;
        } else {
            this.code = ResultCode.CODE_401.code;
            this.message = ResultCode.CODE_401.msg;
        }
    }

    public ResultDTO page(int currentPage, long totalSize, int totalPage, Long accessTime) {
        this.currentPage = currentPage;
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.accessTime = accessTime;
        return this;
    }

    public ResultDTO page(PagingResult pagingResult) {
        this.currentPage = pagingResult.getCurrentPage();
        this.totalSize = pagingResult.getTotalSize();
        this.totalPage = pagingResult.getTotalPage();
        this.data = pagingResult.getResultList();
        this.accessTime = pagingResult.getAccessTime();
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }
}
