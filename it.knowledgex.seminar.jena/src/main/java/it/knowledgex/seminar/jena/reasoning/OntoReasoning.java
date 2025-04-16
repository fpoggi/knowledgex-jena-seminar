package it.knowledgex.seminar.jena.reasoning;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;

public class OntoReasoning {
	private Model ontology;
	private Model data;
	
	public OntoReasoning(Model ontology, Model data) {
		this.ontology = ontology;
		this.data = data;
	}
	
	public Model getOntology() {
		return this.ontology;
	}
	
	public Model getData() {
		return this.data;
	}
	
	public InfModel getKnowledgeGraph() {
		
		InfModel infModel = ModelFactory.createInfModel(ReasonerRegistry.getOWLReasoner(), this.getOntology(), this.getData());
		return infModel;
	}
	
	public static void main(String[] args) {
		Model data = DataCreator.create();
		OntModel ontology = OntoCreator.create();
		
		OntoReasoning ontoReasoning = new OntoReasoning(data, ontology);
		InfModel kg = ontoReasoning.getKnowledgeGraph();
		
		
		ValidityReport vr = kg.validate();
		if(kg.validate().isValid()) {
			Resource andrea = kg.getResource(DataCreator.DATA_NS + "Andrea");
			StmtIterator stmtIt = kg.listStatements(andrea, null, (RDFNode) null);
			stmtIt.forEach(stmt -> {System.out.println(stmt);});
		}
		else {
			vr.getReports().forEachRemaining(report -> {System.out.println(report.getDescription());});
		}
	}

}
