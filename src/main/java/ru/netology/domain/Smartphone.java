package ru.netology.domain;



public class Smartphone extends Product {


    private String producedBy;


    public Smartphone(String producedBy) {
        this.producedBy = producedBy;
    }

    public Smartphone(int id, int price, String name, String producedBy) {
        super(id, price, name);
        this.producedBy = producedBy;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }
}