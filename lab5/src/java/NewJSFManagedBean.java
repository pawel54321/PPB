/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author pawlo
 */
@Named(value="newJSFManagedBean")
@ManagedBean
@SessionScoped
public class NewJSFManagedBean {
  
    double k;
    double n;          
    double b;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    
    public NewJSFManagedBean() {
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
