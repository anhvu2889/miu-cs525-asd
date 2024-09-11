package edu.mum.cs.cs525.labs.skeleton.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger4jAdapter implements AppLogger {
    private final Logger logger;

    public Logger4jAdapter(Class<?> callerClass) {
        logger = LogManager.getLogger(callerClass);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        switch (logLevel) {
            case DEBUG -> logger.debug(message);
            case ERROR -> logger.error(message);
            case FATAL -> logger.fatal(message);
            case INFO -> logger.info(message);
            case TRACE -> logger.trace(message);
            case WARNING -> logger.warn(message);
        }
    }
}
