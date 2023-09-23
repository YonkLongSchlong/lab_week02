package dev.yonk.lab_week02.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    STOP(-1);

    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
