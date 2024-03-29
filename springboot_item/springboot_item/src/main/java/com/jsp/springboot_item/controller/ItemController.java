package com.jsp.springboot_item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_item.dao.ItemDAO;
import com.jsp.springboot_item.dto.Item;

@RestController
public class ItemController {
	@Autowired
	private ItemDAO itemDAO;
	
	@PostMapping("/saveitem")
	public Item saveItem(@RequestBody Item item) {
		return itemDAO.saveItem(item);
	}
	
	@PutMapping("/updateitem")
	public Item updateItem(@RequestParam int id, @RequestBody Item item) {
		return itemDAO.updateItem(id, item);
	}
	
	@DeleteMapping("/deleteItem")
	public Item deleteItem(@RequestParam int id) {
		return itemDAO.deleteItem(id);
	}
	
	@GetMapping("getitemiyid")
	public Item getItemById(@RequestParam int id) {
		return itemDAO.getItemById(id);
	}
	
	@GetMapping("getallitems")
	public List<Item> getAllItems(){
		return itemDAO.getAllItems();
	}
	
}
