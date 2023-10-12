package Factory;

public class GhostFactory {
    public Ghost createGhost(String ghostName)
    {
        if(ghostName == null){
         return null;
        }		
        if(ghostName.equalsIgnoreCase("PINKY")){
            return new Pinky();
            
        } else if(ghostName.equalsIgnoreCase("Blinky")){
            return new Blinky();
            
        } else if(ghostName.equalsIgnoreCase("Clyde")){
            return new Clyde();
        } else if(ghostName.equalsIgnoreCase("Inky")){
            return new Inky();
        }
        return null;
        
    }
}
