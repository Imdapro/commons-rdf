package org.apache.commons.rdf.simple;

import org.apache.commons.rdf.simple.experimental.DummyTestDataset;
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
}
