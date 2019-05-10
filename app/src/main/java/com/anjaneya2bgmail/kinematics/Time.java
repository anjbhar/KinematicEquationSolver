package com.anjaneya2bgmail.kinematics;

public class Time extends Algorithm {

    Time(Double iv, Double ti, Double fv, Double di, Double ac){
        super(iv, ti, fv, di, ac);
    }

    @Override
    public Boolean solve() {
        if (Vf!= null && Vi!=null && a!=null && d!= null) {
            t = (Vf - Vi) / a;
        } else if (Vf!= null && Vi!= null && a!=null) {
            d = ((Vf * Vf) - (Vi * Vi)) / (2.0 * a);
            t = (Vf - Vi) / a;
        } else if (Vf!=null && a!=null && d!=null) {
            return false;
        } else if (Vi!=null&& a!=null && d!=null) {
            Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
            t = (Vf - Vi) / a;
        } else {
            return false;
        }
        return true;
    }

}
