package com.example.demo.Service;

import com.example.demo.Entity.EventEntity;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {




    private final EventRepository eventRepository;


    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
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
        EventEntity newEvent = new EventEntity();
        try{
            newEvent.setEventName(eventEntity.getEventName());
            newEvent.setEventDescription(eventEntity.getEventDescription());
            newEvent.setEventStarts(eventEntity.getEventStarts());
            newEvent.setEventEnds(eventEntity.getEventEnds());
            newEvent.setEventPicture(eventEntity.getEventPicture());
            newEvent.setOrganizer(eventEntity.getOrganizer());
        }catch (Exception e){
            return null;
        }finally {
            return this.eventRepository.save(newEvent);
        }
    }

    public List<EventEntity> getEvents(){
        return this.eventRepository.findAll();
    }



    public byte[] getEventPicture(int id){
        return this.eventRepository.findById(id).get().getEventPicture();
    }




}
