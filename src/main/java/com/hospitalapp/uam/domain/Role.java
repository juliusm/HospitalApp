package com.hospitalapp.uam.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_ROLE")
public class Role implements GrantedAuthority, Serializable, Comparable<Role> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<User>();

    @ManyToMany
    @JoinTable(name = "ROLE_MODULE",
            joinColumns = {@JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MODULE_ID")})
    private Set<Module> modules = new HashSet<Module>();


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String getAuthority() {
        return "ROLE_"+name.replace(' ', '_').toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        Role role = (Role) o;

        if (modules != null ? !modules.equals(role.modules) : role.modules != null) {
            return false;
        }
        if (!name.equals(role.name)) {
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
    public int compareTo(Role o) {
        return name.compareTo(o.getName());
    }
}
