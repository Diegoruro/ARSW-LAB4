package edu.eci.arsw.blueprints.test.filters.impl;

import edu.eci.arsw.blueprints.filter.Filter;
import edu.eci.arsw.blueprints.filter.impl.RedundancyFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RedundancyFilterTest {
    @Test
    public void filterEmptyPointsTest() throws BlueprintPersistenceException {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        Filter bpf = new RedundancyFilter();
        //defining blueprints
        Blueprint bp=new Blueprint("Waters", "Unito");
        ibpp.saveBlueprint(bp);
        //Filtering
        bp = bpf.filterPoints(bp);
        List<Point> correctAnswer= new ArrayList<>();
        //testing results
        assertNotNull(bp.getPoints());
        assertEquals(correctAnswer.toString(), bp.getPoints().toString());
    }
    @Test
    public void filterRepeatedTest() throws BlueprintPersistenceException {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        Filter bpf = new RedundancyFilter();
        //defining blueprints
        Point[] pts=new Point[]{new Point(10, 10),new Point(10, 10), new Point(10, 10), new Point(10, 10)};
        Blueprint bp=new Blueprint("Waters", "Repetidos",pts);
        ibpp.saveBlueprint(bp);
        //Filtering
        bp = bpf.filterPoints(bp);
        List<Point> correctAnswer= new ArrayList<>();
        correctAnswer.add(new Point(10, 10));
        //testing results
        assertNotNull(bp.getPoints());
        assertEquals(correctAnswer.toString(), bp.getPoints().toString());
    }
    @Test
    public void filterDifferentPointsTest() throws BlueprintPersistenceException {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        Filter bpf = new RedundancyFilter();
        //defining blueprints
        Point[] pts=new Point[]{new Point(1, 10),new Point(5, 10), new Point(59, 43), new Point(10, 45)};
        Blueprint bp=new Blueprint("Waters", "Random",pts);
        ibpp.saveBlueprint(bp);
        //Filtering
        bp = bpf.filterPoints(bp);
        List<Point> correctAnswer= new ArrayList<>();
        correctAnswer.add(new Point(1, 10));
        correctAnswer.add(new Point(5, 10));
        correctAnswer.add(new Point(59, 43));
        correctAnswer.add(new Point(10, 45));
        //testing results
        assertNotNull(bp.getPoints());
        assertEquals(correctAnswer.toString(), bp.getPoints().toString());
    }
}
