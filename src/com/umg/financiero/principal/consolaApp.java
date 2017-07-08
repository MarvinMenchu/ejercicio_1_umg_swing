package com.umg.financiero.principal;

import java.text.SimpleDateFormat;
import java.util.*;

import com.umg.financiero.clases.*;

/**
 * Created by marvinmanuelmenchumenchu on 6/07/17.
 */
public class consolaApp {
    public static void main(String[] args) throws Exception {
        Sucursal sucursal = null;
        boolean salir = false;
        int opcion;
        int numeroTransaccion = 1;
        Scanner sc = new Scanner(System.in);
        while(!salir){
            System.out.println("Sistema Financiero");
            System.out.println("1. Ingresar Sucursal");
            System.out.println("2. Imprimir datos Sucursal");
            System.out.println("3. Ingresar Clientes");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Ingresar Cuentas");
            System.out.println("6. Reporte Cuentas");
            System.out.println("7. Realizar Transacción");
            System.out.println("8. Imprimir estado de cuenta");
            System.out.println("9. Salir");

            try{
                System.out.println("Seleccione uno de las opciones");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        int cantidadClientes = 0;
                        System.out.println("Ingrese datos de la sucursal");
                        System.out.println("Ingrese numero clientes de la sucursal:");
                        cantidadClientes = sc.nextInt();
                        sucursal = new Sucursal(cantidadClientes);
                        sucursal.setCodigo(1);
                        System.out.println("Ingrese Nombre de la Sucursal");
                        sucursal.setNombre(sc.next());
                        System.out.println("Ingrese direccion");
                        sucursal.setDireccion(sc.next());
                        System.out.println("Ingrese telefono");
                        sucursal.setTelefono(sc.next());
                        break;
                    case 2:
                        System.out.println("======================================================");
                        System.out.println("Datos de la sucursal");
                        System.out.println("Código: " + sucursal.getCodigo());
                        System.out.println("Nombre: " + sucursal.getNombre());
                        System.out.println("Dirección: " + sucursal.getDireccion());
                        System.out.println("Teléfono: " + sucursal.getTelefono());
                        System.out.println("Cantidad Clientes: " + sucursal.getCliente().length);
                        System.out.println("======================================================");
                        break;
                    case 3:
                        Cliente cliente = new Cliente();
                        String fechaNac = "1990-01-01";
                        System.out.println("Ingrese datos del cliente No. "+ (sucursal.getCantidadCliente()+1));
                        cliente.setCodigo(sucursal.getCantidadCliente() + 1);
                        System.out.println("Ingrese el Nombre del cliente");
                        cliente.setNombre(sc.next());
                        System.out.println("Ingrese el sexo del cliente M/F");
                        cliente.setSexo(sc.next());
                        System.out.println("Ingrese el id del cliente");
                        cliente.setId(sc.next());
                        System.out.println("Ingrese el fecha nacimiento del cliente dd/MM/yyyy");
                        fechaNac = sc.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = sdf.parse(fechaNac);
                        cliente.setFechaNacimiento(fecha);
                        sucursal.agragarCliente(cliente);
                        break;
                    case 4:
                        System.out.println("======================================================");
                        System.out.println("Lista de Clientes");
                        Cliente[] clientes = null;
                        clientes = sucursal.getCliente();
                        if(clientes != null) {
                            for (int x = 0; x < sucursal.getCantidadCliente(); x++) {
                                System.out.println("=========================================");
                                System.out.println("Codigo     ---------->" + clientes[x].getCodigo());
                                System.out.println("Nombre     ---------->" + clientes[x].getNombre());
                                System.out.println("Sexo       ---------->" + clientes[x].getSexo());
                                System.out.println("Id         ---------->" + clientes[x].getId());
                                System.out.println("Fecha Nac. ---------->" + new SimpleDateFormat("dd/MM/yyyy").format(clientes[x].getFechaNacimiento()));
                                System.out.println("Cta Apert. ---------->" + clientes[x].getCuenta().size());
                            }
                        }else{
                            System.out.println("No hay registros");
                        }
                        System.out.println("======================================================");
                        break;
                    case 5:
                        Cuenta cuenta = new Cuenta();
                        String codigoCliente = "";
                        System.out.println("======================================================");
                        System.out.println("Ingrese Cuentas de Ahorro");
                        System.out.println("Código Cliente");
                        codigoCliente = sc.next();
                        Cliente[]  cli = sucursal.getCliente();
                        boolean existe = false;
                        Integer codigoClienteIn = Integer.parseInt(codigoCliente);
                        Integer codigoClienteDatos = 0;
                        int y = 0;
                        for(y = 0 ; y < cli.length ; y++) {
                            codigoClienteDatos = cli[y].getCodigo();
                            if( codigoClienteDatos == codigoClienteIn ){
                                existe = true;
                                break;
                            }
                        }
                        if (existe){
                            System.out.println("Nombre del cliente: " + cli[y].getNombre());
                            System.out.println("Numero de Cuenta");
                            cuenta.setNumeroCuenta(sc.next());
                            System.out.println("Tipo de Cuenta M = monetario A = ahorro");
                            cuenta.setTipoCuenta(sc.next());
                            System.out.println("Ingrese Tasa de Interes");
                            cuenta.setTasaInteres(sc.nextInt());
                            System.out.println("Ingrese Numero Chequera o Libreta");
                            cuenta.setNumeroLibreta(sc.nextInt());
                            cuenta.setSaldoContable(0);
                            cuenta.setEstado("A");
                            cli[y].agregarCuenta(cuenta);
                            sucursal.setCliente(cli);
                        }else{
                            System.out.println("No se encontro cliente, intente de nuevo" );
                        }

                    case 6:
                        System.out.println("======================================================");
                        System.out.println("Cta.      Nombre.       Tipo.    Tasa Interes     Saldo.");
                        System.out.println("REPORTE DE CUENTAS");
                        Cliente[] cliReporte = sucursal.getCliente();
                        for(int x = 0 ; x < sucursal.getCliente().length ; x++){
                            List<Cuenta> cta = cliReporte[x].getCuenta();
                            for (Cuenta cta1:
                                 cta) {
                                System.out.println(cta1.getNumeroCuenta() + "     " + cliReporte[x].getNombre() + "     "+ cta1.getTipoCuenta() + "     "  + cta1.getTasaInteres() + "%     " + cta1.getSaldoContable() );
                            }
                        }
                        break;
                    case 7:
                        System.out.println("======================================================");
                        System.out.println("Transacciones");
                        System.out.println("Deposito = D - Retiro = R");
                        System.out.println("Ingrese transaccion");
                        String opcionTrx = sc.next();
                        if (!opcionTrx.equals("D") || !opcionTrx.equals("R")){
                            System.out.println("Ingrese numero de cuenta");
                            String cuentaTrx = sc.next();
                            System.out.println("Ingrese comprobante");
                            String comprobanteTrx = sc.next();
                            System.out.println("Ingrese Monto");
                            String montoTrx = sc.next();
                            Cliente[] cliTrx = sucursal.getCliente();
                            List<Cuenta> ctaTrx = new ArrayList<>();
                            Cuenta cta1 = new Cuenta();
                            for(int z = 0 ; z < cliTrx.length ; z ++){
                                ctaTrx = cliTrx[z].getCuenta();
                            }
                        }else{
                            System.out.println("Ingrese transaccion correcta!");
                        }
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debe ingresar un numero del 1 al 9");
                }


            }catch(InputMismatchException e){
                System.out.println("Debe insertar un numero");
                sc.next();
            }

        }
    }
}
