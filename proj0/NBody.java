public class NBody{
    
    /** read universe radius from data/planets.txt*/
    public static double readRadius(String file){
        In in = new In(file);
        
        int n_planets = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }
    
    /** read file and get an array of Body*/
    public static Body[] readBodies(String file){
        In in = new In(file);
        Body[] b = new Body[5];
        int n_planets = in.readInt();
        double Radius = in.readDouble();
        for(int i=0; i<5; i++){
            double xp = in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m  = in.readDouble();
            String img  = in.readString();
            
            Body b1 = new Body(xp, yp, xv, yv, m, img);
            b[i] = b1;
            
        }
        return b;
    }
    
    public static void main(String[] args){
        // command line arguments: time scale
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        
        double radius = readRadius(filename);
        Body[] bodies =  readBodies(filename);
        
        // Drawing the Background
        StdDraw.setScale(-radius, radius);
        
        /** Enables double buffering.
        * A animation technique where all drawing takes place on the offscreen canvas.
        * Only when you call show() does your drawing get copied from the
        * offscreen canvas to the onscreen canvas, where it is displayed
        * in the standard drawing window. */
        StdDraw.enableDoubleBuffering();

        String starfield = "images/starfield.jpg";
        
        // Draw the bodies
        int n = bodies.length;
        
        double t = 0;
        while (t<=T){
            StdDraw.clear();
            StdDraw.picture(0, 0, starfield);
            double[] xForces = new double [n], 
                     yForces = new double [n];
            for (int i=0; i<n; i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i=0; i<n; i++){
                bodies[i].update(dt, xForces[i], yForces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        // when time out, print out the final state
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                        bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}
