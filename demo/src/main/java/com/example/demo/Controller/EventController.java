package com.example.demo.Controller;


import com.example.demo.Entity.EventEntity;
import com.example.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
@CrossOrigin(origins = "*")
public class EventController {


    private final EventService eventService;


    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }



    @PostMapping("makeEvent")
    public EventEntity makeEvent(@RequestBody EventEntity eventEntity){
        return this.eventService.makeEvent(eventEntity);
    }


    @PutMapping("updateEvent/")
    public EventEntity updateEvent(@RequestParam("id") int id, @RequestBody EventEntity eventEntity){
        return this.eventService.updateEvent(id,eventEntity);
    }

    @DeleteMapping("deleteEvent/{id}")
    public String deleteEvent(@PathVariable int id){
        return this.eventService.deleteEvent(id);
    }

    @GetMapping("getAllEvents")
    public List<EventEntity> getEvents(){
        return this.eventService.getEvents();
    }



    @GetMapping("getEventById/")
    public EventEntity getEventById(int id){
        return this.eventService.getEventById(id);
    }




    @GetMapping("getEventPicture/")
    public byte[] getEventPictureById(@RequestParam int id){
        return this.eventService.getEventPicture(id);
    }



}

