/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author Ismael
 */
public class Ruta implements Component{
    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private double distancia;

    public Ruta(String codi, String aeroportOri, String aeroportDes, double distancia) {
        this.codi = codi;
        this.aeroportOri = aeroportOri;
        this.aeroportDes = aeroportDes;
        this.distancia = distancia;
    }

    public String getCodi() {
        return codi;
    }

    public String getAeroportOri() {
        return aeroportOri;
    }

    public String getAeroportDes() {
        return aeroportDes;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setAeroportOri(String aeroportOri) {
        this.aeroportOri = aeroportOri;
    }

    public void setAeroportDes(String aeroportDes) {
        this.aeroportDes = aeroportDes;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
}
