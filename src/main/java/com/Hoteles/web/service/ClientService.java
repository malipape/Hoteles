/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hoteles.web.service;

import com.Hoteles.web.dao.ClientRepository;
import com.Hoteles.web.dao.RoomRepository;
import com.Hoteles.web.entities.Client;
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
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
  public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
  
  public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
  
  public Client save(Client client) { 
       if (client.getIdClient()== null){
           return clientRepository.save(client);
       }
       else
       {
          Optional<Client> co =  clientRepository.getClient(client.getIdClient());
          if (co.isEmpty()){
              return clientRepository.save(client);
          }
          else
          {
              return client;
          }
       }
 
    }
  
  
}
