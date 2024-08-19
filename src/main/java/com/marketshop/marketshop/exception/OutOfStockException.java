package com.marketshop.marketshop.exception;

// 주문 기능 구현
public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message) {
        super(message);
    }
}
