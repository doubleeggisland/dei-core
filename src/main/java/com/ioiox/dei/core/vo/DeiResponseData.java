package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.constant.DeiGlobalConstant;

/**
 *
 * @param <T>
 */
public class DeiResponseData<T> {
    public static final int SUCCESS = DeiGlobalConstant.ONE;
    private Integer code;
    private String success;
    private String msg;
    private T data;
    private String traceId;

    public DeiResponseData() {

    }

    private DeiResponseData(final Builder<T> builder) {
        this.code = builder.code;
        this.success = builder.success;
        this.msg = builder.msg;
        this.data = builder.data;
        this.traceId = builder.traceId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public static class Builder<T> {
        private Integer code;
        private String success;
        private String msg;
        private T data;
        private String traceId;

        public Builder<T> code(final Integer code) {
            this.code = code;
            return this;
        }
        public Builder<T> success(final String success) {
            this.success = success;
            return this;
        }
        public Builder<T> msg(final String msg) {
            this.msg = msg;
            return this;
        }
        public Builder<T> data(final T data) {
            this.data = data;
            return this;
        }
        public Builder<T> traceId(final String traceId) {
            this.traceId = traceId;
            return this;
        }

        public DeiResponseData<T> build() {
            return new DeiResponseData<>(this);
        }
    }
}
