package com.spring.course.api.domain.service.CreateClientService;

import org.springframework.stereotype.Service;

import com.spring.course.api.domain.model.Client;
import com.spring.course.api.domain.repository.ClientRepository;

// tudo que tiver alteração no banco, passar pelo Service
// se for somente consulta no banco, pode permanecer no Controller

@Service
public class CreateClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        Client clientExists = clientRepository.findByEmail(client.getEmail());

        if(clientExists != null && !clientExists.equals(client)) {
            throw new BusinessException("Já existe um cliente com este e-mail");
        }

        return clientRepository.save(client);
    }

    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}