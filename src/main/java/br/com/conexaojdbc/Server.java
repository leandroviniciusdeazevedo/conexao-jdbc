package br.com.conexaojdbc;

import br.com.conexaojdbc.model.dao.ProdutoDAO;
import br.com.conexaojdbc.model.dao.PessoaDAO;
import br.com.conexaojdbc.model.entity.Produto;
import br.com.conexaojdbc.model.entity.Pessoa;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema Loja");
        char option = '0';
        while (option == '0' | option =='1' | option == '2' | option == '3' | option == '4'){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Novo produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Renomear produto");
            System.out.println("4 - Excluir produto");
            System.out.println("Digite qualquer outra opção para sair");
            option = scanner.next().charAt(0);
            if (option == '1'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja cadastrar um novo produto? S/N ");
                    op = scanner.next().charAt(0);
                    if(op == 'S'){
                        System.out.println("Digite o nome: ");
                        String nome = scanner.next();
                        System.out.println("Digite o fornecedor: ");
                        String fornecedor = scanner.next();
                        System.out.println("Digite o preco: ");
                        double preco = scanner.nextDouble();
                        System.out.println("Digite a quantidade em estoque: ");
                        int qtdEstoque = scanner.nextInt();
                        Produto a = new Produto(nome, fornecedor, preco, qtdEstoque);
                        ProdutoDAO dao = new ProdutoDAO();
                        dao.save(a);
                    }
                }
            } else if (option == '2'){
                ProdutoDAO dao = new ProdutoDAO();
                System.out.println(dao.findAll());
            } else if (option == '3'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja alterar o nome de um produto? S/N");
                    op = scanner.next().charAt(0);
                    if (op == 'S'){
                        System.out.println("Digite o id do produto a ser renomeado: ");
                        int id = scanner.nextInt();
                        System.out.println("Digite o novo nome: ");
                        String nome = scanner.next();
                        ProdutoDAO dao = new ProdutoDAO();
                        dao.update(nome, id);
                    }
                }
            } else if (option == '4'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja excluir um produto? S/N");
                    op = scanner.next().charAt(0);
                    if (op == 'S'){
                        System.out.println("Digite o id do produto a ser excluido: ");
                        int id = scanner.nextInt();
                        ProdutoDAO dao = new ProdutoDAO();
                        dao.delete(id);
                    }
                }
            }
        }


        /*System.out.println("Sistema ZOO");
        char option = '0';
        while (option == '0' | option =='1' | option == '2' | option == '3' | option == '4'){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Novo animal");
            System.out.println("2 - Listar animais");
            System.out.println("3 - Renomear animal");
            System.out.println("4 - Excluir animal");
            System.out.println("Digite qualquer outra opção para sair");
            option = scanner.next().charAt(0);
            if (option == '1'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja cadastrar um novo animal? S/N ");
                    op = scanner.next().charAt(0);
                    if(op == 'S'){
                        System.out.println("Digite o nome: ");
                        String nome = scanner.next();
                        System.out.println("Digite a especie: ");
                        String especie = scanner.next();
                        System.out.println("Digite a idade: ");
                        int idade = scanner.nextInt();
                        System.out.println("Digite o sexo: ");
                        String sexo = scanner.next();
                        Animal a = new Animal(nome,especie,idade,sexo);
                        AnimalDAO dao = new AnimalDAO();
                        dao.save(a);
                    }
                }
            } else if (option == '2'){
                AnimalDAO dao = new AnimalDAO();
                System.out.println(dao.findAll());
            } else if (option == '3'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja alterar o nome de um animal? S/N");
                    op = scanner.next().charAt(0);
                    if (op == 'S'){
                        System.out.println("Digite o id do animal a ser renomeado: ");
                        int id = scanner.nextInt();
                        System.out.println("Digite o novo nome: ");
                        String nome = scanner.next();
                        AnimalDAO dao = new AnimalDAO();
                        dao.update(nome, id);
                    }
                }
            } else if (option == '4'){
                char op = 'S';
                while (op == 'S'){
                    System.out.println("Deseja excluir um animal? S/N");
                    op = scanner.next().charAt(0);
                    if (op == 'S'){
                        System.out.println("Digite o id do animal a ser excluido: ");
                        int id = scanner.nextInt();
                        AnimalDAO dao = new AnimalDAO();
                        dao.delete(id);
                    }
                }
            }
        }*/
        scanner.close();
    }
}
