package report;

import conexao.Conexao;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ControllerRelatorio {

    private final Connection conn;

    public ControllerRelatorio() {
        conn = Conexao.connect();
    }

    public String getPathForOs() {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            return "C:\\os\\";
        } else if (osName.startsWith("Linux")) {
            return "/home/jbila/os/";
        } else {
            // Default path for other/unknown OS
            return "/default/path";
        }
    }

    private void emitirRelatorio(String jasperFile, HashMap<String, Object> parametros) {
        int confirm = JOptionPane.showConfirmDialog(null, "Confirma a emissão deste relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                JasperPrint print = JasperFillManager.fillReport(jasperFile, parametros, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao emitir o Relatório: " + ex.getMessage());
            }
        }
    }

    public void emitirOsPorStatus(String estado) {
        HashMap<String, Object> parametros=new HashMap();
        parametros.put("STATUS",estado);
        emitirRelatorio(getPathForOs() + "os_pagamento.jasper", parametros);
    }

    public void emitirOsPorData(String startDate, String endDate) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("DATA1", startDate);
        parametros.put("DATA2", endDate);
        emitirRelatorio(getPathForOs() + "os_por_datas.jasper", parametros);
    }

    public void emitirTecnicoReport() {
        emitirRelatorio(getPathForOs() + "os_tecnico.jasper", null);
    }

    public void emitirClienteReport() {
        emitirRelatorio(getPathForOs() + "os_cliente.jasper", null);
    }

    public void emitirUtilizadorReport() {
        emitirRelatorio(getPathForOs() + "os_utilizador.jasper", null);
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
        }
    }
}
