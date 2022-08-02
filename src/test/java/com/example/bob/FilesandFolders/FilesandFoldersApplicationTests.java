package com.example.bob.FilesandFolders;

import com.example.bob.FilesandFolders.models.File;
import com.example.bob.FilesandFolders.models.Folder;
import com.example.bob.FilesandFolders.models.Person;
import com.example.bob.FilesandFolders.repository.FileRespository;
import com.example.bob.FilesandFolders.repository.FolderRepository;
import com.example.bob.FilesandFolders.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesandFoldersApplicationTests {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	FolderRepository folderRepository;
	@Autowired
	FileRespository fileRespository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreatePersonandFolderandFile() {
		Person person1 = new Person("Brian", "Kerr");
		Folder folder1 = new Folder("Main", person1);
		File file1 = new File("cat", ".jpeg", 22, folder1);
		personRepository.save(person1);
		folderRepository.save(folder1);
		fileRespository.save(file1);
	}



}
