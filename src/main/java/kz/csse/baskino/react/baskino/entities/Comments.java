package kz.csse.baskino.react.baskino.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_comments")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name= "comment",length = 400)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "addedDate",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date addedDate;


    @ManyToOne(fetch = FetchType.LAZY)
    private Movies movies;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users author;


}
