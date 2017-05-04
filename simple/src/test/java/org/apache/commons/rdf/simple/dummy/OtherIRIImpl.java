package org.apache.commons.rdf.simple.dummy;

import org.apache.commons.rdf.api.IRI;

import java.net.URI;

/**
 * Created by Király Csombor on 2017. 05. 04..
 */
public class OtherIRIImpl implements IRI {

    private final String iri;

    public OtherIRIImpl(final String iri) {
        // should throw IllegalArgumentException on most illegal IRIs
        URI.create(iri);
        // NOTE: We don't keep the URI as it uses outdated RFC2396 and will get
        // some IDNs wrong
        this.iri = iri;
    }

    @Override
    public String getIRIString() {
        return iri;
    }

    @Override
    public String ntriplesString() {
        return "<" + getIRIString() + ">";
    }

    @Override
    public String toString() {
        return ntriplesString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IRI)) {
            return false;
        }
        final IRI other = (IRI) obj;
        return getIRIString().equals(other.getIRIString());
    }

    @Override
    public int hashCode() {
        return iri.hashCode();
    }

}