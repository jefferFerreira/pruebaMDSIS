package com.csti.customer.integrations.dao;

import com.csti.customer.integrations.entity.TrucksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrucksDao extends CrudRepository<TrucksEntity, String> {
}
