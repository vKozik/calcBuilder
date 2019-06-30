package ua.in.vkozik.calcbuilder.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.in.vkozik.calcbuilder.house.clients.BasementClient;
import ua.in.vkozik.calcbuilder.house.clients.RoofClient;
import ua.in.vkozik.calcbuilder.house.clients.WallClient;
import ua.in.vkozik.calcbuilder.house.service.HouseCalc;

@Service
public class HouseCalcImpl implements HouseCalc {
    @Autowired
    BasementClient basementClient;

    @Autowired
    RoofClient roofClient;

    @Autowired
    WallClient wallClient;

    @Override
    public double calculate(double length, double width, int numberOfLevels, double roomHeight) {
        double basementCost = calculateBasement(length * width, numberOfLevels);
        double wallsCost = calculateWalls(length, width, numberOfLevels, roomHeight);
        double roofCost = calculateRoof(length, width);

        return basementCost + wallsCost + roofCost;
    }

    private Double calculateBasement(double square, int numberOfLevels) {
        double height = 0.6;
        double depth = 0.5 * numberOfLevels;

        return basementClient.calculate(square, height, depth);
    }

    private Double calculateWalls(double length, double width, int numberOfLevels, double roomHeight) {

        return wallClient.calculate(length, width, numberOfLevels, roomHeight);
    }

    private Double calculateRoof(double length, double width) {

        return roofClient.calculate(length, width);
    }
}
