package com.ly.jdbc.BasicDao_.dao_.domain;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 对应数据库 report 表的 JavaBean
 */
public class Report {
    private Integer id;//对应属性最好用包装好的
    private String name;
    private String course;
    private Integer score;

    //用于反射机制
    public Report() {
    }

    public Report(Integer id, String name, String course, Integer score) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
