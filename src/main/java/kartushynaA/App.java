package kartushynaA;

import org.flywaydb.core.Flyway;

public class App {
    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/mainAcad?createDatabaseIfNotExist=true",
                            "root",
                            "1444");
        flyway.migrate();
    }
}
