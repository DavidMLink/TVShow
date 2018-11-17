package com.codingdojo.templatelogreg.controller;

import java.util.List;

import com.codingdojo.templatelogreg.model.Show;
import com.codingdojo.templatelogreg.service.ShowService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowCRUD {
    private final ShowService showService;
    public ShowCRUD(ShowService showService){
        this.showService = showService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/shows", method=RequestMethod.POST)
            public Show create(@RequestParam(value="title") String title, @RequestParam(value="network") String network, @RequestParam(value="rating") Double rating) { 
                Show show = new Show( title, network, rating ); 
                return showService.createShow(show); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/shows/{id}") 
            public Show show(@PathVariable("id") Long id) { 
                Show show = showService.findShow(id); 
                return show; 
            } 
            // All Tables 
            @RequestMapping("/api/shows") 
            public List<Show> index() { 
                return showService.allShows(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/shows/{id}", method=RequestMethod.PUT) 
            public Show update(@PathVariable("id") Long id, @RequestParam(value="title") String title,  @RequestParam(value="network") String network,  @RequestParam(value="rating") Double rating) { 
                Show show = new Show(id, title, network, rating ); 
                Show showUpdated = showService.updateShow(show); 
                return showUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/shows/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                showService.deleteShow(id); 
            } 
    // END OF CRUD 
} 
