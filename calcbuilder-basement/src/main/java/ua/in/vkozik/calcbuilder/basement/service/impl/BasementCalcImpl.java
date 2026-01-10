package ua.in.vkozik.calcbuilder.basement.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.in.vkozik.calcbuilder.basement.service.BasementCalc;
import ua.in.vkozik.calcbuilder.basement.service.UserContext;

@Slf4j
@Service
public class   BasementCalcImpl implements BasementCalc {
    @Value("${basement.price.concrete}")
    private double priceOfConcrete;

    @Value("${basement.price.landWorks}")
    private double priceOfLandWorks;

    @Autowired
    private UserContext userContext;

    @Override
    public double calculate(double square, double height, double depth) {
        double concrete = square * (height * depth);
        double landWorks = depth * square / height;
        return concrete * priceOfConcrete + landWorks * priceOfLandWorks;
    }

    private void getUserInfo() {
        String userId = userContext.getCurrentUserId();
        String userPassword = userContext.getCurrentUserPassword();
        log.info("User ID: {} Password: {}", userId, userPassword);
    }
}
