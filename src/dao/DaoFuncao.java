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

public class DaoFuncao {

    private static final String SQL_INSERT = "INSERT INTO funcao(nome, data_criacao) VALUES(?, ?)";
    private static final String SQL_LIST = "SELECT * FROM funcao ORDER BY id DESC";
    private static final String SQL_DELETE = "DELETE FROM funcao WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE funcao SET nome=?, data_actualizacao=? WHERE id=?";

    public void save(Funcao funcao) {
        if (funcao == null) {
            JOptionPane.showMessageDialog(null, "Função enviada por parâmetro está vazia");
            return;
        }

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, funcao.getNome());
            stmt.setObject(2, LocalDate.now());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Função Registrada com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar função: " + ex.getMessage());
        }
    }

    public ArrayList<Funcao> findAll() {
        ArrayList<Funcao> funcoes = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_LIST);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcao funcao = new Funcao();
                funcao.setId(rs.getInt("id"));
                funcao.setNome(rs.getString("nome"));
                funcoes.add(funcao);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funções: " + ex.getMessage());
        }
        return funcoes;
    }

    public void delete(int id) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Função Removida com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a função da base de dados: " + e.getMessage());
        }
    }

    public void update(Funcao funcao) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, funcao.getNome());
            stmt.setObject(2, LocalDate.now());
            stmt.setInt(3, funcao.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Função atualizada");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar função: " + ex.getMessage());
        }
    }
}
