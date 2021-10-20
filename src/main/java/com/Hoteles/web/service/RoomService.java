/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hoteles.web.service;

import com.Hoteles.web.dao.RoomRepository;
import com.Hoteles.web.entities.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danic
 */
@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    
  public List<Room> getAll() {return (List<Room>) roomRepository.getAll();};
  
  public Optional<Room> getRoom(int id) {return roomRepository.getRoom(id);};
  
  public Room save(Room room) { 
       if (room.getId()== null){
           return roomRepository.save(room);
       }
       else
       {
          Optional<Room> co =  roomRepository.getRoom(room.getId());
          if (co.isEmpty()){
              return roomRepository.save(room);
          }
          else
          {
              return room;
          }
       }
 
    }
  
  
}

