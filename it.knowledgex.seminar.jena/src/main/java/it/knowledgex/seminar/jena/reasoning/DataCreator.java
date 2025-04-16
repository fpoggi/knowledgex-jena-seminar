package it.knowledgex.seminar.jena.reasoning;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;

public class DataCreator {
	
	public static String DATA_NS = "https://w3id.org/knowledgex/data/";
	
	public static Model create() {
		
		Model model = ModelFactory.createDefaultModel();
		
		Resource andrea = ResourceFactory.createResource(DATA_NS + "Andrea");
		Resource agent =  ResourceFactory.createResource(OntoCreator.ONTO_NS + "Human");
		//Resource ai =  ResourceFactory.createResource(OntoCreator.ONTO_NS + "AI");
		
		model.add(andrea, RDF.type, agent);
		
		return model;
	}

}
