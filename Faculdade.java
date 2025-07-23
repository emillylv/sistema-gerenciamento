import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Faculdade {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Gerenciar ALUNOS");
            System.out.println("2 - Gerenciar DISCIPLINAS");
            System.out.println("3 - Gerenciar CURSOS");
            System.out.println("4 - SAIR");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    menuAlunos();
                    break;
                case 2:
                    menuDisciplinas();
                    break;
                case 3:
                    menuCursos();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    // Submenu Alunos
    private static void menuAlunos() {
        int opcao;
        do {
            System.out.println("\nGerenciar ALUNOS:");
            System.out.println("1 - Cadastrar ALUNO");
            System.out.println("2 - Consultar ALUNO");
            System.out.println("3 - Remover ALUNO");
            System.out.println("4 - Atualizar ALUNO");
            System.out.println("5 - Voltar ao MENU INICIAL");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    consultarAluno();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    atualizarAluno();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    // Submenu Disciplinas
    private static void menuDisciplinas() {
        int opcao;
        do {
            System.out.println("\nGerenciar DISCIPLINAS:");
            System.out.println("1 - Cadastrar DISCIPLINA");
            System.out.println("2 - Consultar DISCIPLINA");
            System.out.println("3 - Remover DISCIPLINA");
            System.out.println("4 - Atualizar DISCIPLINA");
            System.out.println("5 - Voltar ao MENU INICIAL");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    consultarDisciplina();
                    break;
                case 3:
                    removerDisciplina();
                    break;
                case 4:
                    atualizarDisciplina();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    // Submenu Cursos
    private static void menuCursos() {
        int opcao;
        do {
            System.out.println("\nGerenciar CURSOS:");
            System.out.println("1 - Cadastrar CURSO");
            System.out.println("2 - Consultar CURSO");
            System.out.println("3 - Remover CURSO");
            System.out.println("4 - Atualizar CURSO");
            System.out.println("5 - Voltar ao MENU INICIAL");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    consultarCurso();
                    break;
                case 3:
                    removerCurso();
                    break;
                case 4:
                    atualizarCurso();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    // Métodos para gerenciar alunos, cursos e disciplinas

    private static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha um curso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + " - " + cursos.get(i).toString());
        }
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            Curso cursoEscolhido = cursos.get(cursoIndex);
            Aluno aluno = new Aluno(nome, idade, cursoEscolhido);
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Curso inválido.");
        }
    }

    private static void consultarAluno() {
        System.out.print("Digite o nome do aluno para consulta: ");
        String nome = scanner.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println(aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void removerAluno() {
        System.out.print("Digite o nome do aluno para remoção: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                alunos.remove(i);
                System.out.println("Aluno removido com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void atualizarAluno() {
        System.out.print("Digite o nome do aluno para atualização: ");
        String nome = scanner.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.print("Novo nome: ");
                aluno.setNome(scanner.nextLine());
                System.out.print("Nova idade: ");
                aluno.setIdade(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Aluno atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void cadastrarDisciplina() {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Nota da disciplina: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha um curso para associar a disciplina:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + " - " + cursos.get(i).toString());
        }
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            Disciplina disciplina = new Disciplina(nome, cargaHoraria, nota);
            cursos.get(cursoIndex).adicionarDisciplina(disciplina);
            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Curso inválido.");
        }
    }

    private static void consultarDisciplina() {
        System.out.print("Digite o nome da disciplina para consulta: ");
        String nome = scanner.nextLine();

        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if (disciplina.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(disciplina);
                    return;
                }
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    private static void removerDisciplina() {
        System.out.print("Digite o nome da disciplina para remoção: ");
        String nome = scanner.nextLine();

        for (Curso curso : cursos) {
            for (int i = 0; i < curso.getDisciplinas().size(); i++) {
                if (curso.getDisciplinas().get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                    curso.getDisciplinas().remove(i);
                    System.out.println("Disciplina removida com sucesso.");
                    return;
                }
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    private static void atualizarDisciplina() {
        System.out.print("Digite o nome da disciplina para atualização: ");
        String nome = scanner.nextLine();

        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if (disciplina.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    System.out.print("Novo nome: ");
                    disciplina.setNome(scanner.nextLine());
                    System.out.print("Nova carga horária: ");
                    disciplina.setCargaHoraria(scanner.nextInt());
                    System.out.print("Nova nota: ");
                    disciplina.setNota(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("Disciplina atualizada com sucesso.");
                    return;
                }
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    private static void cadastrarCurso() {
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();
        scanner.nextLine();

        Curso curso = new Curso(nome, turno);
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void consultarCurso() {
        System.out.print("Digite o nome do curso para consulta: ");
        String nome = scanner.nextLine();

        for (Curso curso : cursos) {
            if (curso.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println(curso);
                return;
            }
        }
        System.out.println("Curso não encontrado.");
    }

    private static void removerCurso() {
        System.out.print("Digite o nome do curso para remoção: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                cursos.remove(i);
                System.out.println("Curso removido com sucesso.");
                return;
            }
        }
        System.out.println("Curso não encontrado.");
    }

    private static void atualizarCurso() {
        System.out.print("Digite o nome do curso para atualização: ");
        String nome = scanner.nextLine();

        for (Curso curso : cursos) {
            if (curso.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.print("Novo nome: ");
                curso.setNome(scanner.nextLine());
                scanner.nextLine();
                System.out.println("Curso atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Curso não encontrado.");
    }
}