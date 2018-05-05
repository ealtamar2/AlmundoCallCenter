package com.almundo.tracemanager;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilLogger implements GenericLogger, Serializable {

    private static final long serialVersionUID = 4510968173879828075L;
    public static final String ERROR = "[Error][Message:";
    public static final String DEBUG_TRACE = "[Debug Trace][Message:";
    public static final String CLOSE_TRACE = "]";
    public static final String NO_MESSAGE = "NO MESSAGE";

    private transient Logger logger;

    @SuppressWarnings("unused")
    private UtilLogger() {
        // NOT ACCESS
    }

    @SuppressWarnings("static-access")
    public UtilLogger(Class<? extends Object> clase) {
        this.logger = LoggerFactory.getLogger(clase);
    }

    @Override
    public void traceInfo(String infoMessage) {
        logger.info(infoMessage);
    }

    @Override
    public void traceError(String errorMessage, Throwable ex) {
        logger.error(getErrorLog(errorMessage), ex);
    }

    @Override
    public void traceDebug(String message) {
        logger.debug(getDebugLog(message));
    }

    /**
     * 
     * @param message
     * @return
     */
    private String getDebugLog(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEBUG_TRACE);
        sb.append(validateBody(message));
        sb.append(CLOSE_TRACE);
        return sb.toString();
    }

    /**
     * 
     * @param errorMessage
     * @return
     */
    private String getErrorLog(String errorMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(ERROR);
        sb.append(validateBody(errorMessage));
        sb.append(CLOSE_TRACE);
        return sb.toString();
    }

    /**
     * Metodo para validar el mensaje de la excepcion
     * 
     * @param message
     * @return
     */
    public static String validateBody(String message) {
        return message == null || message.isEmpty() ? NO_MESSAGE : message;
    }
}
