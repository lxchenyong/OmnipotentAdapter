package com.chenyong.jeff.omnipotentadapter.bean;

/**
 * Bean
 * Created by chenyong on 2016/8/15.
 */
public class Bean {
    private String title;
    private String content;
    private boolean isChecked;

    public Bean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
