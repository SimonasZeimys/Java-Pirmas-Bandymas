/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByMovieName", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Movie.findByDirectorName", query = "SELECT m FROM Movie m WHERE m.directorName = :directorName"),
    @NamedQuery(name = "Movie.findByRating", query = "SELECT m FROM Movie m WHERE m.rating = :rating"),
    @NamedQuery(name = "Movie.findByOptLockVersion", query = "SELECT m FROM Movie m WHERE m.optLockVersion = :optLockVersion")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "MOVIE_NAME")
    private String movieName;           //Bussines Key
    @Size(max = 20)
    @Column(name = "DIRECTOR_NAME")
    private String directorName;
    @Size(max = 2)
    @Column(name = "RATING")
    private String rating;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinTable(name = "MOVIE_GENRE", joinColumns = {
        @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Genre> genreList;
    @JoinColumn(name = "CINEMA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cinema cinemaId;

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public Cinema getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Cinema cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieName != null ? movieName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieName == null && other.movieName != null) || (this.movieName != null && !this.movieName.equals(other.movieName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.Movie[ id=" + id + " ]";
    }
    
}
