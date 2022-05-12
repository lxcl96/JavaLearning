package com.ly.jdbc.DBUtils_;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : CaseTest对象和casetest表对应
 */
public class CaseTest {
    private Integer id;//对象最好用对象
    private String name;
    private String course;
    private Double score;

    public CaseTest() {
        //一定要给一个无参构造器 反射需要
    }

    public CaseTest(Integer id, String name, String course, Double score) {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CaseTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
