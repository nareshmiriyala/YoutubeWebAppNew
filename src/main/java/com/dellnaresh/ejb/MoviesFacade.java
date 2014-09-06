/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dellnaresh.ejb;

import com.dellnaresh.model.Movies;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nareshm
 */
@Stateless
public class MoviesFacade extends AbstractFacade<Movies> {

    @PersistenceContext(unitName = "com.mycompany_WebApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public MoviesFacade() {
        super(Movies.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
