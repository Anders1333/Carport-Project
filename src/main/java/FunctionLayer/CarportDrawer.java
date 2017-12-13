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
        if (carport.getShedDepth() > 0) {
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
                + "    <line x1=\"55\" y1=\"0\" x2=\"" + (shedStart) + "\" y2=\"" + (width) + "\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n"
                + "    <line x1=\"55\" y1=\"" + (width) + "\" x2=\"" + (shedStart) + "\" y2=\"0\" style=\"stroke:rgb(80,80,80);stroke-width:2\" />\n";

        return drawingHTML;
    }

    //--------------------- Carport with Roof -------------------------//
    public static String createDrawing2(Carport carport) {

        StringBuilder HTML = new StringBuilder();
        int shedStart = (carport.getLength() - 20) - carport.getShedDepth();
        int shedDepth = carport.getShedDepth();
        int width = carport.getWidth();
        int length = carport.getLength();
        int height = carport.getHeight();

        //--- Poles --- //
        //HTML.append(startPoles(width,length,shedDepth));
        HTML.append(poles(width, length, shedDepth));

        //--- Shed --- //
        if (carport.getShedDepth() > 0) {

            HTML.append(shedSpace(shedStart, 25, shedDepth, width - 50));
            HTML.append(shedPoles(shedStart, shedDepth, width));
        }

        //--- Rims --- //
        HTML.append(rims(width, length));

        //--- Gables --- //
        HTML.append(gables(width, length));

        //--- Rafters ---//
        HTML.append(rafters(width, length));

        // --- Roof Rafters --- //
        HTML.append(middleRoofRafter(width, length));
        HTML.append(topRafterPair(width, length));
        HTML.append(roofRafters1(width, length));
        HTML.append(roofRafters2(width, length));

        HTML.append(measuringLinesTopDown(width, length));

        return HTML.toString();

    }

    //------------------------- Carport SideView ---------------------------//
    public static String createDrawing3(Carport carport) throws CarportException {
        CarportCalculator cc = new CarportCalculator();

        StringBuilder HTML = new StringBuilder();
        int shedStart = (carport.getLength() - 20) - carport.getShedDepth();
        int shedDepth = carport.getShedDepth();
        int width = carport.getWidth();
        int length = carport.getLength();
        int height = carport.getHeight();
        double heightOfRoof = cc.getRoofHeight(carport);

        HTML.append(polesSide(length, height, heightOfRoof, shedStart, shedDepth));

        if (carport.getDegree() > 0) {
            HTML.append(raftersSideEnds(length, height, heightOfRoof));
            HTML.append(roofColoring(length, heightOfRoof));
        }

        if (carport.getShedDepth() > 0) {
            HTML.append(shedSide(shedStart, shedDepth, heightOfRoof, height));
            HTML.append(shedBoards(height, shedDepth, shedStart, heightOfRoof));
        }
        HTML.append(horizontalsSide(length, height, heightOfRoof));
        HTML.append(measuringLines(length, height, heightOfRoof));

        return HTML.toString();
    }

    //---- Premade rects for Carport SideView ---- //
    public static String measuringLines(int length, int height, double heightOfRoof) {
        String toAdd = "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"0\" y1=\"" + (heightOfRoof + height + 40) + "\" x2=\"" + (length) + "\" y2=\"" + (height + heightOfRoof + 40) + "\"></line>\n"
                + "<text x=\"" + ((length / 2) - 20) + "\" y=\"" + (height + heightOfRoof + 75) + "\" font-family=\"sans-serif\" font-size=\"30px\" fill=\"black\">" + (length + " " + "cm") + "</text>"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"0\" y1=\"" + (heightOfRoof + height + 50) + "\" x2=\"0\" y2=\"" + (height + heightOfRoof + 30) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length) + "\" y1=\"" + (heightOfRoof + height + 50) + "\" x2=\"" + (length) + "\" y2=\"" + (height + heightOfRoof + 30) + "\"></line>\n";

        toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (-55) + "\" y1=\"0\" x2=\"" + (-55) + "\" y2=\"" + (height + heightOfRoof) + "\"></line>\n"
                + "<text x=\"" + (-200) + "\" y=\"" + ((height + heightOfRoof) / 2) + "\" font-family=\"sans-serif\" font-size=\"30px\" fill=\"black\">" + ((height + heightOfRoof) + " " + "cm") + "</text>"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (-65) + "\" y1=\"0\" x2=\"" + (-45) + "\" y2=\"0\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (-65) + "\" y1=\"" + (height + heightOfRoof) + "\" x2=\"" + (-45) + "\" y2=\"" + (height + heightOfRoof) + "\"></line>\n";

        toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 55) + "\" y1=\"" + (heightOfRoof) + "\" x2=\"" + (length + 55) + "\" y2=\"" + (height + heightOfRoof) + "\"></line>\n"
                + "<text x=\"" + (length + 75) + "\" y=\"" + (((height + heightOfRoof) / 2) + 60) + "\" font-family=\"sans-serif\" font-size=\"30px\" fill=\"black\">" + height + " " + "cm" + "</text>"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 65) + "\" y1=\"" + (heightOfRoof) + "\" x2=\"" + (length + 45) + "\" y2=\"" + (heightOfRoof) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 65) + "\" y1=\"" + (heightOfRoof + height) + "\" x2=\"" + (length + 45) + "\" y2=\"" + (heightOfRoof + height) + "\"></line>\n";

        return toAdd;

    }

    public static String shedBoards(int height, int shedDepth, int shedStart, double heightOfRoof) {
        double boardsNeeded = Math.ceil(shedDepth / 10);
        String toAdd = "";
        for (int i = 1; i < boardsNeeded; i++) {
            int newSpot = i * 10;
            toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (shedStart + newSpot) + "\" y1=\"" + (heightOfRoof) + "\" x2=\"" + (shedStart + newSpot) + "\" y2=\"" + (height + heightOfRoof) + "\"></line>\n";
        }
        return toAdd;
    }

    public static String shedSide(int shedStart, int shedDepth, double heightOfRoof, int height) {
        String toAdd = "<rect x=\"" + (shedStart) + "\" y=\"" + (heightOfRoof) + "\" stroke-width=\"2px\" width=\"" + (shedDepth) + "\" height=\"" + (height) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String roofColoring(int length, double heightOfRoof) {
        String toAdd = "<rect x=\"5\" y=\"0\" stroke-width=\"2px\" width=\"" + (length - 10) + "\" height=\"" + (heightOfRoof) + "\" style=\"stroke:#000000; fill:#FF0000\"></rect>\n";
        return toAdd;
    }

    public static String raftersSideEnds(int length, int height, double heightOfRoof) {
        String toAdd = "<rect x=\"0\" y=\"0\" stroke-width=\"2px\" width=\"5\" height=\"" + (heightOfRoof) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "<rect x=\"" + (length - 5) + "\" y=\"0\" stroke-width=\"2px\" width=\"5\" height=\"" + (heightOfRoof) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String horizontalsSide(int length, int height, double heightOfRoof) {
        String toAdd = "<rect x=\"0\" y=\"" + (heightOfRoof) + "\" stroke-width=\"2px\" width=\"" + (length) + "\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String polesSide(int length, int height, double heightOfRoof, int shedStart, int shedDepth) {
        int backMargin = 25;
        int depth = 0;
        if (shedDepth > 0) {
            depth += shedDepth;
            backMargin = 0;
        }
        int areaToCover = length - depth - 80 - backMargin;
        double numberOfPoles = Math.ceil(areaToCover / 200);
        String toAdd = "<rect x=\"80\" y=\"" + (heightOfRoof) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (height) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        int alreadyCovered = 80;
        for (int i = 1; i < numberOfPoles + 1; i++) {
            toAdd += "<rect x=\"" + ((200 * i) + 80) + "\" y=\"" + (heightOfRoof) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (height) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        }

        return toAdd;
    }

    //-------------------Premade rects for Caport w/ roof -----------------//
    public static String measuringLinesTopDown(int width, int length) {

        String toAdd = "";

        //--- small sections ---//
        toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length) + "\" y1=\"" + (width + 10) + "\" x2=\"" + (length) + "\" y2=\"" + (width + 30) + "\"></line>\n";

        for (int i = 1; i < length; i += 89) {
            toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (i) + "\" y1=\"" + (width + 20) + "\" x2=\"" + (i + 89) + "\" y2=\"" + (width + 20) + "\"></line>\n"
                    + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (i) + "\" y1=\"" + (width + 10) + "\" x2=\"" + (i) + "\" y2=\"" + (width + 30) + "\"></line>\n";
        }

        //--- big bottom --- //
        toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (0) + "\" y1=\"" + (width + 50) + "\" x2=\"" + (length) + "\" y2=\"" + (width + 50) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (0) + "\" y1=\"" + (width + 40) + "\" x2=\"" + (0) + "\" y2=\"" + (width + 60) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length) + "\" y1=\"" + (width + 40) + "\" x2=\"" + (length) + "\" y2=\"" + (width + 60) + "\"></line>\n";

        //--- SideLine --- //
        toAdd += "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 25) + "\" y1=\"" + (0) + "\" x2=\"" + (length + 25) + "\" y2=\"" + (width) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 15) + "\" y1=\"" + (0) + "\" x2=\"" + (length + 35) + "\" y2=\"" + (0) + "\"></line>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" x1=\"" + (length + 15) + "\" y1=\"" + (width) + "\" x2=\"" + (length + 35) + "\" y2=\"" + (width) + "\"></line>\n"
                + "<text x=\"" + (length + 35) + "\" y=\"" + ((width / 2) + 10) + "\" font-family=\"sans-serif\" font-size=\"30px\" fill=\"black\">" + width + " " + "cm" + "</text>";

        //--- numbers --- //
        toAdd += "<text x=\"" + ((length / 2) - 10) + "\" y=\"" + (width + 70) + "\" font-family=\"sans-serif\" font-size=\"20px\" fill=\"black\">" + length + " " + "cm" + "</text>";
        for (int i = 36; i < length; i += 89) {
            toAdd += "<text x=\"" + (i) + "\" y=\"" + (width + 37) + "\" font-family=\"sans-serif\" font-size=\"18px\" fill=\"black\">" + 89 + "</text>";
        }
        return toAdd;
    }

    public static String gables(int width, int length) {
        String toAdd = "<rect x=\"25\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" stroke-dasharray=\"5,5\" x1=\"26\" y1=\"0\" x2=\"26\" y2=\"" + (width) + "\"></line>\n"
                + "<rect x=\"" + (length - 25) + "\" y=\"0\" stroke-width=\"1px\" width=\"3\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "<line style =\"stroke: black; stroke-width: 2px;\" stroke-dasharray=\"5,5\" x1=\"" + (length - 24) + "\" y1=\"0\" x2=\"" + (length - 24) + "\" y2=\"" + (width) + "\"></line>\n";
        return toAdd;
    }

    public static String roofRafters2(int width, int length) {
        String toAdd = "";
        double areaToCover = (width / 2) - 20;
        double numberOfRafters = Math.ceil(areaToCover / 35);

        for (int i = 38; i < numberOfRafters * 35; i += 35) {
            toAdd += "<rect x=\"0\" y=\"" + (width - i) + "\" stroke-width=\"1px\" width=\"" + (length) + "\" height=\"3\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        }
        return toAdd;
    }

    public static String roofRafters1(int width, int length) {
        String toAdd = "";
        double areaToCover = (width / 2) - 20;
        double numberOfRafters = Math.ceil(areaToCover / 35);

        for (int i = 35; i < numberOfRafters * 35; i += 35) {
            toAdd += "<rect x=\"0\" y=\"" + (i) + "\" stroke-width=\"1px\" width=\"" + (length) + "\" height=\"3\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        }
        return toAdd;
    }

    public static String topRafterPair(int width, int length) {
        String toAdd = "<rect x=\"0\" y=\"" + ((width / 2) - 10) + "\" stroke-width=\"1px\" width=\"" + (length) + "\" height=\"3\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        toAdd += "<rect x=\"0\" y=\"" + ((width / 2) + 7) + "\" stroke-width=\"1px\" width=\"" + (length) + "\" height=\"3\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String middleRoofRafter(int width, int length) {
        double rafterLocation = (width / 2) - 2;

        String toAdd = "<rect x=\"5\" y=\"" + rafterLocation + "\" stroke-width=\"1px\" width=\"" + (length - 10) + "\" height=\"4\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String rafters(int width, int length) {
        double numberOfRafters = Math.ceil(length / 89);
        String toAdd = "<rect x=\"89\" y=\"0\" stroke-width=\"1px\" width=\"4\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        for (int i = 2; i <= numberOfRafters; i++) {
            int offset = i * 89;
            toAdd += "<rect x=\"" + offset + "\" y=\"0\" stroke-width=\"1px\" width=\"4\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        }

        return toAdd;
    }

    public static String rims(int width, int length) {
        String toAdd
                = "   <rect x=\"25\" y=\"25\" stroke-width=\"2px\" width=\"" + (length - 45) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"25\" y=\"" + (width - 30) + "\" stroke-width=\"2px\" width=\"" + (length - 45) + "\" height=\"5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"0\" stroke-width =\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"5\" y=\"" + (width - 2.5) + "\" stroke-width=\"1px\" width=\"" + (length - 5) + "\" height=\"2.5\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   \n"
                + "   <rect x=\"0\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (length - 5) + "\" y=\"0\" stroke-width =\"1px\" width=\"5\" height=\"" + (width) + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        return toAdd;
    }

    public static String shedSpace(int x, int y, int width, int height) {

        String toAdd = "<rect x=\"" + x + "\" y=\"" + y + "\" stroke-width=\"2px\" width=\"" + width + "\" height=\"" + height + "\" fill-opacity=\"1.0\" style=\"stroke:#000000; fill:#B45F04\"></rect>\n";
        return toAdd;
    }

    public static String shedPoles(int shedstart, int shedDepth, int width) {
        String toAdd
                = "   <rect x=\"" + shedstart + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart + shedDepth - 10) + "\" y=\"25\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "   <rect x=\"" + (shedstart + shedDepth - 10) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"10\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";
        return toAdd;
    }

    public static String poles(int width, int length, int shedDepth) {

        int backMargin = 25;
        int depth = 0;
        if (shedDepth > 0) {
            depth += shedDepth;
            backMargin = 0;
        }
        int areaToCover = length - depth - 80 - backMargin;
        double numberOfPoles = Math.ceil(areaToCover / 200);
        String toAdd = "<rect x=\"80\" y=\"" + (25) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (10) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                + "<rect x=\"80\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (10) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        for (int i = 1; i < numberOfPoles + 1; i++) {
            toAdd += "<rect x=\"" + ((200 * i) + 80) + "\" y=\"" + (25) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (10) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n"
                    + "<rect x=\"" + ((200 * i) + 80) + "\" y=\"" + (width - 35) + "\" stroke-width=\"2px\" width=\"10\" height=\"" + (10) + "\" style=\"stroke:#000000; fill:#FE9A2E\"></rect>\n";

        }

        return toAdd;
    }

}
