import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatientsByCity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Map<String,Integer> patientsByCity = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            String readLine = input.nextLine();
            String parts[] = readLine.split(" ");
            if(patientsByCity.containsKey(parts[1])) {
                Integer oldValue = patientsByCity.get(parts[1]);
                patientsByCity.put(parts[1], oldValue+1);
            } else {
                patientsByCity.put(parts[1],1);
            }
        }
        String city = input.nextLine();

        if(patientsByCity.containsKey(city)) {
            System.out.println(patientsByCity.get(city));
        } else {
            System.out.println("Nema pacienti za taa opshtina!");
        }
    }
}
