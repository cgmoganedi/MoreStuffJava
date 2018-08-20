public class Point2D {

    private double x, y;

    Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Getter method for x
    public double x() {
        return x;
    }

    // Getter method for y
    public double y() {
        return y;
    }

    // Setter method for x
    public double[] position() {
        double [] pos = new double[2];
        pos[0] = this.x;
        pos[1] = this.y;
        return pos;
    }

    public Point2D translate(double dx, double dy){
        this.x += dx;
        this.y += dy;
        return this;
    }

    public void rotate(double degrees){
        this.x = x * Math.cos(degrees) + y * Math.sin(degrees);
        this.y = x * Math.sin(degrees) + y * Math.cos(degrees);
    }

    public void scale(double a, double b){
        this.x *= a;
        this.y *= b;
    }
    public void scale(double a){
        this.scale(a,a);
    }

    public Point2D horizontalShear(double b){
        this.x += this.y * b;
        return this;
    }
    public void verticalShear(double b){
        this.y += this.x * b;
    }

}
