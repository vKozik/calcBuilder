package ua.in.vkozik.calcbuilder.house.service.impl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.vkozik.calcbuilder.house.clients.BasementClient;
import ua.in.vkozik.calcbuilder.house.clients.RoofClient;
import ua.in.vkozik.calcbuilder.house.clients.WallClient;
import ua.in.vkozik.calcbuilder.house.data.BudgetHouse;
import ua.in.vkozik.calcbuilder.house.service.HouseCalc;
@Slf4j
@Service
public class  HouseCalcImpl implements HouseCalc {
    @Autowired
    BasementClient basementClient;
    @Autowired
    RoofClient roofClient;
    @Autowired
    WallClient wallClient;
    @Override
    @HystrixCommand(fallbackMethod = "calculateFallback")
    public BudgetHouse calculate(double length, double width, int numberOfLevels, double roomHeight) {
        Double basementCost = calculateBasement(length * width, numberOfLevels);
        Double wallsCost = calculateWalls(length, width, numberOfLevels, roomHeight);
        Double roofCost = calculateRoof(length, width);
        return new BudgetHouse(basementCost, wallsCost, roofCost);
    }
    public BudgetHouse calculateFallback(double length, double width, int numberOfLevels, double roomHeight, Throwable exception) {
        return new BudgetHouse("There are problems with some services. Please try later. "
                + exception.getMessage());
    }
    public BudgetHouse calculateForUser(String userId, String password) {
        log.info("calculate for user {} with password: {}", userId, password);
    }
    private Double calculateBasement(double square, int numberOfLevels) {
        double height = 0.6;
        double depth = 0.5 / numberOfLevels;
        return basementClient.calculate(square, height, depth);
    }
    private Double calculateWalls(double length, double width, int numberOfLevels, double roomHeight) {
        Double wallCost = 0.0;
        for (int i = 0; i < numberOfLevels; i++) {
            for (int j = 0; j < i; j++) {
               if (length > width) {
                   wallCost += 0.1 * length;
               } else if (width >= length) {
                   wallCost += 0.1 * width;
                   for (int k = 0; k < j; k++) {
                       wallCost += 0.05 * width;
                   }
               }
            }
            roomHeight += 0.3;
        }
        return wallClient.calculate(length, width, numberOfLevels, roomHeight);
    }
    private Double calculateRoof(double length, double width) {
        return roofClient.calculate(length, width);
    }
}
