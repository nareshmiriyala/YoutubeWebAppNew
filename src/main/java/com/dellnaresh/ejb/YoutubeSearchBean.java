/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dellnaresh.ejb;

import com.dellnaresh.model.Movies;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nareshm
 */
@Stateless
public class YoutubeSearchBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    MoviesFacade moviesFacade;
   

    public  Map<String,String> getMovies(String movieName) {
 com.youtube.indianmovies.data.Search search=new com.youtube.indianmovies.data.Search();
   List<SearchResult> searchResultList =search.getMoviesList(movieName);
       Map<String,String> moviesMap=new HashMap<>();
        for(SearchResult singleVideo:searchResultList){
            ResourceId rId = singleVideo.getId();
             Movies movies=new Movies();
             // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
                
                System.out.println(" Video Id" + rId.getVideoId());
                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                movies.setMovieTtitle(singleVideo.getSnippet().getTitle());
                System.out.println(" Thumbnail: " + thumbnail.getUrl());
                 movies.setUrl(thumbnail.getUrl());
               movies.setId(rId.getVideoId());
                System.out.println("\n-------------------------------------------------------------\n");
                moviesFacade.create(movies);
                moviesMap.put(rId.getVideoId(), thumbnail.getUrl());
            }
        }
        
        return moviesMap;
    }
    
    
}
