/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookborrowing;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author PCC
 */
@Entity
@Table(name = "books", catalog = "library", schema = "")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByBId", query = "SELECT b FROM Books b WHERE b.bId = :bId"),
    @NamedQuery(name = "Books.findByBTitle", query = "SELECT b FROM Books b WHERE b.bTitle = :bTitle"),
    @NamedQuery(name = "Books.findByAuther", query = "SELECT b FROM Books b WHERE b.auther = :auther"),
    @NamedQuery(name = "Books.findByDescription", query = "SELECT b FROM Books b WHERE b.description = :description"),
    @NamedQuery(name = "Books.findByGenre", query = "SELECT b FROM Books b WHERE b.genre = :genre"),
    @NamedQuery(name = "Books.findByStatus", query = "SELECT b FROM Books b WHERE b.status = :status"),
    @NamedQuery(name = "Books.findByUid", query = "SELECT b FROM Books b WHERE b.uid = :uid")})
public class Books implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "b_id")
    private Integer bId;
    @Basic(optional = false)
    @Column(name = "b_title")
    private String bTitle;
    @Basic(optional = false)
    @Column(name = "auther")
    private String auther;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "uid")
    private Integer uid;

    public Books() {
    }

    public Books(Integer bId) {
        this.bId = bId;
    }

    public Books(Integer bId, String bTitle, String auther, String description, String genre, String status) {
        this.bId = bId;
        this.bTitle = bTitle;
        this.auther = auther;
        this.description = description;
        this.genre = genre;
        this.status = status;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        Integer oldBId = this.bId;
        this.bId = bId;
        changeSupport.firePropertyChange("BId", oldBId, bId);
    }

    public String getBTitle() {
        return bTitle;
    }

    public void setBTitle(String bTitle) {
        String oldBTitle = this.bTitle;
        this.bTitle = bTitle;
        changeSupport.firePropertyChange("BTitle", oldBTitle, bTitle);
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        String oldAuther = this.auther;
        this.auther = auther;
        changeSupport.firePropertyChange("auther", oldAuther, auther);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        Integer oldUid = this.uid;
        this.uid = uid;
        changeSupport.firePropertyChange("uid", oldUid, uid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookborrowing.Books[ bId=" + bId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
