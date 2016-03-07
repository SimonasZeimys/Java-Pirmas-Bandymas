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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "GENRE")
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findById", query = "SELECT g FROM Genre g WHERE g.id = :id"),
    @NamedQuery(name = "Genre.findByGenreName", query = "SELECT g FROM Genre g WHERE g.genreName = :genreName"),
    @NamedQuery(name = "Genre.findByOptLockVersion", query = "SELECT g FROM Genre g WHERE g.optLockVersion = :optLockVersion")})
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "GENRE_NAME")
    private String genreName;                   //Bussines Key
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;

    public Genre() {
    }

    public Genre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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
        hash += (genreName != null ? genreName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.genreName == null && other.genreName != null) || (this.genreName != null && !this.genreName.equals(other.genreName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.Genre[ id=" + id + " ]";
    }
    
}
