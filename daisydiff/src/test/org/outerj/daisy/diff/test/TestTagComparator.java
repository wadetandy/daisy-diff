package org.outerj.daisy.diff.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.outerj.daisy.diff.DiffFileWriter;
import org.outerj.daisy.diff.lcs.rangecomparator.Atom;
import org.outerj.daisy.diff.lcs.rangecomparator.TagComparator;

public class TestTagComparator {

	public static void main(String[] args) throws Exception {
		new TestTagComparator();
	}
	
	
	public TestTagComparator() throws Exception{
		StringBuilder leftsb = new StringBuilder();
		
		String left = readResource("daisymain.txt");
//		String left = readResource("guy.txt");
//		for(int i=0;i<10;i++)
			leftsb.append(left);

		
        StringBuilder rightsb = new StringBuilder();
        String right = readResource("daisymainchanged.txt");
//        String right = readResource("guychanged.txt");
//        for(int i=0;i<10;i++)
        	rightsb.append(right);
        
        TagComparator lefttc = new TagComparator(leftsb);
        TagComparator righttc = new TagComparator(rightsb);
        
//        for(Atom atom : lefttc.getAtoms()){
//        	System.out.println(atom);
//        }
        
        DiffFileWriter.diff("/home/guy/workspace/daisydiff/src/test/org/outerj/daisy/diff/test/html"+
        		"/tag-word1.html", lefttc, righttc);
    	
        }
	
	String readResource(String name) throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("org/outerj/daisy/diff/test/txt/" + name);
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuilder buffer = new StringBuilder();
        int c = bufferedReader.read();
        while (c != -1) {
            buffer.append((char)c);
            c = bufferedReader.read();
        }

        return buffer.toString();
    }
}
