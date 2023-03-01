package com.hnzhrh.design.pattern.chain;

public interface Handler {
    void setNextHandler(Handler next);
    void handleRequest(Request request);
}
