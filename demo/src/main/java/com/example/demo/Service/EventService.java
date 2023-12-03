package com.example.demo.Service;

import com.example.demo.Entity.EventEntity;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Repository.UserRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {




    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository){
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    public EventEntity makeEvent(EventEntity eventEntity){
        return this.eventRepository.save(eventEntity);
    }

    public String deleteEvent(int id){
        if(this.eventRepository.existsById(id)){
            this.eventRepository.deleteById(id);
            return "Event has been deleted";
        }
        return "Event not found!";
    }







    public EventEntity updateEvent(int id, EventEntity eventEntity){
        EventEntity newEvent = this.eventRepository.findById(id).orElse(null);


        if (eventEntity.getEventName() != null && !eventEntity.getEventName().isEmpty()) {
            newEvent.setEventName(eventEntity.getEventName());
        }

        if (eventEntity.getEventDescription() != null && !eventEntity.getEventDescription().isEmpty()) {
            newEvent.setEventDescription(eventEntity.getEventDescription());
        }

        if (eventEntity.getEventStarts() != null) {
            newEvent.setEventStarts(eventEntity.getEventStarts());
        }

        if (eventEntity.getEventEnds() != null) {
            newEvent.setEventEnds(eventEntity.getEventEnds());
        }

        if(eventEntity.getLocation() != null && !eventEntity.getLocation().isEmpty()){
            newEvent.setLocation(eventEntity.getLocation());
        }


        if (eventEntity.getEventPicture() != null && eventEntity.getEventPicture().length > 0) {
            newEvent.setEventPicture(eventEntity.getEventPicture());
        }

        return this.eventRepository.save(newEvent);


    }


    public List<EventEntity> getEvents(){
        return this.eventRepository.findAll();
    }



    public byte[] getEventPicture(int id){
        return this.eventRepository.findById(id).get().getEventPicture();
    }

    public EventEntity getEventById(int id){
        return this.eventRepository.findById(id).get();
    }






}
