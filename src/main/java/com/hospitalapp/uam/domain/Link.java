package com.hospitalapp.uam.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LINK")
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LINK_ID")
    private long id;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "MODULE_ID")
    private Module module;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Link)) {
            return false;
        }

        Link link = (Link) o;

        if (!value.equals(link.value)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
