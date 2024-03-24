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
import model.Cliente;
import model.OrdemServico;
import model.Tecnico;

public class DaoOrdemDeServico {

    private static final String SQL_INSERT = "INSERT INTO ordem_servico(equipamento,status,avaria,servico,id_tecnico,valor,iva,data,id_cliente,operacao) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_LIST = "SELECT o.*, c.nome AS cliente, t.nome AS tecnico FROM ordem_servico AS o "
            + "INNER JOIN cliente AS c ON c.id = o.id_cliente "
            + "INNER JOIN tecnico AS t ON t.id = o.id_tecnico WHERE o.operacao<> 'SAIDA' ORDER BY o.id DESC";
    private static final String SQL_DELETE = "DELETE FROM ordem_servico WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE ordem_servico SET equipamento=?, status=?, avaria=?, servico=?, "
            + "id_tecnico=?, valor=?, iva=?, data=?, id_cliente=?, operacao=? WHERE id=?";

    public void save(OrdemServico ordemServico) throws SQLException {
        if (ordemServico == null) {
            JOptionPane.showMessageDialog(null, "Ordem de Serviço enviada por parâmetro está vazia");
            return;
        }

        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, ordemServico.getEquipamento());
            stmt.setString(2, ordemServico.getStatus());
            stmt.setString(3, ordemServico.getAvaria());
            stmt.setString(4, ordemServico.getServico());
            stmt.setInt(5, ordemServico.getTecnico().getId());
            stmt.setDouble(6, ordemServico.getValor());
            stmt.setDouble(7, ordemServico.getIva());
            stmt.setObject(8, ordemServico.getData());
            stmt.setInt(9, ordemServico.getCliente().getId());
            stmt.setString(10, ordemServico.getOperacao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ordem de Serviço registrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a Ordem de Serviço: " + ex.getMessage());
        }
    }

    //end of save
    public List<OrdemServico> findAll() {
        List<OrdemServico> ordemServicoList = new ArrayList<>();

        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(SQL_LIST); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OrdemServico ordemServico = extractOrdemServicoFromResultSet(rs);
                ordemServicoList.add(ordemServico);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as Ordens de Serviço: " + ex.getMessage());
        }

        return ordemServicoList;
    }

    /**/
    /**
     * /
     *
     * @param status
     * @return
     */
    public List<OrdemServico> findAllByStatus(String status) {
        List<OrdemServico> ordemServicoList = new ArrayList<>();
        String query = "SELECT o.*, c.nome AS cliente, t.nome AS tecnico FROM ordem_servico AS o "
                + "INNER JOIN cliente AS c ON c.id = o.id_cliente "
                + "INNER JOIN tecnico AS t ON t.id = o.id_tecnico "
                + "WHERE o.status = ? ORDER BY o.id DESC";

        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrdemServico ordemServico = extractOrdemServicoFromResultSet(rs);
                    ordemServicoList.add(ordemServico);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as Ordens de Serviço por status: " + ex.getMessage());
        }

        return ordemServicoList;
    }

    /**/
    /**
     * /
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public List<OrdemServico> findAllByDate(String startDate, String endDate) {
        List<OrdemServico> ordemServicoList = new ArrayList<>();
        String query = "SELECT o.*, c.nome AS cliente, t.nome AS tecnico FROM ordem_servico AS o "
                + "INNER JOIN cliente AS c ON c.id = o.id_cliente "
                + "INNER JOIN tecnico AS t ON t.id = o.id_tecnico "
                + "WHERE o.data BETWEEN ? AND ? ORDER BY o.id DESC";

        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrdemServico ordemServico = extractOrdemServicoFromResultSet(rs);
                    ordemServicoList.add(ordemServico);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as Ordens de Serviço por data: " + ex.getMessage());
        }

        return ordemServicoList;
    }

    /**/
    /**
     * /
     *
     * @param id
     */
    public void delete(int id) {
        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Ordem de Serviço removida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a Ordem de Serviço: " + ex.getMessage());
        }
    }

    /**/
    /**
     * /
     *
     * @param ordemServico
     * @throws java.sql.SQLException
     */
    public void update(OrdemServico ordemServico) throws SQLException {
        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, ordemServico.getEquipamento());
            stmt.setString(2, ordemServico.getStatus());
            stmt.setString(3, ordemServico.getAvaria());
            stmt.setString(4, ordemServico.getServico());
            stmt.setInt(5, ordemServico.getTecnico().getId());
            stmt.setDouble(6, ordemServico.getValor());
            stmt.setDouble(7, ordemServico.getIva());
            stmt.setObject(8, ordemServico.getData());
            stmt.setInt(9, ordemServico.getCliente().getId());
           
            stmt.setString(10, ordemServico.getOperacao());
            stmt.setInt(11, ordemServico.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ordem de Serviço atualizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a Ordem de Serviço: " + ex.getMessage());
        }
    }

    /**/
    private OrdemServico extractOrdemServicoFromResultSet(ResultSet rs) throws SQLException {
        OrdemServico ordemServico = new OrdemServico();
        Cliente cliente = new Cliente();
        cliente.setNome(rs.getString("cliente"));
        Tecnico tecnico = new Tecnico();
        tecnico.setNome(rs.getString("tecnico"));
        ordemServico.setId(rs.getInt("id"));
        ordemServico.setEquipamento(rs.getString("equipamento"));
        ordemServico.setStatus(rs.getString("status"));
        ordemServico.setAvaria(rs.getString("avaria"));
        ordemServico.setServico(rs.getString("servico"));
        ordemServico.setOperacao(rs.getString("operacao"));
        ordemServico.setTecnico(tecnico);
        ordemServico.setValor(rs.getDouble("valor"));
        ordemServico.setIva(rs.getDouble("iva"));
        ordemServico.setData(LocalDate.parse(rs.getString("data")));
        ordemServico.setCliente(cliente);

        return ordemServico;
    }

    public OrdemServico findById(int id) {
        OrdemServico ordemServico = new OrdemServico();
        String query = "SELECT * FROM ordem_servico WHERE id=?";
        try (Connection conn = Conexao.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente=new Cliente();
                    cliente.setId(rs.getInt("id_cliente"));
                    //
                    Tecnico tecnico=new Tecnico();
                    tecnico.setId(rs.getInt("id_tecnico"));
                    //
                    ordemServico.setTecnico(tecnico);
                    //
                    ordemServico.setCliente(cliente);
                            
                    ordemServico.setId(rs.getInt("id"));
                    ordemServico.setEquipamento(rs.getString("equipamento"));
                    ordemServico.setStatus(rs.getString("status"));
                    ordemServico.setAvaria(rs.getString("avaria"));
                    ordemServico.setServico(rs.getString("servico"));
                    ordemServico.setOperacao(rs.getString("operacao"));
                    ordemServico.setValor(rs.getDouble("valor"));
                    ordemServico.setIva(rs.getDouble("iva"));
                    ordemServico.setData(LocalDate.parse(rs.getString("data")));
                    

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as Ordens de Serviço por Id: " + ex.getMessage());
        }

        return ordemServico;
    }
}
