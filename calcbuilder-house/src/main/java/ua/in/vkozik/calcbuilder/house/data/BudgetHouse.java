package ua.in.vkozik.calcbuilder.house.data;

import java.time.LocalDateTime;

public class BudgetHouse {
    private Double basementCost;
    private Double wallsCost;
    private Double roofCost;
    private Double total;
    private LocalDateTime localDateTime;
    private String result;

    public BudgetHouse(Double basementCost, Double wallsCost, Double roofCost) {
        this.basementCost = basementCost;
        this.wallsCost = wallsCost;
        this.roofCost = roofCost;
        this.total = basementCost + wallsCost + roofCost;
        localDateTime = LocalDateTime.now();
        result = "Ok";
    }

    public BudgetHouse(String result) {
        this.result = result;
    }

    public Double getBasementCost() {
        return basementCost;
    }

    public void setBasementCost(Double basementCost) {
        this.basementCost = basementCost;
    }

    public Double getWallsCost() {
        return wallsCost;
    }

    public void setWallsCost(Double wallsCost) {
        this.wallsCost = wallsCost;
    }

    public Double getRoofCost() {
        return roofCost;
    }

    public void setRoofCost(Double roofCost) {
        this.roofCost = roofCost;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
