package com.sbs.java.ssg.dto;

import java.util.Map;

import lombok.Data;

@Data
public class FoodProduct extends Dto {
		public int No;
		public String brand;
		public String part;
		public int price;
		public String product;
		
		public FoodProduct(Map<String, Object> row) {
			super(row);
			this.No = (int) row.get("id");
			this.brand = (String) row.get("brand");
			this.part = (String) row.get("part");
			this.price = (int) row.get("price");
			this.product = (String) row.get("product");
		}
}