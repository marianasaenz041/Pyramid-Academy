package com.project.netflixshows.dao;

import com.project.netflixshows.entity.Show;

import java.util.List;

public interface ShowDAO {
    List<Show> findAll();
    Object findById(int showId);
    void saveOrUpdate(Show theShow);
    void deleteById(int showId);
}
