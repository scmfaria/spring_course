package com.spring.course.api.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.api.domain.model.Client;

@RestController
public class ClientController {

    @GetMapping("/clientes")
    public List<Client> list() {
        var client1 = new Client();
        client1.setId(1L);
        client1.setName("Joao");
        client1.setEmail("joao@joao.com.br");
        client1.setPhone("16 999998888");

        var client2 = new Client();
        client2.setId(2L);
        client2.setName("Maria");
        client2.setEmail("maria@maria.com.br");
        client2.setPhone("16 555552222");

        return Arrays.asList(client1, client2);
    }
}