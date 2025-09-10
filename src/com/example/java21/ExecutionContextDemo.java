package com.example.java21;

import java.util.UUID;

public class ExecutionContextDemo {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            ExecutionContextUtil contextUtil = ExecutionContextUtil.getContext();
            contextUtil.setUserName(Thread.currentThread().getName()+"-"+ UUID.randomUUID().toString());
            contextUtil.setRequestId("REQ-"+contextUtil.getThreadId());
            System.out.println("Thread: " + Thread.currentThread().getName()
                    + " | ContextId: " + contextUtil.getThreadId()
                    + " | UserName: " + contextUtil.getUserName()
                    + " | RequestId: " + contextUtil.getRequestId());
        };


        new Thread(task1,"Worker-1").start();
        new Thread(task1,"Worker-2").start();

    }
}
