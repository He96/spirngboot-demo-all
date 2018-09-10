package com.util;

import java.io.Serializable;

public class ListResult<T> extends Result implements Serializable {
    private int total;
    private  T rows;

    public ListResult(int total, T rows) {
        super(1,"ok");
        this.total = total;
        this.rows = rows;
    }

    public ListResult(int code,String msg, T rows) {
        super(code,msg);
        this.rows = rows;
    }

    public ListResult(int code, String msg, int total, T rows) {
        super(code, msg);
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}
