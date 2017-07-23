package com.company;

import javafx.beans.property.*;

public class Product {
    private StringProperty name;
    private ObjectProperty<ProductType> type;
    private BooleanProperty trainer;
    private IntegerProperty amount;

    public Product(String name, ProductType type, boolean trainer, int amount) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleObjectProperty<>(type);
        this.trainer = new SimpleBooleanProperty(trainer);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public Product() {
        this.name = new SimpleStringProperty();
        this.type = new SimpleObjectProperty<>();
        this.trainer = new SimpleBooleanProperty();
        this.amount = new SimpleIntegerProperty();
    }


    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ProductType getType() {
        return type.get();
    }

    public void setType(ProductType type) {
        this.type.set(type);
    }

    public ObjectProperty<ProductType> typeProperty() {
        return type;
    }

    public boolean isTrainer() {
        return trainer.get();
    }

    public void setTrainer(boolean trainer) {
        this.trainer.set(trainer);
    }

    public BooleanProperty trainerProperty() {
        return trainer;
    }

    public int getAmount() {
        return amount.get();
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public boolean isValid(){
        return name != null && type != null && trainer != null && amount !=null;
    }
}
