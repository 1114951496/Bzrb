package cn.mk95.www.bzrb.model;

import java.util.List;

/**
 * Created by 11149 on 2017/6/9.
 */

public class IndexPageTwoModel {
    private String document_id;
    private String display_type;
    private String title;
    private String comment_count;
    private String vote_count;
    private String contribute;
    private String timestamp;
    private String url;
    private String source_name;
    private String hit_count;
    private String hit_count_string;
    private String publish_time;
    private String published_at;
    private List<Recommenders> recommenders;
    private String thumbnail;
    private String author_id;
    private String author_name;
    private String author_avatar;

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getContribute() {
        return contribute;
    }

    public void setContribute(String contribute) {
        this.contribute = contribute;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getHit_count() {
        return hit_count;
    }

    public void setHit_count(String hit_count) {
        this.hit_count = hit_count;
    }

    public String getHit_count_string() {
        return hit_count_string;
    }

    public void setHit_count_string(String hit_count_string) {
        this.hit_count_string = hit_count_string;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public List<Recommenders> getRecommenders() {
        return recommenders;
    }

    public void setRecommenders(List<Recommenders> recommenders) {
        this.recommenders = recommenders;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public class Recommenders{
        private String id;
        private String name;
        private String avatar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "Recommenders{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IndexPageTwoModel{" +
                "document_id='" + document_id + '\'' +
                ", display_type='" + display_type + '\'' +
                ", title='" + title + '\'' +
                ", comment_count='" + comment_count + '\'' +
                ", vote_count='" + vote_count + '\'' +
                ", contribute='" + contribute + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", url='" + url + '\'' +
                ", source_name='" + source_name + '\'' +
                ", hit_count='" + hit_count + '\'' +
                ", hit_count_string='" + hit_count_string + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", published_at='" + published_at + '\'' +
                ", recommenders=" + recommenders.toString() +
                ", thumbnail='" + thumbnail + '\'' +
                ", author_id='" + author_id + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_avatar='" + author_avatar + '\'' +
                '}';
    }
}
