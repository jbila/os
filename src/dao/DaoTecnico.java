package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexao.Conexao;
import model.Funcao;
import model.Tecnico;

public class DaoTecnico {

    private static final String SQL_INSERT = "INSERT INTO tecnico(nome, contacto, email, data_criacao, id_funcao) VALUES(?,?,?,?,?)";
    private static final String SQL_LIST = "SELECT t.*, f.nome AS funcao FROM tecnico t INNER JOIN funcao f ON t.id_funcao = f.id ORDER BY t.id DESC";
    private static final String SQL_DELETE = "DELETE FROM tecnico WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE cliente SET nome=?, contacto=?, email=?, data_actualizacao=?, id_funcao=? WHERE id=?";

    public void save(Tecnico tecnico) {
        if (tecnico == null) {
            JOptionPane.showMessageDialog(null, "Técnico enviado por parâmetro está vazio");
            return;
        }

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getContacto());
            stmt.setString(3, tecnico.getEmail());
            stmt.setObject(4, tecnico.getDataCriacao());
            stmt.setInt(5, tecnico.getFuncao().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Técnico Registrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar técnico: " + ex.getMessage());
        }
    }

    public ArrayList<Tecnico> findAll() {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_LIST);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tecnico tecnico = new Tecnico();
                Funcao funcao = new Funcao();
                funcao.setNome(rs.getString("funcao"));
                tecnico.setFuncao(funcao);
                tecnico.setId(rs.getInt("id"));
                tecnico.setNome(rs.getString("nome"));
                tecnico.setEmail(rs.getString("email"));
                tecnico.setContacto(rs.getString("contacto"));
                tecnico.setDataCriacao(LocalDate.parse(rs.getString("data_criacao")));
                tecnicos.add(tecnico);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar técnicos: " + ex.getMessage());
        }
        return tecnicos;
    }

    public void delete(int id) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Técnico Removido com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o técnico da base de dados: " + e.getMessage());
        }
    }

    public void update(Tecnico tecnico) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getContacto());
            stmt.setString(3, tecnico.getEmail());
            stmt.setObject(4, LocalDate.now());
            stmt.setInt(5, tecnico.getFuncao().getId());
            stmt.setInt(6, tecnico.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Técnico atualizado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar técnico: " + ex.getMessage());
        }
    }
}
