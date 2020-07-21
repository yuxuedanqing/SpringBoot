package com.snails.ehcache.controller;

import com.snails.ehcache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/getPerson/{name}")
    @ResponseBody
    public String getPerson(@PathVariable("name") String name){
        return personService.getPerson(name).toString();
    }
}
