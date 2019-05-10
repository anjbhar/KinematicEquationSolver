package com.anjaneya2bgmail.kinematics;

public class FVelocity extends Algorithm {


    FVelocity(Double iv, Double ti, Double fv, Double di, Double ac){
        super(iv, ti, fv, di, ac);
    }

    @Override
    public Boolean solve()  {
        if (Vi!= null && d!= null && a!= null && t!= null) {
            Vf = Math.sqrt((Vi * Vi) + (2.0 * a * d));
        } else {
            return false;
        }
        return true;
    }


}
