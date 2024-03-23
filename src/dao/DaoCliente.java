package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexao.Conexao;
import model.Cliente;

public class DaoCliente {

    private static final String SQL_INSERT = "INSERT INTO cliente(nome, contacto, email, data_criacao) VALUES(?,?,?,?)";
    private static final String SQL_LIST = "SELECT * FROM cliente ORDER BY id DESC";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE cliente SET nome=?, contacto=?, email=?, data_actualizacao=? WHERE id=? ";

    public void save(Cliente cliente) {
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente enviado por parâmetro está vazio");
            return;
        }

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getContacto());
            stmt.setString(3, cliente.getEmail());
            stmt.setObject(4, cliente.getDataCriacao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Registrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex.getMessage());
        }
    }

    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_LIST);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setDataCriacao(LocalDate.parse(rs.getString("data_criacao")));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + ex.getMessage());
        }
        return clientes;
    }

    public void delete(int id) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente Removido com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente da base de dados: " + e.getMessage());
        }
    }

    public void update(Cliente cliente) {
        try (Connection conn = Conexao.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getContacto());
            stmt.setString(3, cliente.getEmail());
            stmt.setObject(4, LocalDate.now());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente atualizado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + ex.getMessage());
        }
    }
}
