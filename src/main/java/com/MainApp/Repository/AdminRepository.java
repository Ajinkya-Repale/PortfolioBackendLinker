package com.MainApp.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MainApp.Entity.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

    Optional<Admin> findByAdminName(String adminName);

}