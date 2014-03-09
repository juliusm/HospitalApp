package com.hospitalapp.drugmanager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_DRUG")
public class Drug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DRUG_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DRUG_CATEGORY_ID")
    private DrugCategory category;

    @Column(name = "STATUS")
    private String status;

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

    public DrugCategory getCategory() {
        return category;
    }

    public void setCategory(DrugCategory category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
