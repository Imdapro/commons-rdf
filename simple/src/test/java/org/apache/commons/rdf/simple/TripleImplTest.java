package org.apache.commons.rdf.simple;

/**
 * Created by Király Csombor on 2017. 05. 04..
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TripleImplTest {

    IRIImpl s1 = new IRIImpl("s");
    IRIImpl p1 = new IRIImpl("p");
    IRIImpl o1 = new IRIImpl("o");
    IRIImpl s2 = new IRIImpl("s");
    IRIImpl p2 = new IRIImpl("p");
    IRIImpl o2 = new IRIImpl("o");
    IRIImpl s3 = new IRIImpl("ss");
    IRIImpl p3 = new IRIImpl("pp");
    IRIImpl o3 = new IRIImpl("oo");

    @Test
    public void testConstructorValidArguments(){
        TripleImpl triple = new TripleImpl(s1, p1, o1);

        assertNotNull(triple);
        assertEquals(s1, triple.getSubject());
        assertEquals(p1, triple.getPredicate());
        assertEquals(o1, triple.getObject());
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullSubject(){
        TripleImpl triple = new TripleImpl(null, p1, o1);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullPredicate(){
        TripleImpl triple = new TripleImpl(s1, null, o1);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullObject(){
        TripleImpl triple = new TripleImpl(s1, p1, null);
    }

    @Test
    public void testToString(){
        TripleImpl triple = new TripleImpl(s1, p1, o1);

        assertEquals(triple.toString(), s1.ntriplesString() + " " + p1.ntriplesString() + " " + o1.ntriplesString() + " .");
    }

    @Test
    public void testEquals(){
        TripleImpl triple1 = new TripleImpl(s1, p1, o1); //base
        TripleImpl triple2 = new TripleImpl(s2, p2, o2); //equals
        TripleImpl triple3a = new TripleImpl(s3, p2, o2); //subject not equals
        TripleImpl triple3b = new TripleImpl(s2, p3, o2); //predicate not equals
        TripleImpl triple3c = new TripleImpl(s2, p2, o3); //object not equals

        assertEquals(false, triple1.equals(null));
        assertEquals(true, triple1.equals(triple2));
        assertEquals(false, triple1.equals(triple3a));
        assertEquals(false, triple1.equals(triple3b));
        assertEquals(false, triple1.equals(triple3c));
    }

    @Test
    public void testHashCode(){
        TripleImpl triple1 = new TripleImpl(s1, p1, o1);
        TripleImpl triple2 = new TripleImpl(s2, p2, o2);
        TripleImpl triple3 = new TripleImpl(s3, p3, o3);

        assertEquals(triple1.hashCode(), triple1.hashCode());
        assertEquals(triple2.hashCode(), triple2.hashCode());
        assertEquals(triple3.hashCode(), triple3.hashCode());
        assertEquals(triple1.hashCode(), triple2.hashCode());
        assertNotEquals(triple1.hashCode(), triple3.hashCode());
        assertNotEquals(triple2.hashCode(), triple3.hashCode());
    }

}