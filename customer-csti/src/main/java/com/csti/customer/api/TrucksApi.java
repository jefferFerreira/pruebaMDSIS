package com.csti.customer.api;

import com.csti.customer.business.TrucksBusiness;
import com.csti.customer.integrations.entity.TrucksEntity;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("trucks")
@AllArgsConstructor(onConstructor = @__(@Inject))
public class TrucksApi {
    private final @NonNull TrucksBusiness trucksBusiness;

    @GetMapping(value = "/")
    public Iterable<TrucksEntity> obtainAll() {
        return trucksBusiness.obtainAll();
    }

    @PostMapping(value = "/")
    public TrucksEntity save(@RequestBody TrucksEntity trucksEntity) {
        return trucksBusiness.save(trucksEntity);
    }
}
