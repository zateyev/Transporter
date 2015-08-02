package com.epam.transporter.entity;

public class TrucksParkException extends RuntimeException {
    public TrucksParkException() {
        super();
    }

    public TrucksParkException(String message) {
        super(message);
    }

    public TrucksParkException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrucksParkException(Throwable cause) {
        super(cause);
    }
}
