package dev.yonk.backend.enums;

public enum ProductStatus {
    ONGOING(1),
    STOP(0),
    TERMINATE(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
