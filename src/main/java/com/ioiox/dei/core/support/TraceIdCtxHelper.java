package com.ioiox.dei.core.support;

public class TraceIdCtxHelper {

    public static final String HEADER_KEY_TRACE_ID = "X-B3-TraceId";

    private TraceIdCtxHelper() {}

    private static final InheritableThreadLocal<String> TRACE_THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void setTraceId(final String traceId) {
        TRACE_THREAD_LOCAL.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_THREAD_LOCAL.get();
    }

    public static void removeTraceId() {
        TRACE_THREAD_LOCAL.remove();
    }

}
