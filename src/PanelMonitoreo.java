public class PanelMonitoreo {
    private Sensor[] sensores;
    public PanelMonitoreo(Sensor[] sensores) {
        this.sensores = sensores;
    }
    public String listarSensores() {
        String resultado = "";
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null) {
                resultado += sensores[i].mostrarInformacion() + "\n";
            }
        }
        return resultado;
    }
    public int contarActivos() {
        int contador = 0;
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].isActivo()) {
                contador++;
            }
        }
        return contador;
    }
    public double calcularPromedioLecturas() {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null) {
                suma += sensores[i].getLectura();
                contador++;
            }
        }
        if (contador == 0) {
            return 0;
        }
        return suma / contador;
    }
    public Sensor buscarSensor(String codigo) {
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null && sensores[i].getCodigo().equals(codigo)) {
                return sensores[i];
            }
        }
        return null;
    }
    public Sensor obtenerMayorLectura() {
        Sensor mayorLectura = null;
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i] != null) {
                if (mayorLectura == null || sensores[i].getLectura() > mayorLectura.getLectura()) {
                    mayorLectura = sensores[i];
                }
            }
        }
        return mayorLectura;
    }
}
