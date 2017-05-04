package org.apache.commons.rdf.simple;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Király Csombor on 2017. 05. 04..
 */
public class IRIImplTest {

    @Test
    public void testConstructorValidArgument(){
        IRIImpl iri = new IRIImpl("some_text");

        assertNotNull(iri);
        assertEquals("some_text", iri.getIRIString());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorInvalidArgument(){
        IRIImpl iri = new IRIImpl("\\\"\n\t ");
    }

    @Test
    public void testNTriplesString(){
        IRIImpl iri = new IRIImpl("iri");

        assertEquals("<iri>", iri.ntriplesString());
    }

    @Test
    public void testToString(){
        IRIImpl iri = new IRIImpl("iri");

        assertEquals(iri.ntriplesString(), iri.toString());
    }

    @Test
    public void testEquals(){
        IRIImpl iri1 = new IRIImpl("iri");
        IRIImpl iri2 = new IRIImpl("iri");
        IRIImpl iri3 = new IRIImpl("iri2");

        assertEquals(false, iri1.equals(null));
        assertEquals(true, iri1.equals(iri1));
        assertEquals(false, iri1.equals("iri"));
        assertEquals(true, iri1.equals(iri2));
        assertEquals(false, iri1.equals(iri3));
    }

    @Test
    public void testHashCode(){
        IRIImpl iri1 = new IRIImpl("iri");
        IRIImpl iri2 = new IRIImpl("iri");
        IRIImpl iri3 = new IRIImpl("iri2");

        assertEquals(iri1.hashCode(), iri1.hashCode());
        assertEquals(iri1.hashCode(), iri2.hashCode());
        assertNotEquals(iri1.hashCode(), iri3.hashCode());
    }

}