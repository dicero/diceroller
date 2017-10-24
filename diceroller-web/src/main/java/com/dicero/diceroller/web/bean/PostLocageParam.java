package com.dicero.diceroller.web.bean;


import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by kdlbj__ on 16/10/11.
 */
@ApiModel
public class PostLocageParam implements Serializable {

    private static final long serialVersionUID = -7319586530052819261L;

    
    private long posterId;

    private String content;

    private int longitude;

    private int latitude;

    private int altitude;

    public long getPosterId() {
        return posterId;
    }

    public void setPosterId(long posterId) {
        this.posterId = posterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "PostLocageParam{" +
                "posterId=" + posterId +
                ", content='" + content + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                '}';
    }
}
