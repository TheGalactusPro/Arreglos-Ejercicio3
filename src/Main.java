public class Main {
    public static void main() {
        Sensor[] sensores = new Sensor[5];
        sensores[0] = new Sensor("S01", "Temperatura", "°C", 24.5, true);
        sensores[1] = new Sensor("S02", "Presion", "PSI", 80.0, true);
        sensores[2] = new Sensor("S03", "Humedad", "%", 65.5, false);
        sensores[3] = new Sensor("S04", "Nivel", "m", 4.2, true);
        sensores[4] = new Sensor("S05", "Caudal", "L/min", 35.0, false);
        PanelMonitoreo panel = new PanelMonitoreo(sensores);
        System.out.println("PANEL DE MONITOREO");
        System.out.println(panel.listarSensores());
        System.out.println("Sensores activos: " +panel.contarActivos());
        System.out.printf("Promedio de lecturas: %.2f%n", panel.calcularPromedioLecturas());
        System.out.println("\nBUSQUEDA DE SENSOR");
        Sensor encontrado = panel.buscarSensor("S01");
        if (encontrado != null) {
            System.out.println("Sensor encontrado:");
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("Sensor no encontrado");
        }
        Sensor inexistente = panel.buscarSensor("S10");
        if (inexistente != null) {
            System.out.println(inexistente.mostrarInformacion());
        } else {
            System.out.println("El sensor S10 no existe");
        }
        System.out.println("\nMAYOR LECTURA");
        Sensor mayor = panel.obtenerMayorLectura();
        if (mayor != null) {
            System.out.println(mayor.mostrarInformacion());
        } else {
            System.out.println("No existen sensores registrados");
        }
    }
}
