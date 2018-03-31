import java.io.*;
import java.util.ArrayList;
import java.util.List;

	// +------------------------------------------------------------+
    // |                                                            |
	// |    Replaces flags in a XML document using a .txt file,     |
	// |    located in the root directory, containing the key       |
	// |    using the following format:                             |
    // |                                                            |
	// |        oldTag1 newTag1                                     |
	// |       		  ...                                           |
	// |        oldTagN newTagN	                                    |
	// |                                                            |
    // +------------------------------------------------------------+

public class XML_LineByLine_Reader {

	  private static List<String> etiquetasViejas = new ArrayList<String>();  
	  private static List<String> etiquetasNuevas = new ArrayList<String>();  
	  static String linea;
	  private static String rutaClave = "./keys.txt" ;
	  private static String rutaViejoXML = "./source.xml" ;	
	  private static String rutaNuevoXML = "./outPut.xml" ;	
	  
	  public static void main (String args[]) {

		cargarEtiquetas(rutaClave);
	 
	  // //Loop across the arguments
	  // for (int i=0; i < args.length; i++) {
	 
	     //Open the file for reading
	     try {
	       PrintWriter writer = new PrintWriter(rutaNuevoXML, "UTF-8");
	       BufferedReader br = new BufferedReader(new FileReader(rutaViejoXML));
	       while ((linea = br.readLine()) != null) { // while loop begins here
	    	 linea = ReemplazarEtiquetas(linea);
	    	 writer.println(linea);
	       } // end while 
	       writer.close();
	     } // end try
	     catch (IOException e) {
	       System.err.println("Error: " + e);
	     }
	  // } // end for

	} // end main
	 
	private static void cargarEtiquetas(String ruta) {
		
		String linea;
		 
		     //Open the file for reading
		     try {
		       BufferedReader br = new BufferedReader(new FileReader(ruta));
		       while ((linea = br.readLine()) != null) { // while loop begins here
		    	   
		    	   String[] parts = linea.split(" ");
		    	   etiquetasViejas.add(parts[0]);
		    	   etiquetasNuevas.add(parts[1]);
		    	   
		         System.out.println(linea);
		       } // end while 
		     } // end try
		     catch (IOException e) {
		       System.err.println("Error: " + e);
		     }
	}
	  
	public static String ReemplazarEtiquetas(String linea) {
		  
		for(int i = 0; i<etiquetasViejas.size(); i++) {
			
			linea.replaceAll(etiquetasViejas.get(i), etiquetasNuevas.get(i));

		}
		  	
		return linea; 
	}
	
}
