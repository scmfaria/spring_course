package com.spring.course.api.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.api.domain.model.Client;
import com.spring.course.api.domain.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreateClientService clientService;

    @GetMapping
    public List<Client> list() {
         return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if(client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente add(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client) {

        if(!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientService.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId) {

        if(!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        clientService.deleteById(clientId);

        return ResponseEntity.noContent().build();
    }
}