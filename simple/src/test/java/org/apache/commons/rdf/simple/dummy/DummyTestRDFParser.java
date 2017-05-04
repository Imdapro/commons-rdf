package org.apache.commons.rdf.simple.dummy;

import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.Quad;
import org.apache.commons.rdf.api.RDF;
import org.apache.commons.rdf.api.RDFSyntax;
import org.apache.commons.rdf.experimental.RDFParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Created by Csaba Kothencz on 2017. 05. 04.
 */
public class DummyTestRDFParser implements RDFParser {
    @Override
    public RDFParser rdfTermFactory(RDF rdfTermFactory) {
        return this;
    }

    @Override
    public RDFParser contentType(RDFSyntax rdfSyntax) throws IllegalArgumentException {
        return this;
    }

    @Override
    public RDFParser contentType(String contentType) throws IllegalArgumentException {
        return this;
    }

    @Override
    public RDFParser target(Consumer<Quad> consumer) {
        return this;
    }

    @Override
    public RDFParser base(IRI base) {
        return this;
    }

    @Override
    public RDFParser base(String base) throws IllegalArgumentException {
        return this;
    }

    @Override
    public RDFParser source(InputStream inputStream) {
        return this;
    }

    @Override
    public RDFParser source(Path file) {
        return this;
    }

    @Override
    public RDFParser source(IRI iri) {
        return this;
    }

    @Override
    public RDFParser source(String iri) throws IllegalArgumentException {
        return this;
    }

    @Override
    public Future<? extends ParseResult> parse() throws IOException, IllegalStateException {
        return null;
    }
}
