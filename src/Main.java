import java.util.Random;
public class Main {
static int n=0;

    public static void main(String[] args) {

        LectorTeclado lt= new LectorTeclado(System.in);
        int desea=0;
        do {
            int []arreglo= llenarArregloAleatorio();//Llenar el arreglo de forma aleatoria
            System.out.println();

            long startTime = System.nanoTime();//iniciar el contador de tiempo
            int[] result = bubbleSort(arreglo);//Ordenar el arreglo
            long endTime = System.nanoTime() - startTime;//Calcaular el tiempo tardado en ordenar el arreglo
            System.out.println("Tiempo en ordenar el arreglo por el método bubblesort: "+endTime+" nanosegundos"); //imprimir en pantalla el tiempo en ordenar el arreglo por el método bubblesort

            imprimirArregloHasta50(result);//imprimir los primeros 50 datos en el arreglo
            System.out.println();


            startTime=System.nanoTime();//reinicia el contador
            result=mergeSort(arreglo);//Ordena el arreglo
            endTime=System.nanoTime()-startTime;//calcula el tiempo en ordenar el arreglo
            System.out.println();
            System.out.println("Tiempo en ordenar el arreglo por el método mergeSort: "+endTime+" nanosegundos");//imprimir en pantalla el tiempo en ordenar el arreglo por el método mergeSort
            imprimirArregloHasta50(result);//imprimir los primeros 50 datos en el arreglo
            System.out.println();
            System.out.println();

            desea=lt.leerEnteroValidado("Desea realizar otra prueba? 1.si, 2.no","El dato ingresado no es válido, intente de nuevo",1,3);//consultar si desea ingresar mas datos
        }while (desea==1);
        System.out.println();
        System.out.println("Gracias por usar el programa!!!1");


    }
    public static void imprimirArregloHasta50(int[] a) {//Imprimir solo 50 elementos del arreglo ordenado
        if (n > 50) {
            for (int y = 0; y < 50; y++) {
                if (y == 49) {
                    System.out.print(a[y]);
                } else {
                    System.out.print(a[y] + ", ");
                }
            }


        } else {
            for (int y = 0; y < a.length; y++) {
                if (y == a.length - 1) {
                    System.out.print(a[y]);
                } else {
                    System.out.print(a[y] + ", ");

                }

            }
            System.out.println();
        }
    }
    public static int[] llenarArregloAleatorio(){
        LectorTeclado lt= new LectorTeclado(System.in);

        n=lt.leerEntero("Ingrese la cantidad de numeros para el arreglo", "El dato ingresado no es válido, intente de nuevo");

        int[] arr= new int[n];
        Random random = new Random();

        for(int i = 0, j = 0; i < arr.length; i++){

            j+= random.nextInt(n);
            arr[i] = j;
            if(j>=n){
                j=0;
            }

        }


    return arr;
    }

public static int[] addelemento(int[]arreglo, int elemento){
int [] retval= new int[(arreglo.length)+1];
    for (int i = 0; i <arreglo.length ; i++) {
        retval[i]=arreglo[i];
    }
    retval[(arreglo.length)]=elemento;
    return retval;
}
    public static void unir(){
        int [] arr01 = new int[3];
        arr01[0]=2;
        arr01[1]=5;
        arr01[2]=114;

        int [] arr02 = new int[5];
        arr02[0]=3;
        arr02[1]=8;
        arr02[2]=9;
        arr02[3]=11;
        arr02[4]=12;
        int[] arru = new int[arr01.length+arr02.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr01.length && j<arr02.length){
            if(arr01[i]<arr02[j]){
                arru[k]=arr01[i];
                k++;
                i++;
            }else{
                arru[k]=arr02[j];
                j++;
                k++;
            }
        }

        if(i==arr01.length){
            for(int l= j; l<arr02.length; l++){

                arru[k]=arr02[l];
                k++;
            }
        }else{
            for(int l= i; l<arr01.length; l++){
                arru[k]=arr01[l];
                k++;
            }
        }
        for(int a=0; a<arru.length; a++){

            System.out.println(arru[a]);
        }


    }

    public static void proband(){
        int[] arregloOrdenado = new int[10000];
        Random random = new Random();

        for(int i = 0, j = 0; i < arregloOrdenado.length; i++){

            j+= Math.abs(random.nextInt())%10;
            arregloOrdenado[i] = j;
        }

        for (int i = 0; i < 10; i++) {
            int elemento = arregloOrdenado[ Math.abs(random.nextInt())% arregloOrdenado.length];
            long startTime = System.nanoTime();

            int result = busquedaSequencial(arregloOrdenado, elemento);

            long endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda sequencial:\n tiempo: "
                    + endTime + "\n indice: " + result);


            startTime = System.nanoTime();
            result = busquedaBinaria(arregloOrdenado, elemento);
            endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda Binaria:\n tiempo: "
                    + endTime + "\n indice: " + result);
        }
    }

    public static int busquedaSequencial (int[] arreglo, int elemento){
        int retval = -1;
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i]== elemento){
                return i;
            }
        }
        return retval;
    }

    public static int busquedaBinaria(int[] arreglo, int elemento){
        int retval = -1;

        int superior = arreglo.length-1;
        int inferior = 0;
        while(superior >= inferior){
            int centro = (superior + inferior)/2;
            if(elemento == arreglo[centro]){
                //buscar primera incidencia
                return centro;
            }else if(arreglo[centro] > elemento) {
                superior = centro -1;
            }else {
                inferior = centro +1;
            }
        }
        return retval;
    }

    public  static int[] mergeSort(int[] arr){
        //caso base.
        if(arr.length <= 1){
            return arr;
        }
        // caso recursivo.

        int medio = arr.length /2;

        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;
    }


    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]< arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }



}
