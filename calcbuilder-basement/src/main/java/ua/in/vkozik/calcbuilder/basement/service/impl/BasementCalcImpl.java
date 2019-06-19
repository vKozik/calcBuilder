package ua.in.vkozik.calcbuilder.basement.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.in.vkozik.calcbuilder.basement.service.BasementCalc;

@Service
public class BasementCalcImpl implements BasementCalc {
    @Value("${basement.price.concrete}")
    private double priceOfConcrete;

    @Value("${basement.price.landWorks}")
    private double priceOfLandWorks;

    @Override
    public double calculate(double square, double height, double depth) {
        double concrete = square * (height * depth);
        double landWorks = depth * square;
        return concrete * priceOfConcrete + landWorks * priceOfLandWorks;
    }
}
