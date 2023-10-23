package com.example.demo.service;


import com.example.demo.LoginMessage;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addClient(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.getClientid(),
                clientDTO.getClientname(),
                clientDTO.getEmail(),

                this.passwordEncoder.encode(clientDTO.getPassword())
        );
        clientRepo.save(client);

        return client.getClientname();
    }
    ClientDTO clientDTO;

    @Override
    public LoginMessage loginClient(LoginDTO loginDTO) {
        String msg = "";
        Client client1 = clientRepo.findByEmail(loginDTO.getEmail());
        if (client1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = client1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Client> client = clientRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (client.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }


    }
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

}
