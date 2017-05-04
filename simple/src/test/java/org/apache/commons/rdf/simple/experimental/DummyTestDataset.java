package org.apache.commons.rdf.simple.experimental;

import org.apache.commons.rdf.api.*;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Csaba Kothencz on 2017. 05. 04.
 */
public class DummyTestDataset implements Dataset {
    @Override
    public void add(Quad quad) {

    }

    @Override
    public void add(BlankNodeOrIRI graphName, BlankNodeOrIRI subject, IRI predicate, RDFTerm object) {

    }

    @Override
    public boolean contains(Quad quad) {
        return false;
    }

    @Override
    public boolean contains(Optional<BlankNodeOrIRI> graphName, BlankNodeOrIRI subject, IRI predicate, RDFTerm object) {
        return false;
    }

    @Override
    public Graph getGraph() {
        return null;
    }

    @Override
    public Optional<Graph> getGraph(BlankNodeOrIRI graphName) {
        return null;
    }

    @Override
    public Stream<BlankNodeOrIRI> getGraphNames() {
        return null;
    }

    @Override
    public void remove(Quad quad) {

    }

    @Override
    public void remove(Optional<BlankNodeOrIRI> graphName, BlankNodeOrIRI subject, IRI predicate, RDFTerm object) {

    }

    @Override
    public void clear() {

    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Stream<? extends Quad> stream() {
        return null;
    }

    @Override
    public Stream<? extends Quad> stream(Optional<BlankNodeOrIRI> graphName, BlankNodeOrIRI subject, IRI predicate, RDFTerm object) {
        return null;
    }
}
