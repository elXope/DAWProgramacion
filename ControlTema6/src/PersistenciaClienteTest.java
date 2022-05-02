import java.util.ArrayList;

public class PersistenciaClienteTest {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Cliente c1 = new Cliente("11111111A", "Aaron", "Aa", "01", "aa@aa.aa");
        Cliente c2 = new Cliente("22222222B", "Barrabas", "Bb", "02", "bb@bb.bb");
        Cliente c3 = new Cliente("33333333C", "Concha", "Cc", "03", "cc@cc.cc");

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        PersistenciaCliente.write(clientes);

        ArrayList<Cliente> clientesRecuperado = PersistenciaCliente.read();
        for (int i = 0; i < clientesRecuperado.size(); i++) {
            System.out.println(clientesRecuperado.get(i));
            System.out.println(clientes.get(i));
            System.out.println("==============");
        }
    }
}
