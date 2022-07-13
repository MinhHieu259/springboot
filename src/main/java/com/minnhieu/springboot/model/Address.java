package com.minnhieu.springboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Address extends AbstractPersistable<Long> {
    private transient Long id;
    private String city;
    private String state;
    private String country;
    private transient Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
