package com.example.bob.FilesandFolders.controller;

import com.example.bob.FilesandFolders.models.File;
import com.example.bob.FilesandFolders.repository.FileRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileRespository fileRespository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRespository.findAll(), HttpStatus.OK);
    }
}
