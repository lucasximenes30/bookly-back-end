package com.bookly.bookly_back_end.repository;

import com.bookly.bookly_back_end.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
