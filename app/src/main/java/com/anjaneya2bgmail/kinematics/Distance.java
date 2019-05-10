package com.anjaneya2bgmail.kinematics;

public class Distance extends Algorithm {


    Distance(Double iv, Double ti, Double fv, Double di, Double ac){
        super(iv, ti, fv, di, ac);
    }

    @Override
    public Boolean solve()  {
        if (Vf!= null && Vi!= null && a!= null && t!= null) {
            d = ((Vi * t) + ((1.0 / 2.0) * (a * (t*t))));
        } else if (Vf!= null && a!= null && t!= null) {
            Vi = Vf-(a*t);
            d = (t*(Vi+Vf))/2;
        } else if (Vi!= null && a!= null && t!= null) {
            Vf = Vi+(a*t);
            d = (Vi*t)+((1.0/2.0)*(a*(t*t)));
        } else if (Vi!= null && a!= null && Vf!= null) {
            t = (Vf-Vi)/a;
            d = ((Vf*Vf)-(Vi*Vi))/(2*a);
        } else {
            return false;
        }
        return true;
    }


}
