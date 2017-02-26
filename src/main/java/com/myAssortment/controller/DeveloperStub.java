package com.myAssortment.controller;

import com.myAssortment.model.Developer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeveloperStub {
    private static Map<Long, Developer> devs = new HashMap<Long, Developer>();
    private static Long idIndex = 3L;

    static {
        Developer a = new Developer(1L, "Benjamin West", "@benjamin_west");
        devs.put(1L, a);
        Developer b = new Developer(2L, "Jessica Smith", "@jessica_smith");
        devs.put(2L, b);
        Developer c = new Developer(3L, "Christopher West", "@christopher_west");
        devs.put(3L, c);
    }

    public static List<Developer> list(){
        return new ArrayList<Developer>(devs.values());
    }

    public static Developer create(Developer dev) {
        idIndex += idIndex;
        dev.setId(idIndex);
        devs.put(idIndex, dev);
        return dev;
    }

    public static Developer get(Long id) {
        return devs.get(id);
    }

    public static Developer update(Long id, Developer dev) {
        devs.put(id, dev);
        return dev;
    }

    public static Developer delete(Long id){
        return devs.remove(id);
    }
}


