package cn.mk95.www.bzrb.model;

import java.util.List;

/**
 * Created by 11149 on 2017/6/7.
 */

public class IndexPageOneDataEntity {
    private List<IndexDocumentModel> top_stories;
    private List<IndexDocumentModel> data;
    private String timestamp;

    public List<IndexDocumentModel> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<IndexDocumentModel> top_stories) {
        this.top_stories = top_stories;
    }

    public List<IndexDocumentModel> getData() {
        return data;
    }

    public void setData(List<IndexDocumentModel> data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
