package com.csti.customer.business;


import com.csti.customer.integrations.dao.TrucksDao;
import com.csti.customer.integrations.entity.TrucksEntity;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
@AllArgsConstructor(onConstructor = @__(@Inject))
public class TrucksBusiness {
    private final @NonNull TrucksDao trucksDao;

    public Iterable<TrucksEntity> obtainAll() {
        return trucksDao.findAll();
    }

    public TrucksEntity save(TrucksEntity trucksEntity) {
        return trucksDao.save(trucksEntity);
    }
}
