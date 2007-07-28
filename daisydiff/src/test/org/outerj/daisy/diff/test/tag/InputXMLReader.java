/*
 * Copyright 2007 Outerthought bvba and Schaubroeck nv
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.outerj.daisy.diff.test.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.outerj.daisy.diff.lcs.html.LeafComparator;
import org.outerj.daisy.diff.lcs.tag.TagComparator;
import org.xml.sax.SAXException;

/**
 * Reads XML data and passes the parsed result to a {@link LeafComparator}.
 */
public class InputXMLReader {

    public static TagComparator readXML(URL url) throws SAXException,
            IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url
                .openStream()));
        return new TagComparator(in);
    }

}
