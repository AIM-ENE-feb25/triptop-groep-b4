import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class curl {
    public static void main(String[] args) throws IOException {
        String curlcommand = "curl -k -X POST https://triptop-identity.wiremockapi.cloud/login -H \"Content-Type: application/json\" -d \"{\\\"username\\\":\\\"edevries\\\", \\\"password\\\":\\\"3g2Rw9sT1x\\\"}\"";
        Process process = Runtime.getRuntime().exec(curlcommand);
        //To print output of curl command

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }
        System.out.println("response: " + response.toString().trim());
    }
}