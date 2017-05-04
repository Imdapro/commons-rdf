package org.apache.commons.rdf.simple;

import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mark on 2017. 05. 04..
 */

/*
public class QuadImplTest {
    private QuadImpl quadImpl;

    @Test
    public void testEquals(){
        quadImpl = new QuadImpl(new BlankNodeImpl(new UUID(5, 4), "name"),
                    new BlankNodeImpl(new UUID(5, 4), "name"), new IRIImpl("teszt"),
                    new BlankNodeImpl(new UUID(5, 4), "teszt"));

        assertTrue(!quadImpl.equals(null));
    }
}
*/

/**
 * Modified by Király Csombor on 2017. 05. 04..
 */

public class QuadImplTest {

    IRIImpl s1 = new IRIImpl("s");
    IRIImpl p1 = new IRIImpl("p");
    IRIImpl o1 = new IRIImpl("o");
    IRIImpl s2 = new IRIImpl("s");
    IRIImpl p2 = new IRIImpl("p");
    IRIImpl o2 = new IRIImpl("o");
    IRIImpl s3 = new IRIImpl("ss");
    IRIImpl p3 = new IRIImpl("pp");
    IRIImpl o3 = new IRIImpl("oo");
    IRIImpl g1 = new IRIImpl("graph1");
    IRIImpl g2 = new IRIImpl("graph1");
    IRIImpl g3 = new IRIImpl("graph2");

    @Test
    public void testConstructorValidArguments(){

        QuadImpl quad1 = new QuadImpl(g1, s1, p1, o1);
        QuadImpl quad2 = new QuadImpl(null, s1, p1, o1);

        assertNotNull(quad1);
        assertEquals(g1, quad1.getGraphName().get());
        assertEquals(s1, quad1.getSubject());
        assertEquals(p1, quad1.getPredicate());
        assertEquals(o1, quad1.getObject());

        assertEquals(false, quad2.getGraphName().isPresent());
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullSubject(){
        QuadImpl quad = new QuadImpl(null, null, p1, o1);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullPredicate(){
        QuadImpl quad = new QuadImpl(null, s1, null, o1);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullObject(){
        QuadImpl quad = new QuadImpl(null, s1, p1, null);
    }

    @Test
    public void testToString(){
        QuadImpl quad1 = new QuadImpl(g1, s1, p1, o1);
        QuadImpl quad2 = new QuadImpl(null, s1, p1, o1);

        assertEquals(quad1.toString(), s1.ntriplesString() + " " + p1.ntriplesString() + " " + o1.ntriplesString() + " " + g1.ntriplesString() + " .");
        assertEquals(quad2.toString(), s1.ntriplesString() + " " + p1.ntriplesString() + " " + o1.ntriplesString() + " .");
    }

    @Test
    public void testEquals(){
        QuadImpl quad1 = new QuadImpl(g1, s1, p1, o1);
        QuadImpl quad2 = new QuadImpl(g2, s2, p2, o2);
        QuadImpl quad3a = new QuadImpl(g3, s2, p2, o2);
        QuadImpl quad3b = new QuadImpl(g2, s3, p2, o2);
        QuadImpl quad3c = new QuadImpl(g2, s2, p3, o2);
        QuadImpl quad3d = new QuadImpl(g2, s2, p2, o3);
        QuadImpl quad4 = new QuadImpl(null, s2, p2, o2);

        assertEquals(false, quad1.equals(null));
        assertEquals(true, quad1.equals(quad2));
        assertEquals(false, quad1.equals(quad3a));
        assertEquals(false, quad1.equals(quad3b));
        assertEquals(false, quad1.equals(quad3c));
        assertEquals(false, quad1.equals(quad3d));
        assertEquals(false, quad1.equals(quad4));
    }

    @Test
    public void testAsTriple(){
        QuadImpl quad = new QuadImpl(g1, s1, p1, o1);
        TripleImpl triple = new TripleImpl(s2, p2, o2);

        assertEquals(triple, quad.asTriple());
    }

    @Test
    public void testHashCode(){
        QuadImpl quad1 = new QuadImpl(g1, s1, p1, o1);
        QuadImpl quad2 = new QuadImpl(g2, s2, p2, o2);
        QuadImpl quad3a = new QuadImpl(g3, s2, p2, o2);
        QuadImpl quad3b = new QuadImpl(g2, s3, p2, o2);
        QuadImpl quad3c = new QuadImpl(g2, s2, p3, o2);
        QuadImpl quad3d = new QuadImpl(g2, s2, p2, o3);
        QuadImpl quad4 = new QuadImpl(null, s2, p2, o2);

        assertEquals(quad1.hashCode(), quad1.hashCode());
        assertEquals(quad1.hashCode(), quad2.hashCode());
        assertNotEquals(quad1.hashCode(), quad3a.hashCode());
        assertNotEquals(quad1.hashCode(), quad3b.hashCode());
        assertNotEquals(quad1.hashCode(), quad3c.hashCode());
        assertNotEquals(quad1.hashCode(), quad3d.hashCode());
        assertNotEquals(quad1.hashCode(), quad4.hashCode());
        assertEquals(quad4.hashCode(), quad4.hashCode());
    }

}
