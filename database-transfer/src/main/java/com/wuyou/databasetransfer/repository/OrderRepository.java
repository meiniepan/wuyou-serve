package com.wuyou.databasetransfer.repository;

import com.wuyou.databasetransfer.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hjn
 * @created 2019-01-22
 **/
@Repository
public interface OrderRepository extends JpaRepository<Shop, Long> {


}
