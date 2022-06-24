package com.example.crmapi.repository;

import com.example.crmapi.model.Client;
import com.example.crmapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}