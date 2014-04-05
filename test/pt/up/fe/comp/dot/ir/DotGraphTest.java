package pt.up.fe.comp.dot.ir;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class DotGraphTest {
    private DotGraph dg;

    @Before
    public void init() {
        dg = new DotGraph();
    }

    @Test
    public void addNodeTest(){
        dg.addNode("q1");
        Set<String> nodes = dg.getNodes();
        assertTrue("NodeSet doesn't contain added node.", nodes.contains("q1"));
    }

    @Test
    public void hasNodeTest() {
        dg.addNode("q1");
        assertTrue(dg.hasNode("q1"));
        assertFalse(dg.hasNode("q2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void getNodeEdgesThrowsTest() {
        dg.getNodeEdges("q1");
    }

    @Test
    public void addNewEdgeTest() {
        dg.addNode("q1");
        DotGraph.Edge edge = dg.addNewEdge("q1");
        List<DotGraph.Edge> edges = dg.getNodeEdges("q1");

        int count = 0;
        for(DotGraph.Edge e : edges) {
            if (e == edge) count++;
        }

        assertEquals(count, 1);
    }
}
