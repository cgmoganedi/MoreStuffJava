
public class GeometricShape {

    private Point2D [] vertices;

    GeometricShape(String name){

        switch (name){
            case "triangle":
                triangle();
                break;
            case "octagon":
                octagon();
                break;
            default:
                point();
                break;

        }
    }

    private void point(){
        vertices = new Point2D[1];
        for(int i = 0; i < 1; i++){
            vertices[i] = new Point2D(5 *Math.random(),5*Math.random());
        }
    }

    private void triangle(){
        vertices = new Point2D[3];
        for(int i = 0; i < 3; i++){
            vertices[i] = new Point2D(5 *Math.random(),5*Math.random());
        }
    }

    private void octagon(){
        vertices = new Point2D[8];
        for(int i = 0; i < 8; i++){
            vertices[i] = new Point2D(5 *Math.random(),5*Math.random());
        }
    }

    public GeometricShape translate(double dx, double dy){
        for(int i = 0 ; i<vertices.length; i++){
            vertices[i] = vertices[i].translate(dx, dy);
        }
        return this;
    }

    public GeometricShape horizontalShear(double b){
        for(int i = 0 ; i<vertices.length; i++){
            vertices[i] = vertices[i].horizontalShear(b);
        }
        return this;
    }

    public void print(){

        for(int j = 0; j<vertices.length; j++){
            System.out.print("( ");
            System.out.print( vertices[j].x() + ", "+ vertices[j].y() + " ");
            System.out.println(")");

        }
    }

}
