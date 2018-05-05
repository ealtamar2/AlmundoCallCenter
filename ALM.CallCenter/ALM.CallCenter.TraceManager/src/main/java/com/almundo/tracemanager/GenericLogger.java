
package com.almundo.tracemanager;

/**
 * @author ealtamar
 *
 */
public interface GenericLogger {

    /**
     * Metodo que escribe en el trace un mensaje.
     * 
     * @param infoMessage
     */
    public void traceInfo(String infoMessage);

    /**
     * 
     * @param errorMessage
     * @param e
     */
    public void traceError(String errorMessage, Throwable e);

    /**
     * 
     * @param message
     */
    public void traceDebug(String message);

}
