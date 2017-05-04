package org.apache.commons.rdf.simple;

import org.apache.commons.rdf.experimental.RDFParser;
import org.apache.commons.rdf.simple.dummy.DummyTestRDFParser;
import org.apache.commons.rdf.simple.experimental.RDFParseException;
import org.junit.Test;

/**
 * Created by Csaba Kothencz on 2017. 05. 04.
 */
public class RDFParserExceptionTest {

    @Test(expected = RDFParseException.class)
    public void test1() throws RDFParseException {

        throw new RDFParseException(new DummyTestRDFParser());
    }
}
