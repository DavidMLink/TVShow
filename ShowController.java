package com.codingdojo.templatelogreg.controller;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.templatelogreg.model.Show;
import com.codingdojo.templatelogreg.service.ShowService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowController {
    private final ShowService showService;
    
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    // Start Here

}