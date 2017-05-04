package org.apache.commons.rdf.simple.dummy;

import org.apache.commons.rdf.api.RDFTerm;

/**
 * Created by Király Csombor on 2017. 05. 04..
 */
public class OtherRDFTermImpl implements RDFTerm {

    String term;

    public OtherRDFTermImpl(String term){
        this.term = term;
    }

    @Override
    public String ntriplesString() {
        return term;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof OtherRDFTermImpl))
            return false;
        OtherRDFTermImpl otherTerm = (OtherRDFTermImpl)other;
        if(term.equals(otherTerm.ntriplesString()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return term.hashCode();
    }

}
