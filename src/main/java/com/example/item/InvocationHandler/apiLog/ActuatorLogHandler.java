package com.example.item.InvocationHandler.apiLog;

import lombok.Data;

public interface ActuatorLogHandler {

    ThreadLocal<Object> userId = ThreadLocal.withInitial(() -> 0);

    void log(LogDTO log);

    @Data
    class LogDTO {
        private String url;
        private String name;
        private long reqTimestamp;
        private String reqBody;
        private long rspTimestamp;
        private String rspBody;
        private int status;
        private Object createUser = userId.get();
        private String extraData;
    }

}
