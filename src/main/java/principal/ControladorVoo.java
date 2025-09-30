package principal;

import java.util.ArrayList;

public class ControladorVoo {

    private ArrayList<Voo> voos = new ArrayList<>();
    public final int NUMERO_DE_VOOS = 10;

    public ControladorVoo() {
        for (int numero = 1; numero <= NUMERO_DE_VOOS; numero++) {
            String codigoVoo = "A" + numero;
            Voo voo = new Voo(codigoVoo);
            voos.add(voo);
        }
    }
    public int verificarStatus(String codigoVoo, int numeroAssento) {
        Voo voo = procurarVoo(codigoVoo);
        if (voo == null) {
            return 3; 
        }
        Assento assento = voo.procurarAssento(numeroAssento);
        if (assento == null) {
            return 2; 
        }
        if (!assento.getDisponivel()) {
            return 1; 
        }
        return 0; 
    }
    
    public int marcarVoo(String codigoVoo, int numeroAssento) {
        Voo voo = procurarVoo(codigoVoo);
        if (voo != null) {
            Assento assento = voo.procurarAssento(numeroAssento);
            if (assento != null) {
                if (assento.getDisponivel()){
                    assento.setDisponivel(false);
                    return 4; //Assento marcado
                }
            }
        }
        return 0;
    }

    public Voo procurarVoo(String codigoVoo) {
        for (Voo v : voos) {
            if (v.getCodigoVoo().equals(codigoVoo)) {
                return v;
            }
        }
        return null;
    }
}
