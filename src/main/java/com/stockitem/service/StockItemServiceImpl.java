package com.stockitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stockitem.entity.StockItemEntity;
import com.stockitem.repo.StockItemRepository;
@Service
public class StockItemServiceImpl implements StockItemService {
    @Autowired
    private StockItemRepository stockItemRepo;
	@Override
	public ResponseEntity<String> save(StockItemEntity item) {
		stockItemRepo.save(item);
		return ResponseEntity.ok("saved");
	}

	@Override
	public StockItemEntity update(Long stockItemId, StockItemEntity updateItem) {
		updateItem.setStockItemId(stockItemId);
		return stockItemRepo.save(updateItem);
	}

	@Override
	public List<StockItemEntity> saveAll(List<StockItemEntity> items) {
		return stockItemRepo.saveAll(items);
	}

	@Override
	public Optional<StockItemEntity> getById(Long stockItemId) {
		return stockItemRepo.findById(stockItemId);
	}
	@Override
	public List<StockItemEntity> getAll(Long userId, Long companyId) {
		return stockItemRepo.getAll(userId,companyId);
	}

	@Override
	public String deleteById(Long stockItemId) {
		if(stockItemRepo.existsById(stockItemId)) {
			stockItemRepo.deleteById(stockItemId);
			return "deleted";
		}else {
		return "no data found";
	}
}
}