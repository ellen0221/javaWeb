package com.javaweb.common;

import javax.json.JsonObject;
import java.util.List;

/**
 * @ClassName ResObj
 * @Description 封装返回给前端的信息
 * @Author JingXu
 * @Date 1/3/22 11:08 AM
 */
public class ResObj {

    // 错误码
    private int code;

    // 错误信息
    private String msg;

    // 列表格式数据
    private List<Object> dataList;

    // 通用格式数据
    private Object data;

    public ResObj() {
    }

    public ResObj(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResObj(int code, String msg, List<Object> dataList) {
        this.code = code;
        this.msg = msg;
        this.dataList = dataList;
    }

    public ResObj(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
