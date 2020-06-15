package com.company.Enum;

public enum DriveType {
    REACT("Motor to reaction"),
    PROP("Propeller"),
    PIST("Pistons")
    ;

    private String drive_type;

    DriveType(String s) {
        this.drive_type=s;
    }

    public String getDrive_type() {
        return drive_type;
    }

    @Override
    public String toString() {
        return "DriveType{" +
                "drive_type='" + drive_type + '\'' +
                "} " + super.toString();
    }
}
