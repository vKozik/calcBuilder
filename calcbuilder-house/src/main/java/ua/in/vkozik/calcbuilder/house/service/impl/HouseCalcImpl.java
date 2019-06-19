package ua.in.vkozik.calcbuilder.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import ua.in.vkozik.calcbuilder.house.service.HouseCalc;

@Service
public class HouseCalcImpl implements HouseCalc {
    private static final String BASEMENT_SERVICE_URL = "http://calc-builder-basement/calculate?square={square}&height={height}&depth={depth}";
    private static final String WALLS_SERVICE_URL = "http://calc-builder-walls/calculate?length={length}&width={width}&numberOfLevels={numberOfLevels}&roomHeight={roomHeight}";
    private static final String ROOF_SERVICE_URL = "http://calc-builder-roof/calculate?length={length}&width={width}";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public double calculate(double length, double width, int numberOfLevels, double roomHeight) {
        double basementCost = calculateBasement(length * width, numberOfLevels);
        double wallsCost = calculateWalls(length, width, numberOfLevels, roomHeight);
        double roofCost = calculateRoof(length, width);

        return basementCost + wallsCost + roofCost;
    }

    private Double calculateBasement(double square, int numberOfLevels) {
        double basementSquare = square / numberOfLevels;
        double height = 0.6;
        double depth = 0.5 * numberOfLevels;
        ResponseEntity<Double> response = restTemplate.getForEntity(BASEMENT_SERVICE_URL, Double.class, basementSquare, height, depth);

        return response.getBody();
    }

    private Double calculateWalls(double length, double width, int numberOfLevels, double roomHeight) {
        ResponseEntity<Double> response = restTemplate.getForEntity(WALLS_SERVICE_URL, Double.class, length, width,
                numberOfLevels, roomHeight);

        return response.getBody();
    }

    private Double calculateRoof(double length, double width) {
        ResponseEntity<Double> response = restTemplate.getForEntity(ROOF_SERVICE_URL, Double.class, length, width);

        return response.getBody();
    }
}
