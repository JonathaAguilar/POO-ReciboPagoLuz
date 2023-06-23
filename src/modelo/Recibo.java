package modelo;

public class Recibo {
    
    int numRecibo, tipoSer;
    String nombre, domicilio, fecha;
    float costoK, kiCon;
    
    
    public Recibo (){
       numRecibo=0;
       tipoSer=0;
       nombre="";
       domicilio="";
       fecha="";
       costoK=0.0f;
       kiCon=0.0f;
    }
    
    public Recibo (Recibo rec){
       numRecibo=rec.numRecibo;
       tipoSer=rec.tipoSer;
       nombre=rec.nombre;
       domicilio=rec.domicilio;
       fecha=rec.fecha;
       costoK=rec.costoK;
       kiCon=rec.kiCon;
    }
    
            public Recibo (int numRecibo, int tipoSer, String nombre, String domicilio, String fecha, float costoK, float kiCon){
       this.numRecibo = numRecibo;
       this.tipoSer = tipoSer;
       this.nombre = nombre;
       this.domicilio = domicilio;
       this.fecha = fecha;
       this.costoK = costoK;
       this.kiCon = kiCon;
    }
            public float calcularSub(){
                return this.kiCon*this.costoK;
            }
            
            public float calcularImpuestos(){
                return (calcularSub()/100)*16;
            }
            
            public float calcularTotal(){
                return calcularSub()+calcularImpuestos();
            }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public int getTipoSer() {
        return tipoSer;
    }

    public void setTipoSer(int tipoSer) {
        this.tipoSer = tipoSer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getCostoK() {
        return costoK;
    }

    public void setCostoK(float costoK) {
        this.costoK = costoK;
    }

    public float getKiCon() {
        return kiCon;
    }

    public void setKiCon(float kiCon) {
        this.kiCon = kiCon;
    }
            
}
