package org.apache.commons.rdf.simple;

import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.RDFTerm;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.simple.dummy.DummyTestDataset;
import org.apache.commons.rdf.simple.dummy.DummyTestTriple;
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

            datasetGraphView.add(new DummyTestTriple());
    }
}
