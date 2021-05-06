package kz.csse.baskino.react.baskino.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name= "picURL",length = 450)
    private String picURL;

    @Column(name= "imdb")
    private double imdb;

    @Temporal(TemporalType.DATE)
    @Column(name= "addedDate",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date addedDate;

    @Column(name="year")
    private String year;

    @Column(name="sbor")
    private String sbor;

    @Column(name="rashod")
    private String rashod;

    @Temporal(TemporalType.DATE)
    @Column(name= "createdDate",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genres> genresList;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Actors> actorsList;
}
