package com.ouyiku.bs.model.bean;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class LoginBean {
    private Status status;
    private Data data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Status{
        private String succeed;

        public String getSucceed() {
            return succeed;
        }

        public void setSucceed(String succeed) {
            this.succeed = succeed;
        }
    }
    public static class Data{
        private String user_id;
        private String news_id;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }
    }
}
