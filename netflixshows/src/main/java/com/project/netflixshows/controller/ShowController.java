package com.project.netflixshows.controller;

import com.project.netflixshows.entity.Show;
import com.project.netflixshows.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class ShowController {
    private final ShowService showService;

    @Autowired
    public ShowController(@Qualifier("showServiceImpl")ShowService showService){
        this.showService = showService;
    }
    //This is a GET request that will read a list of all the employees.

    //http://localhost:8080/retrieveAllShows
    @GetMapping("/retrieveAllShows")
    public List<Show> findAll(){return showService.findAll();}


    //This is a POST request to add a new employee.
    //http://localhost:8080/addShow
    @PostMapping("/addShow")
    public Show addShow(@RequestBody Show theShow) {
        theShow.setId(0);
        showService.saveOrUpdate(theShow);
        return theShow;
    }

    //This is a PUT request to update an existing employee.
    //http://localhost:8080/updateShow
    @PutMapping("/updateShow")
    public Show updateShow(@RequestBody Show updateShow) {
        //Notice theEmployee.setId(0); this will execute an update instead of a create
        showService.saveOrUpdate(updateShow);
        return updateShow;
    }
    //This is a DELETE request to delete an existing employee.
    //http://localhost:8080/deleteShow/1
    @DeleteMapping("/deleteShow/{showId}")
    public String deleteShow(@PathVariable int showId) {
        //This will execute the deleteByID.
        showService.deleteById(showId);
        return "Deleted show id : " + showId;
    }


}
