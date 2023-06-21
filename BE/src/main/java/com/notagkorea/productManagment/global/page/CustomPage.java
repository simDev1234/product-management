package com.notagkorea.productManagment.global.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Locale;

@AllArgsConstructor
@Getter
public class CustomPage {

    private int page;
    private int size;
    private String orderBy;
    private String orderDir;

    public Pageable toPageable(){
        return PageRequest.of(this.page, this.size, Sort.Direction.valueOf(orderDir.toUpperCase(Locale.ROOT)), orderBy);
    }

}
