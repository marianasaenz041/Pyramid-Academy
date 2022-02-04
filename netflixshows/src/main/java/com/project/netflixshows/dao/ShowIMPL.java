package com.project.netflixshows.dao;

import com.project.netflixshows.entity.Show;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ShowIMPL implements ShowDAO{

    private final EntityManager entityManager;

    @Autowired
    public ShowIMPL(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    @Transactional
    public List<Show> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Show> myQuery = currentSession.createQuery("from Show");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Show findById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Show.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Show theShow) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theShow);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Show myShow = currentSession.get(Show.class, theId);
        currentSession.delete(myShow);
    }
}
