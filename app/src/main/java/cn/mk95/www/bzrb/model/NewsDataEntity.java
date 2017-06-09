package cn.mk95.www.bzrb.model;

import java.util.List;

/**
 * Created by 睡意朦胧 on 2017/6/8.
 */

public class NewsDataEntity {
    private String document_id;
    private String display_type;
    private String title;
    private String image;
    private String video_file_url;
    private String thumbnail;
    private String author_avatar;
    private String author_name;
    private String share_image;
    private String key_words;
    private String video_image_url;
    private String section_id;
    private String display_date;
    private String ga_prefix;
    private String vote_count;
    private String share_url;
    private String url;
    private String comment_count;//点击
    private String hit_count;//点赞
    private String hit_count_string;
    private String body;
    private String tag;
    private String tag_text;
    private String guide;
    private String guide_image;
    private String timestamp;
    private String author_summary;
    private String section_name;
    private String section_image;
    private String section_color;
    private List<channels> channels;
    private String head;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo_file_url() {
        return video_file_url;
    }

    public void setVideo_file_url(String video_file_url) {
        this.video_file_url = video_file_url;
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

    public String getShare_image() {
        return share_image;
    }

    public void setShare_image(String share_image) {
        this.share_image = share_image;
    }

    public String getKey_words() {
        return key_words;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }

    public String getVideo_image_url() {
        return video_image_url;
    }

    public void setVideo_image_url(String video_image_url) {
        this.video_image_url = video_image_url;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getDisplay_date() {
        return display_date;
    }

    public void setDisplay_date(String display_date) {
        this.display_date = display_date;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag_text() {
        return tag_text;
    }

    public void setTag_text(String tag_text) {
        this.tag_text = tag_text;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getGuide_image() {
        return guide_image;
    }

    public void setGuide_image(String guide_image) {
        this.guide_image = guide_image;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthor_summary() {
        return author_summary;
    }

    public void setAuthor_summary(String author_summary) {
        this.author_summary = author_summary;
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

    public List<NewsDataEntity.channels> getChannels() {
        return channels;
    }

    public void setChannels(List<NewsDataEntity.channels> channels) {
        this.channels = channels;
    }

    public class channels{
        private String id;
        private String name;
        private String summary;
        private String thumbnail;
        private String image;

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

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
        @Override
        public String toString(){
            return "channels:[id=]"+id+",name="+name+",summary="+summary
                    +",thumbnail="+thumbnail+",image="+image;
        }
    }

    @Override
    public String toString(){
        return "channels"+channels;
    }
}
