package com.csti.customer.business;

import com.csti.customer.commons.exceptions.BusinessException;
import com.csti.customer.integrations.dao.BoxesDao;
import com.csti.customer.integrations.dao.TrucksDao;
import com.csti.customer.integrations.entity.BoxesEntity;
import com.csti.customer.integrations.entity.TrucksEntity;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor(onConstructor = @__(@Inject))
public class BoxesBusiness {

    private final @NonNull BoxesDao boxesDao;
    private final @NonNull TrucksDao trucksDao;

    public Iterable<BoxesEntity> obtainAll() {
        return boxesDao.findAll();
    }

    public BoxesEntity save(BoxesEntity boxesEntity) throws BusinessException {
        AtomicBoolean isCapacity = new AtomicBoolean(false);
        Iterator<TrucksEntity> trucksList = trucksDao.findAll().iterator();
        while (trucksList.hasNext() && !isCapacity.get()) {
            TrucksEntity trucksEntity = trucksList.next();
            if (trucksEntity.getCapacity() >= boxesEntity.getQuantity()) {
                trucksEntity.setCapacity(trucksEntity.getCapacity() - boxesEntity.getQuantity());
                boxesEntity.setPlate(trucksEntity.getPlate());
                trucksDao.save(trucksEntity);
                isCapacity.set(true);
            }
        }
        if (isCapacity.get())
            return boxesDao.save(boxesEntity);
        else
            throw new BusinessException("Los camiones no tienen la capacidad de carga ");
    }
}
