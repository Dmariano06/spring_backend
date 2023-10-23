package com.example.demo.service;

import com.example.demo.LoginMessage;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDTO;

public interface ClientService {
    String addClient(ClientDTO clientDTO);

    LoginMessage loginClient(LoginDTO loginDTO);

}
