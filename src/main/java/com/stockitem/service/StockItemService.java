package com.stockitem.service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

import com.stockitem.entity.StockItemEntity;
public interface StockItemService {

	 public  ResponseEntity<String> save(StockItemEntity item);
	    
	 public  StockItemEntity update(Long stockItemId, StockItemEntity updateItem);

	 public  List<StockItemEntity> saveAll(List<StockItemEntity> items);

	 public  Optional<StockItemEntity> getById(Long stockItemId);
	 
	 public  List<StockItemEntity> getAll(Long userId, Long companyId);

	 public  String deleteById(Long stockItemId);
}
