package com.jsp.springboot_item.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_item.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {
	
}
