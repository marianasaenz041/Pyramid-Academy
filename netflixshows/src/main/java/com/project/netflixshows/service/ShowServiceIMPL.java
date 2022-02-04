package com.project.netflixshows.service;

import com.project.netflixshows.dao.ShowDAO;
import com.project.netflixshows.entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceIMPL implements ShowService {

    private final ShowDAO showDAO;

    @Autowired
    public ShowServiceIMPL(ShowDAO showDAO){
        this.showDAO = showDAO;
    }

    @Override
    public List<Show> findAll() {return showDAO.findAll();}

    @Override
    public Object findById(int showId) {return showDAO.findById(showId);}

    @Override
    public void saveOrUpdate(Show theShow) {showDAO.saveOrUpdate(theShow);}

    @Override
    public void deleteById(int showId) {showDAO.deleteById(showId);}


}
