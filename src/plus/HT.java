package plus;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
public class HT {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out));
        String linea = br.readLine();
        String[] par = linea.split(" ");
        int n = Integer.parseInt(par[0]);
        int x = Integer.parseInt(par[1]);
        HashMap<Integer,Integer> valores = new HashMap<>();
        for (int i=0;i<n;i++){
            linea = br.readLine();
            int num = Integer.parseInt(linea);
            if(valores.containsKey(num)){
                int actual = valores.get(num);
                valores.put(num, actual+1);
            }else {
                valores.put(num, 1);
            }
        }
        Iterator<Integer> numeros = valores.keySet().iterator();
        int total = 0;
        while(numeros.hasNext()){
            int actual = numeros.next();
            int cantidad1 = valores.get(actual);
            if(cantidad1>=0) {
                valores.put(actual, -1);
                int otro = x - actual;
                if (valores.containsKey(otro)) {
                    int cantidad2 = valores.get(otro);
                    if (cantidad2 >= 0) {
                        total = total + cantidad1 * cantidad2;
                        valores.put(otro, -1);
                    }
                }
            }
        }
        bw.write(total+"\n");
        br.close();
        bw.close();
    }
}

