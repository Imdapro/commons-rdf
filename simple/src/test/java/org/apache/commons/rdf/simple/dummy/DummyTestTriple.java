package org.apache.commons.rdf.simple.dummy;

import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.RDFTerm;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.simple.BlankNodeImplTest;

/**
 * Created by Csaba Kothencz on 2017. 05. 04.
 */
public class DummyTestTriple implements Triple{

    @Override
    public BlankNodeOrIRI getSubject() {
        return new BlankNodeImplTest().getTestBlankNode();
    }

    @Override
    public IRI getPredicate() {
        return new IRI() {
            @Override
            public String getIRIString() {
                return "getIRIString";
            }

            @Override
            public String ntriplesString() {
                return "ntriplesString";
            }
        };
    }

    @Override
    public RDFTerm getObject() {
        return new RDFTerm() {
            @Override
            public String ntriplesString() {
                return "ntriplesString";
            }
        };
    }
}
