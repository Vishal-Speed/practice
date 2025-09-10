package com.example.java21;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutionContextUtil {
    static final AtomicInteger nextId = new AtomicInteger(0);
    private final int threadId;

    private String userName;
    private String requestId;

    private static final ThreadLocal<ExecutionContextUtil> EXECUTION_CONTEXT = ThreadLocal.withInitial(() -> new ExecutionContextUtil(nextId.getAndIncrement()));

    public static synchronized ExecutionContextUtil getContext() {
        if(Objects.isNull(EXECUTION_CONTEXT.get())) {
            EXECUTION_CONTEXT.set(new ExecutionContextUtil(nextId.getAndIncrement()));
        }
        return (ExecutionContextUtil) EXECUTION_CONTEXT.get();
    }

    public static void clear() {
        EXECUTION_CONTEXT.remove();
    }

    public ExecutionContextUtil(int threadId) {
        this.threadId = threadId;
    }

    public int getThreadId() {
        return threadId;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

}
