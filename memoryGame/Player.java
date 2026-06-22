package ng;

public class Player {

	    public String name;
	    public int core;
	    
	    public Player(String n) {
	        this.name = n;
	        this.core = 0;
	    }
	    
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }
	    
	    public int getCore() { return core; }
	    public void setCore(int core) { this.core = core; }
	    
	    public void addScore(int c) { this.core += c; }
	
}
