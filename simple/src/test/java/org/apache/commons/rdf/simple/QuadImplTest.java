package org.apache.commons.rdf.simple;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mark on 2017. 05. 04..
 */
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
