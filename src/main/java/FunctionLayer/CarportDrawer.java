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

    public static String createDrawing(Carport carport) throws CarportException {

        String drawingHTML = "   \n" +
"   <!-- Placing Poles ( Width, carport.getVerticalPoles  -->\n" +
"  \n" +
"   <rect x=\"80\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <rect x=\"80\" y=\"<%=width-35%>\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <% for ( int i = 280; i < length ; i+=200){%>\n" +
"  \n" +
"   <rect x=\"<%=i%>\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <rect x=\"<%=i%>\" y=\"<%=width-35%>\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <%}%>\n" +
"  \n" +
"   <!-- Placing crossbeams-->\n" +
"   <rect x=\"5\" y=\"25\" stroke-width=\"2px\" width=\"<%=length-5%>\" height=\"5\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <rect x=\"5\" y=\"<%=width-30%>\" stroke-width=\"2px\" width=\"<%=length-5%>\" height=\"5\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   \n" +
"   \n" +
"   \n" +
"     <!-- Placing Horizontals (rim) -->\n" +
"   <rect x=\"5\" y=\"0\" stroke-width =\"1px\" width=\"<%=length-5%>\" height=\"2.5\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <rect x=\"5\" y=\"<%= width-2.5%>\" stroke-width=\"1px\" width=\"<%=length-5%>\" height=\"2.5\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   \n" +
"   <rect x=\"0\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"<%=width%>\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"   <rect x=\"<%=length%>\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"<%=width%>\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"\n" +
"   \n" +
"    <!-- Placing Horizontals (Rafters) -->\n" +
"    <rect x=\"55\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"<%=width%>\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"    <% for ( int i = 2; i <= numberOfRafters; i++) {%>\n" +
"    <% int offset = i*55;%>\n" +
"    <rect x=\"<%=offset%>\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"<%=width%>\" fill-opacity=\"0.0\" style=\"stroke:#000000; fill:#ffffff\"></rect>\n" +
"    <%}%> \n" +
"\n" +
"    <!-- Placing Cross Stabilizer beams -->\n" +
"    <line x1=\"55\" y1=\"0\" x2=\"<%=(numberOfRafters)*55%>\" y2=\"<%=width%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    <line x1=\"55\" y1=\"<%=width%>\" x2=\"<%=(numberOfRafters)*55%>\" y2=\"0\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    \n" +
"    <!-- Placing measuring lines -->\n" +
"    <line x1=\"5\" y1=\"<%=width+20%>\" x2=\"<%=length%>\" y2=\"<%=width+20%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    <line x1=\"5\" y1=\"<%=width+10%>\" x2=\"5\" y2=\"<%=width+30%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    <line x1=\"<%=length%>\" y1=\"<%=width+10%>\" x2=\"<%=length%>\" y2=\"<%=width+30%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    \n" +
"    <line x1=\"<%=length+30%>\" y1=\"0\" x2=\"<%=length+30%>\" y2=\"<%=width%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    <line x1=\"<%=length+20%>\" y1=\"0\" x2=\"<%=length+40%>\" y2=\"0\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    <line x1=\"<%=length+20%>\" y1=\"<%=width%>\" x2=\"<%=length+40%>\" y2=\"<%=width%>\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n" +
"    \n" +
"    <!-- Placing numbers -->\n" +
"    <text x=\"<%=(length/2)-40%>\" y=\"<%=width+50%>\" font-family=\"sans-serif\" font-size=\"15px\"><%=length%> cm</text>\n" +
"    <text x=\"<%=length + 50%>\" y=\"<%=width/2%>\" font-family=\"sans-serif\" font-size=\"15px\"><%=height%> cm</text>\n" +
"";

        return drawingHTML;
    }
}
