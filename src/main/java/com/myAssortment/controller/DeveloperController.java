package com.myAssortment.controller;

import com.myAssortment.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeveloperController {

    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    public List<Developer> list() {
        return DeveloperStub.list();
    }

    @RequestMapping(value = "/developers", method = RequestMethod.POST)
    public Developer create(@RequestBody Developer developer) {
        return DeveloperStub.create(developer);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.GET)
    public Developer get(@PathVariable Long id) {
        return DeveloperStub.get(id);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.PUT)
    public Developer update(@PathVariable Long id, @RequestBody Developer developer) {
        return DeveloperStub.update(id, developer);
    }

    @RequestMapping(value = "/developers/{id}", method = RequestMethod.DELETE)
    public Developer delete(@PathVariable Long id){
        return DeveloperStub.delete(id);
    }

}
