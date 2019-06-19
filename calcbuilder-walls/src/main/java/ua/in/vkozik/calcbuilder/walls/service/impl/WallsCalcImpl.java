package ua.in.vkozik.calcbuilder.walls.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ua.in.vkozik.calcbuilder.walls.service.WallsCalc;

@Service
public class WallsCalcImpl implements WallsCalc {
    @Value("${basement.price.wallsWorks}")
    private double priceOfWallsWorks;

    @Override
    public double calculate(double length, double width, int numberOfLevels, double roomHeight) {
        double perimeter = (length + width) * 2;
        double square = perimeter * roomHeight * numberOfLevels;
        return square * priceOfWallsWorks;
    }
}
