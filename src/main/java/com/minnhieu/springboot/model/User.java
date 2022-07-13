package com.minnhieu.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends AbstractPersistable<Long> {
    //Dùng AbstractPersistable để khỏi thêm khóa chính, tự động gạch dưới với chữ viết hoa
    private transient Long id;
    private String userId;
    private String userName;
    private String password;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @JsonIgnore
    @OneToMany(targetEntity = Address.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;
}
