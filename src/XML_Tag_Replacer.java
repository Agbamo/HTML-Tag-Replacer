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
  // |             ...                                           |
  // |        oldTagN newTagN                                      |
  // |                                                            |
    // +------------------------------------------------------------+

public class XML_Tag_Replacer {

    private static String rutaClave = "C:\\Users\\05719450\\Desktop\\keys.txt" ;
    private static String rutaViejoXML = "C:\\Users\\05719450\\Desktop\\Prueba.xml" ;  
    private static String rutaNuevoXML = "C:\\Users\\05719450\\Desktop\\Final.xml" ;  
  
    private static List<String> etiquetasViejas = new ArrayList<String>();  
    private static List<String> etiquetasNuevas = new ArrayList<String>();  
    
    

    
    
    public static void main (String args[]) throws FileNotFoundException {
   
    cargarEtiquetas(rutaClave);
    //System.out.println("Etiqueta Vieja--"+etiquetasViejas.get(0));
    //System.out.println("Etiqueta Nueva--"+etiquetasNuevas.get(0));
    FileReader fr = null;
    BufferedReader br = null;
    PrintWriter writer = null;
    String linea;
       //Open the file for reading
       try {
         writer = new PrintWriter(rutaNuevoXML, "UTF-8");
         fr=new FileReader(rutaViejoXML);
         //BufferedReader br = new BufferedReader(new FileReader(rutaViejoXML));
         br = new BufferedReader(fr);
         while ((linea = br.readLine()) != null) { // while loop begins here
         System.out.println("linea1"+linea);
         linea = ReemplazarEtiquetas(linea);
         System.out.println("linea2"+linea);
         writer.println(linea);
         } // end while 
         writer.close();
       } // end try
       catch (IOException e) {
         System.err.println("Error: " + e);
       }finally{
          // En el finally cerramos el fichero, para asegurarnos
          // que se cierra tanto si todo va bien como si salta 
          // una excepcion.
          try{                    
             if( null != fr ){   
                fr.close(); 
                writer.close();
             }                  
          }catch (Exception e2){ 
             e2.printStackTrace();
          }
     }
    // } // end for

  } // end main
   
  private static void cargarEtiquetas(String ruta) throws FileNotFoundException {
    
    String linea;
    BufferedReader br = new BufferedReader(new FileReader(ruta)); 
         //Open the file for reading
         try {   
        
           while ((linea = br.readLine()) != null) { // while loop begins here
             
             String[] parts = linea.split(" ");
             etiquetasViejas.add(parts[0]);
             etiquetasNuevas.add(parts[1]);
             
             //System.out.println(linea);
           } // end while 
         } // end try
         catch (IOException e) {
           System.err.println("Error: " + e);
         } finally{
          // En el finally cerramos el fichero, para asegurarnos
          // que se cierra tanto si todo va bien como si salta 
          // una excepcion.
          try{                    
             if( null != br ){   
                br.close();
             }                  
          }catch (Exception e2){ 
             e2.printStackTrace();
          }
     }
  }
    
  public static String ReemplazarEtiquetas(String linea) {
   
   String nuevaLinea = linea;
   String lineaAux;
   int indice1;
   int indice2;
   
   for(int i = 0; i<etiquetasViejas.size(); i++) {
       
      /* if(linea.contains(etiquetasViejas.get(i))) {
         //String[] parts = linea.split(etiquetasViejas.get(i));
           if(!etiquetasViejas.get(i).contains("/")) {
               lineaAux = linea.substring(0, etiquetasViejas.get(i).length() - 1);
               nuevaLinea = etiquetasNuevas.get(i) + lineaAux;
              }else {
               lineaAux = linea.substring(linea.length() - etiquetasViejas.get(i).length(), linea.length() - 1);
               nuevaLinea = lineaAux + etiquetasNuevas.get(i);
              }
            }
        }*/
	     if(linea.contains(etiquetasViejas.get(i))) {
       //String[] parts = linea.split(etiquetasViejas.get(i));
         if(!etiquetasViejas.get(i).contains("/")) {
        	 indice1 = linea.indexOf("<");
        	 indice2 = linea.indexOf(":");
         }else {
             indice1 = linea.indexOf("/");
           	 indice2 = linea.indexOf(":");
            }
         lineaAux = linea.substring(indice1+1, indice2);
          }
      }
	   
	   
        return nuevaLinea;
       }
        //linea.replaceAll(etiquetasViejas.get(i), etiquetasNuevas.get(i));
        
        /*for(int i = 0; i<etiquetasViejas.size(); i++) {
           System.out.println("ReemplazarEtiquetaAntes");
           //linea.replaceAll(etiquetasViejas.get(i), etiquetasNuevas.get(i));
           linea=linea.replaceAll(etiquetasViejas.get(i), etiquetasNuevas.get(i));
           System.out.println("ReemplazarEtiquetasDespues"+linea);
         }
      for(int i = 0; i<etiquetasViejas.size(); i++) {
           System.out.println("ReemplazarEtiquetaAntes");
           //linea.replaceAll(etiquetasViejas.get(i), etiquetasNuevas.get(i));
           linea=linea.replace("<.*:", "<");
           System.out.println("ReemplazarEtiquetasDespues"+linea);
         }

         return linea; 
       }*/
       
     }