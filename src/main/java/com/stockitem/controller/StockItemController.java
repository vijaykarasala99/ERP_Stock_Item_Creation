package com.stockitem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.stockitem.entity.StockItemEntity;
import com.stockitem.service.StockItemService;
@CrossOrigin("*")
@RestController
public class StockItemController {
	@Autowired
	private StockItemService stockService;
	
	@PostMapping("/save")
    public ResponseEntity<ResponseEntity<String>> save(@RequestBody StockItemEntity item){
        ResponseEntity<String> result = stockService.save(item);
        return ResponseEntity.ok(result);
    }
	
	@PutMapping("/update/{stockItemId}")
    public ResponseEntity<StockItemEntity> update(@PathVariable Long stockItemId,
		@RequestBody StockItemEntity updateItem) {
		StockItemEntity result = stockService.update(stockItemId, updateItem);
        return ResponseEntity.ok(result);
    }
	 @PostMapping("/saveall")
  public ResponseEntity<List<StockItemEntity>> saveAll(@RequestBody List<StockItemEntity> items) {
   List<StockItemEntity> results = stockService.saveAll(items);
	        return ResponseEntity.ok(results);
	    }
	 @GetMapping("/get/{stockItemId}")
	  public ResponseEntity<StockItemEntity> getById(@PathVariable Long stockItemId) {
	   Optional<StockItemEntity> result = stockService.getById(stockItemId);
	 return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 @GetMapping("/getall/{userId}/{companyId}")
	  public ResponseEntity<List<StockItemEntity>> getAll(Long userId, Long companyId) {
	  List<StockItemEntity> getall = stockService.getAll(userId, companyId);
	  return new ResponseEntity<>(getall, HttpStatus.OK);
	    }
	 @DeleteMapping("/delete/{stockItemId}")
	 public ResponseEntity<String> deleteById(@PathVariable Long stockItemId) {
	   String result= stockService.deleteById(stockItemId);
	    return ResponseEntity.ok(result);
	    }
}