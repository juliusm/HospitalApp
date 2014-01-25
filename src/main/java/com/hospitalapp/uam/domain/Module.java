package com.hospitalapp.uam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_MODULE")
public class Module implements Serializable, Comparable<Module> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MODULE_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "MODULE_GROUP_ID")
    private ModuleGroup moduleGroup;

    @OneToMany(mappedBy = "module")
    private Set<Link> links = new HashSet<Link>();

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

    public ModuleGroup getModuleGroup() {
        return moduleGroup;
    }

    public void setModuleGroup(ModuleGroup moduleGroup) {
        this.moduleGroup = moduleGroup;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Module)) {
            return false;
        }

        Module module = (Module) o;

        if (links != null ? !links.equals(module.links) : module.links != null) {
            return false;
        }
        if (moduleGroup != null ? !moduleGroup.equals(module.moduleGroup) : module.moduleGroup != null) {
            return false;
        }
        if (!name.equals(module.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (moduleGroup != null ? moduleGroup.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Module o) {
        return name.compareTo(o.getName());
    }
}
