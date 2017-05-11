package kartushynaA;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {

        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/mainAcad?createDatabaseIfNotExist=true",
                            "root",
                            "1444");
        flyway.migrate();
        LOG.info("Hi logger");
    }
}
