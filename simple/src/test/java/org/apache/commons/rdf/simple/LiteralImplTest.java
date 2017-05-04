package org.apache.commons.rdf.simple;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mark on 2017. 05. 04..
 */
public class LiteralImplTest {
    private LiteralImpl literalImpl;

    @Test
    public void testToString(){
        literalImpl = new LiteralImpl("literal");

        assertTrue(literalImpl.toString() != "");
    }

    @Test
    public void testEquals(){
        literalImpl = new LiteralImpl("literal");

        assertTrue(!literalImpl.equals(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor(){
        literalImpl = new LiteralImpl("literal", "");

    }
}
