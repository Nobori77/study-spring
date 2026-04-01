package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Outback implements com.app.dependency.qualifier.Resturant {
    @Override
    public boolean isSaladBar() {
        return false;
    }
}