package top.kshon.dao;

import java.util.List;

import top.kshon.pojo.Directory;

public interface DirectoryDao{
	public void save(Directory directory);
	public void update(Directory directory);
	public List<Directory> findAll(Integer person_id,Integer parent_id); 
    public Directory findDirectoryByName(String name);
    public Directory findDirectoryById(Integer id);
}
