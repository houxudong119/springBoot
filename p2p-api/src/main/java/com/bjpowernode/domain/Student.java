package com.bjpowernode.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 7727397512364833059L;
    private String id;

    private String name;

    private String sex;

    private String brith;

    private Integer classno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBrith() {
        return brith;
    }

    public void setBrith(String brith) {
        this.brith = brith == null ? null : brith.trim();
    }

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }
}