/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author AndersHC
 */
public class CarportDrawer {

    public static String createDrawing1(Carport carport) throws CarportException {

        int length = carport.getLength();
        int width = carport.getWidth();
        int height = carport.getHeight();
        double roofIncline = carport.getDegree();
        int shedDepth = carport.getShedDepth();
        double numberOfRafters = Math.ceil(carport.getLength() / 55);
        int shedStart = (carport.getLength() - 20) - shedDepth;

        
        
        
         String drawingHTML = "";
        
        
       // Placing poles //
       
        drawingHTML
                += // --- Placing Poles --- //
                "   <rect x=\"80\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"80\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        for (int i = 280; i < length; i += 200) {
            drawingHTML
                    += "   <rect x=\"" + i + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                    + "   <rect x=\"" + i + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                    + "   \n";
        }
        
         // Shed //
         
             if(carport.getShedDepth()>0){
        drawingHTML
                
                += "   <rect x=\"" + (shedStart) + "\" y=\"" + 25 + "\" stroke-width=\"2px\" width=\"" + (shedDepth) + "\" height=\"" + (width - 50) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#B45F04\"></rect>\n"
                + "   <rect x=\"" + (shedStart) + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedStart + shedDepth - 10) + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedStart) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedStart + shedDepth - 10) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
             }
        //--- Placing CrossBeams --- //
        drawingHTML
                += "   <rect x=\"5\" y=\"25\" stroke-width=\"2px\" width=\"" + (length - 5) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"" + (width - 30) + "\" stroke-width=\"2px\" width=\"" + (length - 5) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + //--- Placing Horizontal Rims --- //
                "   <rect x=\"5\" y=\"0\" stroke-width =\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"" + (width - 2.5) + "\" stroke-width=\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   \n"
                + "   <rect x=\"0\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (length) + "\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        // Placing Horizontal Rafters //

        drawingHTML
                += "    <rect x=\"55\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        for (int i = 2; i <= numberOfRafters; i++) {
            int offset = i * 55;
            drawingHTML += "<rect x=\"" + offset + "\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        }
        drawingHTML
                += "    <!-- Placing Cross Stabilizer beams -->\n"
                + "    <line x1=\"55\" y1=\"0\" x2=\"" + (numberOfRafters * 55) + "\" y2=\"" + (width) + "\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n"
                + "    <line x1=\"55\" y1=\"" + (width) + "\" x2=\"" + (numberOfRafters * 55) + "\" y2=\"0\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n";

        return drawingHTML;
    }
    
    
    
    
    
    public static String createDrawing2(Carport carport){
        
        StringBuilder HTML = new StringBuilder(); 
        int shedStart = (carport.getLength() - 20) - carport.getShedDepth();  
        int shedDepth = carport.getShedDepth();
        
        //--- Poles --- //
        
        HTML.append(startPoles(carport));
        HTML.append(poles(carport));
        
        //--- Shed --- //
        if(carport.getShedDepth()>0){
            
        HTML.append(shedSpace(carport,shedStart,25,carport.getShedDepth(),carport.getWidth()-50));
        HTML.append(shedPoles(carport,shedStart,shedDepth,carport.getWidth()));       
        }
        
        //--- Rims --- //
        
        HTML.append(rims(carport.getWidth(),carport.getLength()));
        
        //--- Rafters --//
        
        HTML.append(rafters(carport,carport.getWidth(),carport.getHeight()));
        
        
        
        
        
        
        
        
        return HTML.toString();
        
    }
    
    //---- Premade rects ---- //
    
    
    
    
    
    
    
    
    
    
    
    public static String rafters (Carport carport,int width, int length){
        double numberOfRafters = Math.ceil(carport.getLength()/89);
        String toAdd = "<rect x=\"89\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        for (int i = 2; i <= numberOfRafters; i++) {
            int offset = i * 89;
            toAdd += "<rect x=\"" + offset + "\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        }
        
        
        return toAdd;
    }
    
    

    
    
    
    public static String rims(int width, int length){
   String toAdd= 
                  "   <rect x=\"5\" y=\"25\" stroke-width=\"2px\" width=\"" + (length - 5) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"" + (width - 30) + "\" stroke-width=\"2px\" width=\"" + (length - 5) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"0\" stroke-width =\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"" + (width - 2.5) + "\" stroke-width=\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   \n"
                + "   <rect x=\"0\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (length) + "\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
   
   return toAdd;
    }
    
 
    public static String shedSpace (Carport carport,int x,int y,int width,int height){
        
        String toAdd = "<rect x=\"" + x + "\" y=\"" + y + "\" stroke-width=\"2px\" width=\"" + width + "\" height=\"" + height + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#B45F04\"></rect>\n";
        return toAdd;
    }
    
    
    
    public static String shedPoles(Carport carport,int shedstart, int shedDepth,int width){
        String toAdd =
               "   <rect x=\"" + shedstart + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart + shedDepth - 10) + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart + shedDepth - 10) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }
    
    
    public static String poles(Carport carport){
        
        String toAdd = "";
      for (int i = 280; i < carport.getLength(); i += 200) {
          
          toAdd +=    "   <rect x=\"" + i + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                    + "   <rect x=\"" + i + "\" y=\"" + (carport.getWidth() - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                    + "   \n";
      }
      return toAdd;
    }
    
    
    
    public static String startPoles(Carport carport){
       
        
        String toAdd = "   <rect x=\"80\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                     + "   <rect x=\"80\" y=\"" + (carport.getWidth() - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
            
          return toAdd;      
    }
    
    
    
}
