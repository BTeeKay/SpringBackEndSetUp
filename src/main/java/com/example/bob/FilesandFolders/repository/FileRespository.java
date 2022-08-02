package com.example.bob.FilesandFolders.repository;

import com.example.bob.FilesandFolders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRespository extends JpaRepository<File, Long> {
}
