package com.sunhome.boot.autoimport.enums;

public enum SwitchEnum {

    OPEN(true),
    CLOUSE(false);

    SwitchEnum(boolean open) {
        this.open = open;
    }

    boolean open;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
