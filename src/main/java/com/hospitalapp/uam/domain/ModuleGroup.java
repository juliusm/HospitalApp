package com.hospitalapp.uam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "TBL_MODULE_GROUP")
public class ModuleGroup implements Serializable, Comparable<ModuleGroup> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MODULE_GROUP_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "moduleGroup")
    private List<Module> modules;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        Collections.sort(modules);
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModuleGroup)) {
            return false;
        }

        ModuleGroup that = (ModuleGroup) o;

        if (modules != null ? !modules.equals(that.modules) : that.modules != null) {
            return false;
        }
        if (!name.equals(that.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (modules != null ? modules.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(ModuleGroup o) {
        return name.compareTo(o.getName());
    }
}
