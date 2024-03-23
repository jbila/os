package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import java.util.List;
import model.Utilizador;

public class DaoUtilizador {

    private static final String SQL_INSERT = "INSERT INTO utilizador(nome,email,password,status,perfil,data_criacao) VALUES(?,?,?,?,?,?)";
    private static final String SQL_LIST = "SELECT * FROM utilizador ORDER BY id DESC";
    private static final String SQL_DELETE = "DELETE FROM utilizador WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE utilizador SET nome=?,email=?,password=?,status=?,perfil=?,data_actualizacao=? WHERE id=?";

    public void save(Utilizador utilizador) {
        if (utilizador == null) {
            JOptionPane.showMessageDialog(null, "Utilizador enviado por parâmetro está vazio");
            return;
        }

        try (Connection conn = Conexao.connect(); 
                PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, utilizador.getNome());
            stmt.setString(2, utilizador.getEmail());
            stmt.setString(3, utilizador.getPassword());
            stmt.setString(4, utilizador.getStatus());
            stmt.setString(5, utilizador.getPerfil());
            stmt.setObject(6, utilizador.getDataCriacao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Utilizador registado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o utilizador: " + ex.getMessage());
        }
    }
     public Utilizador findByUserName(String username) {
       Utilizador  utilizador =null;

        try (Connection conn = Conexao.connect(); 
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilizador WHERE  email='"+username+"' "); 
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                utilizador = extractUtilizadorFromResultSet(rs);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar utilizadores: " + ex.getMessage());
        }

        return utilizador;
    }

    public List<Utilizador> findAll() {
        List<Utilizador> utilizadors = new ArrayList<>();

        try (Connection conn = Conexao.connect(); 
                PreparedStatement stmt = conn.prepareStatement(SQL_LIST); 
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Utilizador utilizador = extractUtilizadorFromResultSet(rs);
                utilizadors.add(utilizador);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar utilizadores: " + ex.getMessage());
        }

        return utilizadors;
    }
       private Utilizador extractUtilizadorFromResultSet(ResultSet rs) throws SQLException {
        Utilizador utilizador = new Utilizador();
        utilizador.setId(rs.getInt("id"));
        utilizador.setNome(rs.getString("nome"));
        utilizador.setEmail(rs.getString("email"));
        utilizador.setStatus(rs.getString("status"));
        utilizador.setPerfil(rs.getString("perfil"));
           utilizador.setPassword(rs.getString("password"));
        utilizador.setDataCriacao(LocalDate.parse(rs.getString("data_criacao")));
        return utilizador;
    }

    public void delete(int id) {
        try (Connection conn = Conexao.connect(); 
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Utilizador removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o utilizador da base de dados: " + ex.getMessage());
        }
    }

    public void update(Utilizador utilizador) {
        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, utilizador.getNome());
            stmt.setString(2, utilizador.getEmail());
            stmt.setString(3, utilizador.getPassword());
            stmt.setString(4, utilizador.getStatus());
            stmt.setString(5, utilizador.getPerfil());
            stmt.setObject(6, LocalDate.now());
            stmt.setInt(7, utilizador.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Utilizador atualizado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o utilizador: " + ex.getMessage());
        }
    }

 
}
