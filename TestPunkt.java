class Punkt{
    private double x;
    private double y;
    private String name;

    public Punkt(double x, double y, String name){
        this.x = x;
        this.y = y;
        this.name = name;

    }
    public double getX(){ return x; }
    public double getY(){ return y; }
    public String getName(){ return name; }
    public void setX(double x){ this.x = x; }
    public void setY(double y){ this.y = y; }
    public void setName(String name){
        if(name!=null)
            this.name = name;
        else
            throw new IllegalArgumentException("name cannot be null");
    }
    @Override
    public String toString(){
        return "Punkt{x=" + x + ", y=" + y + ", name=" + name + "}";
    }

}

public class TestPunkt {
    public static void main(String[] args) {

    }
}
