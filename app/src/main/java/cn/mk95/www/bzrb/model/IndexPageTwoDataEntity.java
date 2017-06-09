package cn.mk95.www.bzrb.model;

import java.util.List;

/**
 * Created by 11149 on 2017/6/9.
 */

public class IndexPageTwoDataEntity {
    private List<IndexPageTwoModel> data;
    private String timestamp;

    public List<IndexPageTwoModel> getData() {
        return data;
    }

    public void setData(List<IndexPageTwoModel> data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
