package com.hospitalapp.drugmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "TBL_DRUG_CATEGORY")
public class DrugCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DRUG_CATEGORY_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
