/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dellnaresh.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.jpa.jpql.tools.model.query.DerivedPathIdentificationVariableDeclarationStateObject;

/**
 *
 * @author nareshm
 */
@Entity
public class Movies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @NotNull
    String movieTtitle;
     
    @NotNull
   @Column(unique=true)
    String url;
     
    
    public String getMovieTtitle() {
        return movieTtitle;
    }

    public void setMovieTtitle(String movieTtitle) {
        this.movieTtitle = movieTtitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.dellnaresh.model.YoutubeData[ id=" + id + " ]";
    }
    
}
