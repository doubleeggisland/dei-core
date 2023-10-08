package com.ioiox.dei.core.support;

import org.slf4j.MDC;

public class LogMdcHelper {

    public static final String LOG_PROPERTY_TRACE_ID = "traceId";

    private LogMdcHelper() {}

    public static void setTraceId(final String traceId) {
        setProperty(LOG_PROPERTY_TRACE_ID, traceId);
    }

    public static void setProperty(final String property, final String value) {
        MDC.put(property, value);
    }
}
