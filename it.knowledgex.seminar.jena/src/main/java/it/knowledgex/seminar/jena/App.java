package it.knowledgex.seminar.jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFWriter;
import org.apache.jena.vocabulary.VCARD;

/**
 * Hello world!
 */
public class App {
	
	public static void main(String[] args) {
		// some definitions
		String personURI    = "http://somewhere/JohnSmith";
		String fullName     = "John Smith";

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();
		
		// create the resource
		Resource johnSmith = model.createResource(personURI);

		// add the property
		johnSmith.addProperty(VCARD.FN, fullName);

		Resource francescoPoggi = createPerson(model, "Francesco", "Poggi");
		Resource andreaNuzzolese = createPerson(model, "Andrea Giovanni", "Nuzzolese");
		
		// now write the model in XML form to a file
		model.write(System.out, "TURTLE");
		
		RDFWriter.source(model)
	     //.set(RIOT.symTurtleIndentStyle, "long")
	     .lang(Lang.RDFXML)
	     .output(System.out);
	}

	public static Resource createPerson(Model model, String gn, String fn) {
		// some definitions
		String personURI    = "http://somewhere/" + gn.replace(" ", "_") + fn;
		String givenName    = gn;
		String familyName   = fn;
		String fullName     = givenName + " " + familyName;

		// create an empty Model
		//Model model = ModelFactory.createDefaultModel();

		// create the resource
		//   and add the properties cascading style
		Resource person
		  = model.createResource(personURI)
		         .addProperty(VCARD.FN, fullName)
		         .addProperty(VCARD.N,
		                      model.createResource()
		                           .addProperty(VCARD.Given, givenName)
		                           .addProperty(VCARD.Family, familyName));
		return person;
		
	}
}
