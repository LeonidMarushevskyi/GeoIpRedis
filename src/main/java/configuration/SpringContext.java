package configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: Marushevskiy L.
 * Date: 05.12.12
 * Time: 12:34
 */
public class SpringContext {

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static SpringContext ourInstance = null;

    private ApplicationContext context = null;

    public static synchronized SpringContext getInstance() {
        if (ourInstance == null) {
            ourInstance = new SpringContext();
        }

        return ourInstance;
    }

    private SpringContext() {
        try {
            context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        } catch (Exception ex) {
            logger.error("Can't create context", ex);
        }
    }

    public ApplicationContext getContext() {
        return context;
    }
}
