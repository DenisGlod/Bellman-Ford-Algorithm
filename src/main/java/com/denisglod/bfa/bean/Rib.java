package com.denisglod.bfa.bean;

public class Rib {
    private String pointStart;
    private String pointEnd;
    private Integer weight;

    public Rib(String pointStart, String pointEnd, Integer weight) {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.weight = weight;
    }

    public String getPointStart() {
        return pointStart;
    }

    public String getPointEnd() {
        return pointEnd;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setPointStart(String pointStart) {
        this.pointStart = pointStart;
    }

    public void setPointEnd(String pointEnd) {
        this.pointEnd = pointEnd;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
