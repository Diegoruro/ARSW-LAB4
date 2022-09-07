package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Main {

    public static void main(String a[]) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices gc = ac.getBean(BlueprintsServices.class);
        Point[] pts=new Point[]{new Point(1, 10),new Point(5, 10), new Point(59, 43), new Point(10, 45)};
        gc.addNewBlueprint(new Blueprint("Diego","xd", pts));
        gc.addNewBlueprint(new Blueprint("Diego","xdn't"));
        gc.addNewBlueprint(new Blueprint("Juan","lol"));
        try{
            System.out.println("Getting lol Blueprint");
            System.out.println(gc.getBlueprint("Juan", "lol"));
            System.out.println();

            Set<Blueprint> author = gc.getBlueprintsByAuthor("Diego");
            System.out.println("Diego´s Blueprints");
            for (Blueprint bp: author) {
                System.out.println(bp);
            }
        } catch (BlueprintNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
