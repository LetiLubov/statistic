package com.spring.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date birthday;
    private Date firstWorkDay;

    public Employee(Date birthday, Date firstWorkDay) {
        this.birthday = birthday;
        this.firstWorkDay = firstWorkDay;
    }
}
