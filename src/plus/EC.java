package plus;
import java.io.*;
public class EC {
    public static void main(String[] args) throws
            IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out));
        String linea = br.readLine();
        String[] par = linea.split(" ");
        int n = Integer.parseInt(par[0]);
        int x = Integer.parseInt(par[1]);
        int[] numeros = new int[n];
        for (int i=0;i<n;i++){
            linea = br.readLine();
            int num = Integer.parseInt(linea);
            numeros[i] = num;
        }
        int total = 0;
        int a=1, b=0;
        while(b<n-1){
            int aux1 = numeros[a];
            int aux2 = numeros[b];
            if(aux1+aux2==x){
                total++;
            }
            a++;
            if(a==n){
                b = b + 1;
                a = b + 1;
            }
        }
        bw.write(total+"\n");
        br.close();
        bw.close();
    }
}

