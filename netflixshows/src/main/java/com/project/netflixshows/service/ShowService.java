package com.project.netflixshows.service;

import com.project.netflixshows.entity.Show;

import java.util.List;

public interface ShowService {
    List<Show> findAll();
    Object findById(int showId);
    void saveOrUpdate(Show theShow);
    void deleteById(int showId);
}
