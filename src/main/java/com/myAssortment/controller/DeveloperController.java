package com.myAssortment.controller;

import com.myAssortment.model.Developer;
import com.myAssortment.model.DeveloperDao;
import com.myAssortment.model.DeveloperProcessor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class DeveloperController {

    public DeveloperController() {}

    public DeveloperProcessor developerProcessor;

    @Autowired
    public DeveloperController(DeveloperProcessor developerProcessor) {
        this.developerProcessor = developerProcessor;
    }

    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    public ResponseEntity findAll() throws Exception {
        ResponseEntity response = new ResponseEntity<>(developerProcessor.findAll(), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> createDeveloper(@RequestBody Developer developer, UriComponentsBuilder ucBuilder) throws Exception {
        System.out.println("Creating Developer " + developer.getName());

        developerProcessor.create(developer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/developer/{id}").buildAndExpand(developer.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Developer> getDeveloper(@PathVariable("id") long id)  throws Exception {
        System.out.println("Fetching User with id " + id);
        Developer developer = developerProcessor.findById(id);
        if (developer == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Developer>(developer, HttpStatus.OK);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Developer> update(@PathVariable("id") long id, @RequestBody Developer developer) throws Exception {
        System.out.println("Updating User " + id);

        Developer currentDeveloper = developerProcessor.findById(id);

        if (currentDeveloper == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
        }

        currentDeveloper.setName(developer.getName());
        currentDeveloper.setSlackName(developer.getSlackName());

        developerProcessor.update(currentDeveloper);
        return new ResponseEntity<Developer>(currentDeveloper, HttpStatus.OK);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Developer> delete(@PathVariable("id") long id) throws Exception{
        System.out.println("Fetching & Deleting user with id " + id);

        Developer developer = developerProcessor.findById(id);
        if (developer == null) {
            System.out.println("Unable to delete user with id " + id + ". They don't exist.");
            return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
        } else {
           developerProcessor.delete(id);
            return new ResponseEntity<Developer>(HttpStatus.NO_CONTENT);
        }
    }



}
