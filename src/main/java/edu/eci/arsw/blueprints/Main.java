package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String a[]) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices gc = ac.getBean(BlueprintsServices.class);
        gc.addNewBlueprint(new Blueprint("Diego","xd"));
        gc.addNewBlueprint(new Blueprint("Diego","xdn't"));
        gc.addNewBlueprint(new Blueprint("Juan","lol"));
        System.out.println(gc.filterBlueprint(new Blueprint("Diego","xd",new Point[]{new Point(140, 140),new Point(150, 150),new Point(140, 140)})));
    }
}
