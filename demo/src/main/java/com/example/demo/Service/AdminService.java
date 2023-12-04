package com.example.demo.Service;


import com.example.demo.Entity.EventEntity;
import com.example.demo.Entity.EventHandlerEntity;
import com.example.demo.Repository.EventHandlerRepository;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Repository.UserRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {




    private final EventHandlerService eventHandlerService;
    private final EventHandlerRepository eventHandlerRepository;

    private final EventRepository eventRepository;



    @Autowired
    public AdminService( EventHandlerRepository eventHandlerRepository, EventRepository eventRepository,EventHandlerService eventHandlerService){
        this.eventHandlerRepository = eventHandlerRepository;
        this.eventRepository = eventRepository;
        this.eventHandlerService = eventHandlerService;
    }



    public int getAttendanceCount(int eventId){
        int count = 0;

        if(this.eventRepository.existsById(eventId)){

            List<EventHandlerEntity> eventHandlerEntityList = this.eventHandlerRepository.findAll();
            EventEntity event = this.eventRepository.findById(eventId).get();

            for(EventHandlerEntity eventHandlerEntity:eventHandlerEntityList){
                if(event.getId() == eventHandlerEntity.getEventId()){
                    count++;
                }
            }

        }else{
            return 0;
        }


        return count;
    }

    public int getEventsJoinedCount(int studentId){
        return this.eventHandlerService.getEventsJoinedByStudentId(studentId).size();
    }






}
