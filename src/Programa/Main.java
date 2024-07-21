package Programa;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    // Scanner para ler entrada do teclado
    static Scanner input = new Scanner(System.in);

    // Lista de contas bancárias para simulação
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args) {

        // Lista de contas bancárias para simulação
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("\nHello world! Hoje teremos um Simulador de um sistema bancário.");
        System.out.println("-------------------------------------------------------------+");
        System.out.println("Este simulador permite a criação, operações básicas e transferências entre contas.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("-------------------------------------------------------------+");
        System.out.println("******Bem vindos a nossa Agência*******");
        System.out.println("-------------------------------------------------------------+\n");
        System.out.println("==> Selecione a operação que deseja realizar: " +
                "\n=====================================================");
        System.out.println("----------- 1 Cadastrar conta:\n" +
                           "----------- 2 Sacar:\n" +
                           "----------- 3 Depositar:\n" +
                           "----------- 4 Transferir\n" +
                           "----------- 5 Extrato:\n" +
                           "----------- 6 Sair:\n" +
                           "==> "  );


        // Switch de operações
        int operacao = input.nextInt();
        switch (operacao) {
            case 1:
                // Criar Conta
                cadastarConta();
                break;
            case 2:
                // Sacar
                sacar();
                break;
            case 3:
                // Depositar
                depositar();
                break;
            case 4:
                // Transferir
                transferir();
                break;
            case 5:
                // Extrato
                listar();
                break;
            case 6:
                // Sair
                System.out.println("Obrigado!!");
                System.exit(0);
            default:
                System.out.println("Operação inválida. Tente novamente.");
                operacoes();
                break;
        }


    }

    public static void cadastarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();
        System.out.println("\n");
        System.out.println("CPF: ");
        String cpf = input.next();
        System.out.println("Email: ");
        String email = input.next();
        System.out.println("Telefone: ");
        String telefone = input.next();

        System.out.println("\n");
        // istanciando a classe pessoa e inserindo os dados
        Pessoa pesssoa = new Pessoa(nome, cpf, email, telefone);
        // instanciando a classe conta e adicionando a pessoa na conta
        Conta conta = new Conta(pesssoa);
        // adicionando a conta na lista de contas bancárias
        contasBancarias.add(conta);
        // chamando o menu operações
        operacoes();

    }

    private static Conta localizarConta(int numeroConta){
        Conta conta = null;
        // verificando se a lista não está vazia e se a conta existe na lista
        if(!contasBancarias.isEmpty()){
            // percorrendo o Array das contas bancárias
            for(Conta c : contasBancarias){
                // se a conta localizada tem o número da conta igual ao digitado pelo usuário
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                    break;
                }
            }
        }
        return conta;

    }
    public static void sacar(){
        System.out.println("Digíte o numero da conta: ");
        int numeroConta = input.nextInt();
        // localizando o número utilizando o método localizarConta
        Conta conta = localizarConta(numeroConta);
        // se conta for diferente de null e o seu saldo for menor ou igual a zero, prossiga
        if(conta!= null) {
            System.out.println("Qual valor deseja sacar:");
            Double valorSaque = input.nextDouble();
            // utilizando o método sacar para o valor informao para saque
            conta.sacar(valorSaque);
        }else{
            System.out.println("Conta não encontrada ou saldo insuficiente.");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void depositar(){
        System.out.println("Informe o número da conta: ");
        int numeroContaDestino = input.nextInt();

        // localizando conta origem
        Conta contaDestino = localizarConta(numeroContaDestino);
        // se a conta origem for diferente de null, prossiga
        if(contaDestino!= null){
            System.out.println("Informe o valor a ser depositado: ");
            double valorDeposito = input.nextDouble();
            // utilizando o método depositar para o valor informado para deposito
            contaDestino.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        }else{
            System.out.println("Conta não encontrada.");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void transferir(){
        System.out.println("Realizando transferência... ");
        System.out.println("Informe a conta destino: ");
        int numeroContaDestino = input.nextInt();
        // localizando conta destino
        Conta contaDestino = localizarConta(numeroContaDestino);
        // se a conta destino for diferente de null e o seu saldo for maior ou igual a zero, prossiga
        if(contaDestino!= null) {
            System.out.println("Informe a conta origem: ");
            int numeroContaOrigem = input.nextInt();
            // localizando conta origem
            Conta contaOrigem = localizarConta(numeroContaOrigem);
            //
            if(contaOrigem!= null){
                System.out.println("Qual valor deseja transfeir: ");
                double valorTransferencia = input.nextDouble();
                // utilizando o método transferir para transferir o valor informado para a conta destino
                contaOrigem.transferir(contaDestino, valorTransferencia);

                System.out.println("Transferência realizada com sucesso!");
            }
        }else{
            System.out.println("Transferência não pode ser relizada! Ambas ou algumas das contas inexistem!");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void listar(){
        System.out.println("Extrato: ");
        System.out.println("Informe o número da conta a ser localizada: ");
        int numeroConta = input.nextInt();
        // localizando o número da conta
        Conta conta = localizarConta(numeroConta);
        // se a conta for diferente de null, prossiga
        if(conta != null){
            // se o Array das contas bancárias não estiver vazio, a lista de contas será impressa.
            if(!contasBancarias.isEmpty()) {
                for(Conta c : contasBancarias){
                    System.out.println(c);
                }
            }
        } else{
            System.out.println("Conta inexistente!");
        }
        // chamando o menu operções
        operacoes();


    }


}
