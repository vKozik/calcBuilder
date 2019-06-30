package ua.in.vkozik.calcbuilder.house.service;


import ua.in.vkozik.calcbuilder.house.data.BudgetHouse;

public interface HouseCalc {

    BudgetHouse calculate(double length, double width, int numberOfLevels, double roomHeight);

}
