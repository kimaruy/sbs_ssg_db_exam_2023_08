package com.sbs.java.ssg.dto;

import java.util.Map;

import lombok.Data;

@Data
public class WearProduct extends Dto {
		public int No;
		public String sex;
		public String category;
		public String brand;
		public String part;
		public int price;
		public String name;
		
		public WearProduct(Map<String, Object> row) {
			super(row);
			this.No = (int) row.get("id");
			this.sex = (String) row.get("sex");
			this.category = (String) row.get("category");
			this.brand = (String) row.get("brand");
			this.part = (String) row.get("part");
			this.price = (int) row.get("price");
			this.name = (String) row.get("name");
		}
}