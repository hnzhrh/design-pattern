package com.hnzhrh.design.pattern.chain;

public class SecondHandler extends AbstractHandler{
    @Override
    public void handleRequest(Request request) {
        if (canHandle(request)) {
            // 处理逻辑
            System.out.println("SecondHandler 处理");
        } else {
            super.handleRequest(request);
        }
    }

    public boolean canHandle(Request request) {
        // 判断是否属于当前节点处理
        return true;
    }
}
