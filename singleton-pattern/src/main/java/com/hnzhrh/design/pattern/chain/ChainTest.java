package com.hnzhrh.design.pattern.chain;

public class ChainTest {
    public static void main(String[] args) {
        Handler chain = AbstractHandler.buildChain(new FirstHandler(), new SecondHandler());
        chain.handleRequest(new Request());
    }
}
