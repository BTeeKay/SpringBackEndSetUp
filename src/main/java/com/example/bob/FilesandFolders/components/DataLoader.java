package com.example.bob.FilesandFolders.components;

import com.example.bob.FilesandFolders.models.File;
import com.example.bob.FilesandFolders.models.Folder;
import com.example.bob.FilesandFolders.models.Person;
import com.example.bob.FilesandFolders.repository.FileRespository;
import com.example.bob.FilesandFolders.repository.FolderRepository;
import com.example.bob.FilesandFolders.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRespository fileRespository;

    public void run(ApplicationArguments args) {

        Person person1 = new Person("Brian", "Kerr");
        personRepository.save(person1);
        Person person2 = new Person("Tina", "Munro");
        personRepository.save(person2);

        Folder folder1 = new Folder("Cats", person1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("dogs", person1);
        folderRepository.save(folder2);

        File file1 = new File("cat1", ".jpeg", 20, folder1);
        fileRespository.save(file1);
        File file2 = new File("cat2", ".jpeg", 22, folder1);
        fileRespository.save(file2);
        File file3 = new File("dog1", ".jpeg", 1, folder2);
        fileRespository.save(file3);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);
        folderRepository.save(folder1);
        folderRepository.save(folder2);

        person1.addFolder(folder1);
        person1.addFolder(folder2);
        personRepository.save(person1);

    }
}
