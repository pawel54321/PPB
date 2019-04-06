package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawlo
 */
public class NewClass {
    
    double k;
    double n;          
    double b;

    public NewClass() {
    }

    public double obliczRaty()
    {
        //System.out.println(k+" "+n+" "+b);
        
        double q;
        q = 1+(b/12);

        double R;     
        R=k*(Math.pow(q,n))*(q-1)/(Math.pow(q, n)-1);
                        
    return R;
    }

    public double getK() {
        return k;
    }

    public double getN() {
        return n;
    }

    public double getB() {
        return b;
    }
 

    public void setK(double k) {
        this.k = k;
    }

    public void setN(double n) {
        this.n = n;
    }

    public void setB(double b) {
        this.b = b;
    }

                        

}
