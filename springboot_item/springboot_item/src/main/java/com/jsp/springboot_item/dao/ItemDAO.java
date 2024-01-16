package com.jsp.springboot_item.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_item.dto.Item;
import com.jsp.springboot_item.repo.ItemRepo;

@Repository
public class ItemDAO {
	@Autowired
	private ItemRepo itemRepo;
	
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
	public Item updateItem(int id, Item item) {
		Optional<Item> item2 = itemRepo.findById(id);
		
		if(item2.isPresent()) {
			item.setId(id);
			item = itemRepo.save(item);
			return item;
		}else {
			return null;
		}
	}
	
	public Item deleteItem(int id) {
		Item item = itemRepo.findById(id).get();
		itemRepo.deleteById(id);
		return item;
	}
	
	public Item getItemById(int id) {
		return itemRepo.findById(id).get();
	}
	
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
}
