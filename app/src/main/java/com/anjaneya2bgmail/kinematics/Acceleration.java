package com.anjaneya2bgmail.kinematics;

public class Acceleration extends Algorithm {

    Acceleration(Double iv, Double ti, Double fv, Double di, Double ac){
        super(iv, ti, fv, di, ac);
    }

    @Override
    public Boolean solve() {
        if (Vf!=null && Vi!=null && d!=null && t!=null) {
            a= (d-(Vi*t))/((1.0/2.0)*(t*t));

        } else if (Vi!=null && t!=null && d!=null){
            a = ((d-(Vi*t))/((0.5)*(t*t)));
            Vf = Math.sqrt((Vi*Vi)+(2*a*d));
        } else if (Vf!=null && Vi!=null && t!=null) {
            a = (Vf-Vi)/t;
            d = (t*(Vi+Vf))/2;
        } else if (Vf!=null && Vi!=null && d!=null) {
            a= ((Vf*Vf)-(Vi*Vi))/(2.0*d);
            t=(Vf-Vi)/a;
        } else if (Vf!=null && t!=null && d!=null) {
            Vi= ((2*d)-(t*Vf))/t;
            a = (d-(Vi*t))/((1.0/2.0)*(t*t));
        } else{
            return false;
        }
        return true;
    }
}
