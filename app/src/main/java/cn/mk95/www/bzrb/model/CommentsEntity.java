package cn.mk95.www.bzrb.model;

import java.util.List;

/**
 * Created by 睡意朦胧 on 2017/6/9.
 */

public class CommentsEntity {
    private List<comment> hottest;
    private List<comment> latest;

    public List<comment> getHottest() {
        return hottest;
    }

    public void setHottest(List<comment> hottest) {
        this.hottest = hottest;
    }

    public List<comment> getLatest() {
        return latest;
    }

    public void setLatest(List<comment> latest) {
        this.latest = latest;
    }

    public class comment{
        private String id;
        private String content;
        private String readable_time;
        private String likes;
        private String dislikes;
        private String time;
        private String score;
        private String own;
        private String like;
        private String dislike;
        private boolean hottest;
        private user user;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getReadable_time() {
            return readable_time;
        }

        public void setReadable_time(String readable_time) {
            this.readable_time = readable_time;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public String getDislikes() {
            return dislikes;
        }

        public void setDislikes(String dislikes) {
            this.dislikes = dislikes;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getOwn() {
            return own;
        }

        public void setOwn(String own) {
            this.own = own;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getDislike() {
            return dislike;
        }

        public void setDislike(String dislike) {
            this.dislike = dislike;
        }

        public boolean isHottest() {
            return hottest;
        }

        public void setHottest(boolean hottest) {
            this.hottest = hottest;
        }

        public comment.user getUser() {
            return user;
        }

        public void setUser(comment.user user) {
            this.user = user;
        }

        public class user{
            private String id;
            private String name;
            private String real_avatar_url;
        }
    }
}
