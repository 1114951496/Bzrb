package cn.mk95.www.bzrb.model;

/**
 * Created by 11149 on 2017/6/7.
 */

public class IndexDocumentModel {
    private String document_id;
    private String display_type;
    private String position;
    private String thumbnail;
    private String author_avatar;
    private String author_name;
    private String author_id;
    private String section_id;
    private String title;
    private String image;
    private String url;
    private String share_url;
    private String hit_count;
    private String section_name;
    private String section_image;
    private String section_color;
    private String hit_count_string;
    private String timestamp;
    private String comment_count;
    private String vote_count;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getHit_count() {
        return hit_count;
    }

    public void setHit_count(String hit_count) {
        this.hit_count = hit_count;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_image() {
        return section_image;
    }

    public void setSection_image(String section_image) {
        this.section_image = section_image;
    }

    public String getSection_color() {
        return section_color;
    }

    public void setSection_color(String section_color) {
        this.section_color = section_color;
    }

    public String getHit_count_string() {
        return hit_count_string;
    }

    public void setHit_count_string(String hit_count_string) {
        this.hit_count_string = hit_count_string;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "IndexDocumentModel{" +
                "document_id='" + document_id + '\'' +
                ", display_type='" + display_type + '\'' +
                ", position='" + position + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", author_avatar='" + author_avatar + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_id='" + author_id + '\'' +
                ", section_id='" + section_id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", share_url='" + share_url + '\'' +
                ", hit_count='" + hit_count + '\'' +
                ", section_name='" + section_name + '\'' +
                ", section_image='" + section_image + '\'' +
                ", section_color='" + section_color + '\'' +
                ", hit_count_string='" + hit_count_string + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", comment_count='" + comment_count + '\'' +
                ", vote_count='" + vote_count + '\'' +
                '}';
    }
}
