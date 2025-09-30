package principal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    ControladorVoo controlador = new ControladorVoo();

    public int calcularCodigoStatus(String textoRecebido) {
        String[] processoEcodigoEAssento = textoRecebido.split(";");
        if (processoEcodigoEAssento.length != 0) {
            String processo = processoEcodigoEAssento[0].trim();
            String voo = processoEcodigoEAssento[1].trim();
            int assento = Integer.parseInt(processoEcodigoEAssento[2].trim());
            if (processo.equals("C")) {
                return controlador.verificarStatus(voo, assento);
            } else {
                if (processo.equals("M")) {
                    return controlador.marcarVoo(voo, assento);
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }

    public void rodarServidor() {
        try {
            ServerSocket serversocket = new ServerSocket(4444);
            System.out.println("Servidor iniciado!");

            String textoRecebido = "";

            while (!textoRecebido.equalsIgnoreCase("quit")) {
                Socket socketClient = serversocket.accept(); 

                PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

                textoRecebido = in.readLine();
                System.out.println("Texto Recebido:" + textoRecebido);

                if (!textoRecebido.equalsIgnoreCase("quit")) {

                    int codigoStatus = calcularCodigoStatus(textoRecebido);

                    out.println(Integer.toString(codigoStatus));
                    out.flush();
                }
                socketClient.close();
            }
        } catch (IOException ioe) {
            System.out.println("Excecao: " + ioe.getMessage());
        }
        System.out.println("Servidor finalizado!");
    }
}
