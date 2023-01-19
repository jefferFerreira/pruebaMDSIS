package com.csti.customer.integrations.dao;

import com.csti.customer.integrations.entity.BoxesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxesDao extends CrudRepository<BoxesEntity, String> {
}
