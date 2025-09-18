package com.tanko.app.entry;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "people")

public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String nickname;

    @Temporal(TemporalType.DATE) // Только дата (без времени)
    private Date birthday;

    public People(String name, String nickname, Date birthday) {
        this.name = name;
        this.nickname = nickname;
        this.birthday  = birthday;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People(" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", nickname=" + nickname +
                ", birthday=" + birthday +
                ')';
    }

}
