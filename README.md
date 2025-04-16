# knowledgex-jena-seminar

Questo progetto è composto da un file POM Maven, codice sorgente Java e alcuni data files.

Per i nostri scopi i file Java di esempio possono essere compilati ed eseguiti da command line, oppure all'interno di un IDE (es. Eclipse, IntelliJ IDEA, ecc.).

**Requisiti:** 
* Jena5 richiede **Java 17 o una versione successiva** di Java (può essere installato con l'installer di Eclipse IDE, vedi istruzioni setup).
* **Apache Maven 3+** (vedi [guida installazione](https://maven.apache.org/install.html)).

**Setup con IDE Eclipse:**
1. Installare Eclipse (l'[installer](https://www.eclipse.org/downloads/packages/) verifica sia installata una versione recente di Java, oppure procede ad installarla. Se durante l'installazione viene richiesto, scegliere di configurare "Eclipse IDE for Java Developers" oppure "Eclipse IDE for Enterprise Java and Web Developers")
2. Clonare questo repository localmente
3. Importare il repository clonato come progetto Maven in Eclipse (```File -> Import -> Existing Maven Project```) - eventualmente seguendo le indicazioni alla sezione "Simple Project" alla pagina (https://maven.apache.org/plugins/maven-eclipse-plugin/usage.html#Simple_Project)
3. Aggiornare progetto Maven in Eclipse (```tasto destro sul progetto importato -> Maven -> Update Project...```)

Provare ad eseguire una delle classi di esempio (es. file ```KX01.java```) - ```tasto destro sul file -> Run As -> Java Application```.

In caso di problemi provare a lanciare il comando ```mvn clean install``` (da eclipse ```tasto destro sul progetto -> Run As -> Maven clean```, e poi ancora ```tasto destro sul progetto -> Run As -> Maven install```). Verificare anche la corretta impostazione del build path.

