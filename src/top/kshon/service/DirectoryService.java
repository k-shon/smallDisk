package top.kshon.service;

import java.util.List;

import top.kshon.pojo.Directory;

public interface DirectoryService {

	public void create(Directory directory);
	public void update(Directory directory);
	public List<Directory> findAll(Integer person_id,Integer parent_id); 
	public Directory findDirectoryByName(String name);
	public Directory findDirectoryById(Integer id);
}
