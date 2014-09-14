/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dellnaresh.view;

import com.dellnaresh.ejb.YoutubeSearchBean;
import com.google.api.services.youtube.model.SearchResult;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nareshm
 */
@Named(value = "youtubeSearch")
@RequestScoped
public class YoutubeSearch {

     @EJB
     YoutubeSearchBean youtubeSearch;
     @NotNull
     @Size(min=2,max=5600)
     String moviename;
     Map<String,String> moviesMap;

    public Map<String, String> getMoviesMap() {
        return moviesMap;
    }

    public void setMoviesMap(Map<String, String> moviesMap) {
        this.moviesMap = moviesMap;
    }
    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    /**
     * Creates a new instance of YoutubeSearch
     */
    public YoutubeSearch() {
    }
    public void doSearch(){
        
    moviesMap=  youtubeSearch.getMovies(moviename);
    }
}
