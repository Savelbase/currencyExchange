package com.bank.handler;

import java.util.List;

public interface RestHandler<Request, Response> {

    default Response post(Request request) {
        return null;
    }

    default Response get(Request request){
        return null;
    }

    default Response put(Request request) {
        return null;
    }

    default void delete(Request request) {
    }

}
