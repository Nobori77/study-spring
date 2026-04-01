package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Vips implements Resturant {

    private int stakePrice = com.app.dependency.qualifier.Resturant.stakePrice + 30000;

    @Override
    public boolean isSaladBar() {
        return true;
    }
}