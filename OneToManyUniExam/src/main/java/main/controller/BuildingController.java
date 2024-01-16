package main.controller;

import java.util.List;

import main.dao.Buildingdao;
import main.dto.Building;
import main.dto.Floor;

public class BuildingController {

	public static void main(String[] args) {
		Buildingdao buildingdao = new Buildingdao();
		Building building = new Building("HiTech", "Pune");
		Floor floor1 = new Floor("HiTech", 1);
		Floor floor2 = new Floor("HiTech", 2);
		Floor floor3 = new Floor("HiTech", 3);
		Floor floor4 = new Floor("HiTech", 4);
		building.setFloors(List.of(floor1, floor2, floor3, floor4));
		buildingdao.save(building);

		
		Building building1 = new Building("HiTech", "Pune");
		Floor floor11 = new Floor("HiTech", 1);
		Floor floor12 = new Floor("HiTech", 2);
		Floor floor13 = new Floor("HiTech", 3);
		Floor floor14 = new Floor("HiTech", 4);
		building1.setFloors(List.of(floor11, floor12, floor13, floor14));
		buildingdao.save(building1);
		
		buildingdao.getById(2);
		buildingdao.delete(2);
		buildingdao.getAll();
	}

}
