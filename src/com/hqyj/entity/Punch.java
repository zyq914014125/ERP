package com.hqyj.entity;

//打卡
public class Punch {
    private  int pickId;
    private  int userId;
    private String name;
    private String time;

    @Override
    public String toString() {
    return "{" +"'"+
            "pickId'"+":" +pickId +
            ", 'userId'"+":" + userId+
            ", 'name'"+":'" +name +
            "', 'time'"+":'"+ time + '\'' +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPickId() {
        return pickId;
    }

    public void setPickId(int pickId) {
        this.pickId = pickId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
      this.time=time;
    }
}
