import java.util.ArrayList;
import java.util.List;

class Disciplina {
    private String nome;
    private int cargaHoraria;
    private double nota;

    public Disciplina(String nome, int cargaHoraria, double nota) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

class Curso {
    private String nome;
    private String turno;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome, String turno) {
        this.nome = nome;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
}


class Aluno {
    private String nome;
    private int idade;
    private Curso curso;

    public Aluno(String nome, int idade, Curso curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public void mostrarInformacoes() {
        System.out.println("Aluno: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Disciplinas: ");
        for (Disciplina disciplina : curso.getDisciplinas()) {
            System.out.println(" - " + disciplina.getNome() + " (Carga Horária: " + disciplina.getCargaHoraria() + ")");
        }
    }
}