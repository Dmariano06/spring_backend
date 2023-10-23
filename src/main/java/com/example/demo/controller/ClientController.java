package com.example.demo.controller;

import com.example.demo.LoginMessage;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import com.example.demo.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientServiceImpl clientServiceImpl;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/save")
    public String saveClient(@RequestBody ClientDTO clientDTO)
    {
        String id = clientService.addClient(clientDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginClient(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginMessage = clientService.loginClient(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
    @GetMapping(path = "/clients")
    public List<Client> getAllClients() {
        return clientServiceImpl.getAllClients();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientServiceImpl.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        Client savedClient = clientServiceImpl.saveClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientServiceImpl.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
