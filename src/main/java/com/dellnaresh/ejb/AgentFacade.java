/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dellnaresh.ejb;

import com.dellnaresh.model.Agent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nareshm
 */
@Stateless
public class AgentFacade extends AbstractFacade<Agent> {
    @PersistenceContext(unitName = "com.mycompany_WebApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentFacade() {
        super(Agent.class);
    }
    
}
