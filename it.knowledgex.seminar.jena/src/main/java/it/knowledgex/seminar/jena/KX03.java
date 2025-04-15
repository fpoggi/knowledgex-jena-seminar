package it.knowledgex.seminar.jena;

import java.io.FileNotFoundException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;

public class KX03 {
	public static void main(String[] args) throws FileNotFoundException {
		String persone = "src/data/persona.ttl";
		String luoghi= "src/data/luogo.ttl";
		
		Model model = RDFDataMgr.loadModel(persone, Lang.TTL) ;

		// Read into an existing Model
		RDFDataMgr.read(model, luoghi) ;

		String queryString = "PREFIX ocd: <http://dati.camera.it/ocd/> \n" +
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n" +
			"PREFIX dc:  <http://purl.org/dc/elements/1.1/> \n" +
			"SELECT ?uri ?nome \n" +
			"WHERE { ?uri foaf:surname \"ROSSI\" ; \n" +
				"rdfs:label ?nome . \n" +
			"} ORDER BY ?nome ";
		
		Query query = QueryFactory.create(queryString) ;
		try (QueryExecution qexec = QueryExecutionFactory.create(queryString, model)) {
		    ResultSet results = qexec.execSelect() ;
		    /*
		    for ( ; results.hasNext() ; )
		    {
		      QuerySolution soln = results.nextSolution() ;
		      RDFNode uri = soln.get("uri") ; // Get a result variable by name.
		      RDFNode nome = soln.get("nome") ; // Get a result variable by name.
		      //Resource x = soln.getResource("varX") ; // Get a result variable - must be a resource
		      //Literal y = soln.getLiteral("VarY") ;   // Get a result variable - must be a literal
		      System.out.println(uri + " - " + nome);
		    }
		    */
		    
		    ResultSetFormatter.out(System.out, results) ;
		  
		}
		
	}
}
