/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.rdf.simple;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.rdf.api.AbstractGraphTest;
import org.apache.commons.rdf.api.RDF;
import org.apache.commons.rdf.simple.dummy.OtherIRIImpl;
import org.apache.commons.rdf.simple.dummy.OtherLiteralImpl;
import org.apache.commons.rdf.simple.dummy.OtherRDFTermImpl;
import org.junit.Assume;
import org.junit.Test;

/**
 * Test SimpleRDF with AbstractGraphTest
 */
public class SimpleGraphTest extends AbstractGraphTest {

    @Override
    public RDF createFactory() {
        return new SimpleRDF();
    }

    @Test
    public void graphToString() {
        Assume.assumeNotNull(aliceName, companyName);
        // System.out.println(graph);
        assertTrue(
                graph.toString().contains("<http://example.com/alice> <http://xmlns.com/foaf/0.1/name> \"Alice\" ."));
        assertTrue(graph.toString().contains(" <http://xmlns.com/foaf/0.1/name> \"A company\" ."));

    }

    //Updated by Király Csombor

    @Test
    public void testInternallyMap(){
        SimpleRDF f = new SimpleRDF();
        GraphImpl g = new GraphImpl(f);

        OtherIRIImpl s = new OtherIRIImpl("s");
        IRIImpl p = new IRIImpl("p");
        OtherLiteralImpl o = new OtherLiteralImpl("o");
        OtherLiteralImpl o2 = new OtherLiteralImpl("alma", "hu");

        g.add(s, p, o);
        g.add(s, p, o2);

        assertEquals(2, g.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInternallyMapException(){
        SimpleRDF f = new SimpleRDF();
        GraphImpl g = new GraphImpl(f);

        IRIImpl s = new IRIImpl("s");
        IRIImpl p = new IRIImpl("p");
        OtherRDFTermImpl o = new OtherRDFTermImpl("o");

        g.add(s, p, o);
    }

    @Test
    public void testInternallyMapTriples(){
        SimpleRDF f = new SimpleRDF();
        GraphImpl g = new GraphImpl(f);

        TripleImpl triple = new TripleImpl(new IRIImpl("s"), new IRIImpl("p"),new OtherLiteralImpl("o"));

        g.add(triple);

        assertEquals(1, g.size());
    }

}
