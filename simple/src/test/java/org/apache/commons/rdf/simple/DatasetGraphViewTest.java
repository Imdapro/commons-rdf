package org.apache.commons.rdf.simple;

import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.RDFTerm;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.simple.dummy.DummyTestDataset;
import org.junit.Test;

/**
 * Created by Csaba Kothencz on 2017. 05. 04.
 */
public class DatasetGraphViewTest {

    private DatasetGraphView datasetGraphView = new DatasetGraphView(new DummyTestDataset());

    @Test
    public void closeTest(){

        try {
            datasetGraphView.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addTest(){

            datasetGraphView.add(new Triple() {
                @Override
                public BlankNodeOrIRI getSubject() {
                    return new BlankNodeImpl();
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
            });
    }
}
