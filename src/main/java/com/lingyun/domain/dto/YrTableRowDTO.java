package com.lingyun.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YrTableRowDTO  implements Serializable {

    private String val;

    private Integer line;

    private List<String> headers=new ArrayList<>();

    private List<Map> data=new ArrayList<>();

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {

        if(headers!=null){
            boolean flag=true;
            for (String header : headers) {
                if("$序号".equals(header)){
                    flag=false;
                }
            }
            if (flag){
                headers.add(0,"$序号");
            }
            headers.add("操作");
        }
        this.headers = headers;
    }

    public List<Map> getData() {
        return data;
    }

    public void setData(List<Map> data) {
        this.data = data;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "YrTableRowDTO{" +
                "val='" + val + '\'' +
                ", line=" + line +
                ", headers=" + headers +
                ", data=" + data +
                '}';
    }
}
