package com.almundo.tracemanager;

public class LoggerFactory {

    /**
     * Private Constructor
     */
    private LoggerFactory() {

    }

    /**
     * @param serviceType
     * @param clase
     * @return
     */
    public static synchronized GenericLogger getLogger(
            Class<? extends Object> clase) {

        return new UtilLogger(clase);

    }

}
