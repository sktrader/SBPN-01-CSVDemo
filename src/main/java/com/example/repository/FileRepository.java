package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.File;

public interface FileRepository extends JpaRepository<File, Long>{

}
