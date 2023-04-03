package com.example.demo.domain;

import javax.persistence.*;

@Entity(name = "t_comment")
public class Discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "a_id")
    private Integer aId;
    // 省略getXX()和setXX()方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

}

