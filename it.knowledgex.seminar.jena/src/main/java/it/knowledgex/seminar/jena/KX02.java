package it.knowledgex.seminar.jena;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.vocabulary.RDFS;

public class KX02 {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		String maco = "http://www.semanticweb.org/alessandro.moramarco/ontologies/2025/1/untitled-ontology-26#";
		
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel() ;
		
		model.read("src/data/ontology_v2.owl", "RDF/XML");
		System.out.println("DONE");
		
		Resource process = model.getResource(maco + "Process");
		
		//model.createResource("URI_XYZ")
		process.addProperty(RDFS.label, "A series of actions or steps taken in order to achieve a particular end");
		
		OutputStream out = new FileOutputStream("src/data/test02.ttl");
		RDFDataMgr.write(out, model, RDFFormat.TURTLE); //Lang.TURTLE);
		/*
		OutputStream out = new FileOutputStream("output-model.ttl");
		RDFDataMgr.write(out, model, Lang.TURTLE);
		or:

		OutputStream out = new FileOutputStream("output-model.ttl");
		model.write(out, Lang.TURTLE);
		*/
	}

}
