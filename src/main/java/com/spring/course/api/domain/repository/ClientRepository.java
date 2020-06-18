package com.spring.course.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.spring.course.api.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);

    List<Client> findByNameContaining(String name);

    Client findByEmail(String email);

}