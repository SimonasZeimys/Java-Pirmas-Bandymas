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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "CINEMA")
@NamedQueries({
    @NamedQuery(name = "Cinema.findAll", query = "SELECT c FROM Cinema c"),
    @NamedQuery(name = "Cinema.findById", query = "SELECT c FROM Cinema c WHERE c.id = :id"),
    @NamedQuery(name = "Cinema.findByCinemaTitle", query = "SELECT c FROM Cinema c WHERE c.cinemaTitle = :cinemaTitle"),
    @NamedQuery(name = "Cinema.findByOptLockVersion", query = "SELECT c FROM Cinema c WHERE c.optLockVersion = :optLockVersion")})
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "CINEMA_TITLE")
    private String cinemaTitle;                     //Bussines Key
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @OneToMany(mappedBy = "cinemaId")
    private List<Movie> movieList;

    public Cinema() {
    }

    public Cinema(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCinemaTitle() {
        return cinemaTitle;
    }

    public void setCinemaTitle(String cinemaTitle) {
        this.cinemaTitle = cinemaTitle;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cinemaTitle != null ? cinemaTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinema)) {
            return false;
        }
        Cinema other = (Cinema) object;
        if ((this.cinemaTitle == null && other.cinemaTitle != null) || (this.cinemaTitle != null && !this.cinemaTitle.equals(other.cinemaTitle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.Cinema[ id=" + id + " ]";
    }
    
}
