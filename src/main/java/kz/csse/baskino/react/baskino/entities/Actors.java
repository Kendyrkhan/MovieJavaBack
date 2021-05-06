package kz.csse.baskino.react.baskino.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_actors")
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="biography",length = 2000)
    private String biography;

    @Temporal(TemporalType.DATE)
    @Column(name= "birthday")
    private Date birthday;

    @Column(name="avatar")
    private String avatar;


}
