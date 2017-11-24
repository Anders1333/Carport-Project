package PresentationLayer;

import FunctionLayer.CarportException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;
    
  
    // Initiating commands by putting them in a hashmap.
    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("buildCarport", new CarportBuilder());
        commands.put("getOrders" , new OrderGetter());
        commands.put("getUsers" , new UserGetter());
        commands.put("packList" , new PackListGetter());
    }

    
    // Takes whatever value is for the hidden value "command" (eks. "login")
    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        
        // Returns either command name or if null a unknown command.
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws CarportException;

}
