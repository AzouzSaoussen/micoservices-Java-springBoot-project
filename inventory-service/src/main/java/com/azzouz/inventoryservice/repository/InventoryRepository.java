package com.azzouz.inventoryservice.repository;/*
 * @created 15/01/2023 - 14:47
 * @project inventory-service
 * @author Azzouz
 */

import com.azzouz.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
