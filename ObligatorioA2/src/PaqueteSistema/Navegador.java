package PaqueteSistema;

import java.io.IOException;

public class Navegador {

    public static void openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + url);
            } else {
                System.out.println("Please open a browser and go to "+ url);
            }
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        }
    }
	
}
