package principalpackage;

public class clasePlanilla {
    //parametros
    private int id;
    private String area;  
    private String puesto;
    private double fechaIngreso;
    private double fechaInicio;
    private double fechaFin;
    private double tiempoenEmpresa;
    private double sueldoBMensual;
    private int cantEmpleados;
    private double totalxPuesto;
    
    private double iss;
    private double afp;
    private double vacaciones;
    private double issvac;
    private double afpvac;
    private double aguinaldo;
    
    //constructor
    public clasePlanilla(String area, String puesto, double fechaIngreso, double fechaInicio, double fechaFin, double tiempoenEmpresa, double sueldoBMensual, int cantEmpleados, double totalxPuesto, double iss, double afp, double vacaciones, double issvac, double afpvac, double aguinaldo) {
        //this.id = id;
        this.area = area;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiempoenEmpresa = tiempoenEmpresa;
        this.sueldoBMensual = sueldoBMensual;
        this.cantEmpleados = cantEmpleados;
        this.totalxPuesto = totalxPuesto;
        this.iss = iss;
        this.afp = afp;
        this.vacaciones = vacaciones;
        this.issvac = issvac;
        this.afpvac = afpvac;
        this.aguinaldo = aguinaldo;
    }
    //get and set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(double fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(double fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(double fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTiempoenEmpresa() {
        return tiempoenEmpresa;
    }
    public void setTiempoenEmpresa(double tiempoenEmpresa) {
        this.tiempoenEmpresa = tiempoenEmpresa;
    }

    public double getSueldoBMensual() {
        return sueldoBMensual;
    }
    public void setSueldoBMensual(double sueldoBMensual) {
        this.sueldoBMensual = sueldoBMensual;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }
    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public double getTotalxPuesto() {
        return totalxPuesto;
    }
    public void setTotalxPuesto(double totalxPuesto) {
        this.totalxPuesto = totalxPuesto;
    }

    public double getIss() {
        return iss;
    }
    public void setIss(double iss) {
        this.iss = iss;
    }

    public double getAfp() {
        return afp;
    }
    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getVacaciones() {
        return vacaciones;
    }
    public void setVacaciones(double vacaciones) {
        this.vacaciones = vacaciones;
    }

    public double getIssvac() {
        return issvac;
    }
    public void setIssvac(double issvac) {
        this.issvac = issvac;
    }

    public double getAfpvac() {
        return afpvac;
    }
    public void setAfpvac(double afpvac) {
        this.afpvac = afpvac;
    }

    public double getAguinaldo() {
        return aguinaldo;
    }
    public void setAguinaldo(double aguinaldo) {
        this.aguinaldo = aguinaldo;
    }
   
}
