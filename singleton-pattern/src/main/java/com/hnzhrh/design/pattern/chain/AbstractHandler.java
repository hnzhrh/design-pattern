package com.hnzhrh.design.pattern.chain;

public abstract class AbstractHandler implements Handler{
    protected Handler next;
    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        if (null != next) {
            next.handleRequest(request);
        }
    }

    public static Handler buildChain(Handler... handlers) {
        if (null == handlers || handlers.length < 1) {
            return null;
        }
        Handler chain = handlers[0];
        Handler pre = handlers[0];
        for (int i = 1; i < handlers.length; i++) {
            pre.setNextHandler(handlers[i]);
            pre = handlers[i];
        }
        return chain;
    }
}
