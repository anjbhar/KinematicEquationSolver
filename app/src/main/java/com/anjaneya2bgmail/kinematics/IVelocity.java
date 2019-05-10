package com.anjaneya2bgmail.kinematics;

public class IVelocity extends Algorithm {

    IVelocity(Double iv, Double ti, Double fv, Double di, Double ac){
        super(iv, ti, fv, di, ac);
    }

    @Override
    public Boolean solve()  {
        if (Vf!= null && d!= null && a!= null && t!= null) {
            Vi = ((d-(1.0/2.0)*a*(t*t)))/t;
        } else if (d!= null && a!= null && t!= null) {
            Vi = (d-(1.0/2.0)*a*(t*t))/t;
            Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
        } else {
            return false;
        }
        return true;
    }
}
