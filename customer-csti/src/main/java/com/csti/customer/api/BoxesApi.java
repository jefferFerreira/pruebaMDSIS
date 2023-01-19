package com.csti.customer.api;

import com.csti.customer.business.BoxesBusiness;
import com.csti.customer.commons.exceptions.BusinessException;
import com.csti.customer.integrations.entity.BoxesEntity;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("boxes")
@AllArgsConstructor(onConstructor = @__(@Inject))
public class BoxesApi {
    private final @NonNull BoxesBusiness boxesBusiness;

    @GetMapping(value = "/")
    public Iterable<BoxesEntity> obtainALL() {
        return boxesBusiness.obtainAll();
    }

    @PostMapping(value = "/")
    public BoxesEntity save(@RequestBody BoxesEntity boxesEntity) throws BusinessException {
        return boxesBusiness.save(boxesEntity);
    }
}
