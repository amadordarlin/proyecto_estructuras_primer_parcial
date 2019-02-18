    import java.io.InputStream;
import java.util.Scanner;
    public class LectorTeclado {
        private double b = 0;
        Scanner sc;

        LectorTeclado(InputStream input) {

            sc = new Scanner(input);
        }

        public double leerDouble(String mensaje, String mensajeReintento) {
            System.out.println(mensaje);

            while (sc.hasNext()) {

                if (sc.hasNextDouble()) {
                    return sc.nextDouble();
                }
                sc.next();
                System.out.println(mensajeReintento);
            }
            return -1;
        }


        public double leerDoubleValidado(String mensaje, String mensajeReintento, double min, double max) {
            System.out.println(mensaje);

            while (sc.hasNext()) {

                if (sc.hasNextDouble()) {
                    double valor = sc.nextDouble();
                    if (valor >= min && valor < max) {
                        return valor;
                    }
                } else {
                    sc.next();

                }
                System.out.println(mensajeReintento);
            }
            return -1;
        }

        public int leerEnteroValidado(String mensaje, String mensajeReintento, int min, int max) {
            System.out.println(mensaje);

            while (sc.hasNext()) {

                if (sc.hasNextInt()) {
                    int valor = sc.nextInt();
                    if (valor >= min && valor < max) {
                        return valor;
                    }
                } else {
                    sc.next();
                }
                System.out.println(mensajeReintento);
            }
            return -1;

        }

        public int leerEntero(String mensaje, String reintento) {
            System.out.println(mensaje);
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    return sc.nextInt();
                } else {
                    System.out.println(reintento);
                    sc.next();
                }
            }
            return -1;
        }

        public double leerMinutos() {
            double y = leerDouble("Ingrese la duracion de la cancion en decimal", "El valor ingresado es incorrecto");
            double x = Math.round(y);
            if (y - x > 0 && y - x <= 0.5 || y - x == -0.5 || y - x == -0.4) {
                if ((y - x) < 0.59) {
                    return y;
                }

            } else {
                if (x > y && (x - y) <= 0.41) {
                    double r = 0.4 - (x - y);
                    return (x + r);
                }
                return y;

            }

            return 1;
        }
        public double validarCero(String mensaje, String mensajeReintento) {
            System.out.println(mensaje);

            while (sc.hasNext()) {

                if (sc.hasNextDouble()) {
                    double valor = sc.nextDouble();
                    if (valor < 0 || valor > 0) {
                        return valor;
                    }
                } else {
                    sc.next();
                }
                System.out.println(mensajeReintento);
            }
            return -1;

        }

    }

