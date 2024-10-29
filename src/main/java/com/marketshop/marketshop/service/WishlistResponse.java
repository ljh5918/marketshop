package com.marketshop.marketshop.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistResponse<T> {
    private String message;
    private T data;

    public WishlistResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getter, Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
