package com.anjaneya2bgmail.kinematics;

public abstract class Algorithm {
    Double a,t,d,Vf,Vi;

    Algorithm(Double iv, Double ti, Double fv, Double di, Double ac){
        Vi = iv;
        t = ti;
        Vf = fv;
        d = di;
        a = ac;
    }

    public abstract Boolean solve();

    public Double getA() {
        return a;
    }

    public Double getT() {
        return t;
    }

    public Double getD() {
        return d;
    }

    public Double getVf() {
        return Vf;
    }

    public Double getVi() {
        return Vi;
    }
}
