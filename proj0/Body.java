public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    final static double G = 6.67e-11;
    
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b1){
    /** calculate distance bewteen two bodies.*/
        double x_dis = this.xxPos - b1.xxPos;
        double y_dis = this.yyPos - b1.yyPos;
        double distance = Math.sqrt(x_dis * x_dis + y_dis * y_dis);
        return distance;
    }
    
    public double calcForceExertedBy(Body b1){
    /** calculate force between two bodies.*/
        double F;
        double r = this.calcDistance(b1);
        F = (G*this.mass*b1.mass)/(r*r);
        return F;
    }

    public double calcForceExertedByX(Body b1){
    /** Force project on X axis.*/
        double dx = b1.xxPos - this.xxPos;
        double r = this.calcDistance(b1);
        double F = this.calcForceExertedBy(b1);
        double Fx = F * dx/r;
        return Fx;
    }
    public double calcForceExertedByY(Body b1){
        double dy = b1.yyPos - this.yyPos;
        double r = this.calcDistance(b1);
        double F = this.calcForceExertedBy(b1);
        double Fy = F * dy/r;
        return Fy;
    }
    public double calcNetForceExertedByX(Body[] bodys){
        double sum_x = 0;
        for (Body b: bodys){
            if (this.equals(b)){
                continue;
            }
            else{
               sum_x += this.calcForceExertedByX(b);     
            }
        } 
        return sum_x;
    }
    public double calcNetForceExertedByY(Body[] bodys){
        double sum_y = 0;
        for (Body b: bodys){
            if (this.equals(b)){
                continue;
            }
            else{
               sum_y += this.calcForceExertedByY(b);     
            }
        } 
        return sum_y;
    }
    public void update(double dt, double fx, double fy){
        /** given force on X and Y axis and duration dt.
            update the body's velocity and position.*/
        double acc_x = fx/this.mass;
        double acc_y = fy/this.mass;
        double v_new_x = this.xxVel + (dt*acc_x);
        double v_new_y = this.yyVel + (dt*acc_y);
        this.xxVel = v_new_x;
        this.yyVel = v_new_y;
        double p_new_x = this.xxPos + dt * v_new_x;
        double p_new_y = this.yyPos + dt * v_new_y;
        this.xxPos = p_new_x;
        this.yyPos = p_new_y;
    }
    
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
    
    
}
