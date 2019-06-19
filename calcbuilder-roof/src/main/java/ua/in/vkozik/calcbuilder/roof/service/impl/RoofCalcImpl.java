package ua.in.vkozik.calcbuilder.roof.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ua.in.vkozik.calcbuilder.roof.service.RoofCalc;

@Service
public class RoofCalcImpl implements RoofCalc {
    @Value("${basement.price.roofWorks}")
    private double priceOfRoofWorks;

    @Override
    public double calculate(double length, double width) {
        double height = width * 0.8;
        double square = width * height + (length + width) * height ;
        return square * priceOfRoofWorks;
    }
}
