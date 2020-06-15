package com.news.eijun.api.model;

public class ModelNews {
    private String title ;
    private String pulishedAt;
    private String url ;
    private String urlToImage ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPulishedAt() {
        return pulishedAt;
    }

    public void setPulishedAt(String pulishedAt) {
        this.pulishedAt = pulishedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
