package it.knowledgex.seminar.jena.reasoning;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

public class OntoCreator {
	
	public static String ONTO_NS = "https://w3id.org/knowledgex/ontology#"; 
	
	public static OntModel create() {
		OntModel onto = ModelFactory.createOntologyModel();
		
		OntClass human = onto.createClass(ONTO_NS + "Human");
		OntClass ai = onto.createClass(ONTO_NS + "AI");
		OntClass agent = onto.createClass(ONTO_NS + "Agent");
		agent.addSubClass(human);
		agent.addSubClass(ai);
		
		human.addDisjointWith(ai);
		return onto;
	}

}
