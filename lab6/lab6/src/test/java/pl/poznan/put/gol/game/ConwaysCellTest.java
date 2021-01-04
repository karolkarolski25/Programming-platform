/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.gol.game;

import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karol
 */
public class ConwaysCellTest {

    public ConwaysCellTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of neighbors method, of class ConwaysCell.
     */
    @Test
    public void testNeighbors() {
        ConwaysCell instance = new ConwaysCell(2, 2);

        Cells expResult = new Cells(
                new ConwaysCell(1, 1),
                new ConwaysCell(1, 2),
                new ConwaysCell(1, 3),
                new ConwaysCell(2, 1),
                new ConwaysCell(2, 3),
                new ConwaysCell(3, 1),
                new ConwaysCell(3, 2),
                new ConwaysCell(3, 3));

        assertEquals(expResult, instance.neighbors());
    }

    @Test
    public void testEquals() {
        ConwaysCell firstInstanceCell = new ConwaysCell(2, 2);
        ConwaysCell secondInstanceCell = new ConwaysCell(1, 2);

        assertFalse(firstInstanceCell.equals(secondInstanceCell));
    }
}
