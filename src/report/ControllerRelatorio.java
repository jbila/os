package report;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jbila
 */
public class ControllerRelatorio {

    private Connection conn = null;

    public ControllerRelatorio() {
        conn = (Connection) Conexao.connect();
    }

    public String getOs() {
        String osName = System.getProperty("os.name");
        String filePath;
        if (osName.startsWith("Windows")) {
            filePath = "C:\\os\\";
        } else if (osName.startsWith("Linux")) {
            filePath = "/home/jbila/os/";
        } else {
            // Default path for other/unknown OS
            filePath = "/default/path";
        }

        return filePath;
    }

    public void os() {
        int confirm = JOptionPane.showConfirmDialog(null, "Confrima a emissao deste relatorio?", "Atencao", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            try {

                JasperPrint print = JasperFillManager.fillReport(getOs(), null, conn);
                JasperViewer.viewReport(print, false);
                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao emetir o Relat�rio de Venda " + ex);

            } catch (java.lang.NoClassDefFoundError e) {
                JOptionPane.showMessageDialog(null, "ERRO " + e);

            }

        }

    }
//-----------------------------------------------------------------------------------------------------------------------

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void relatorioProductoVendidosPorData() {

        int confirm = JOptionPane.showConfirmDialog(null, "Confrima a emiss�o deste relat�rio?", "Aten��o", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            try {
                /*
                HashMap parametro = new HashMap<>();
                parametro.put("dataInicio", FrmVendas.date1);
                parametro.put("dataFim", FrmVendas.date2);
                 */

                //String caminho="src/bila/co/mz/Reports/Vendas.jasper";
                String caminho01 = "C:/Reports/Vendas.jasper";
                // JasperPrint print = JasperFillManager.fillReport(caminho01, parametro, conn);
                //    JasperViewer.viewReport(print, false);
                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao emetir o Relat�rio de Venda " + ex);

            } catch (java.lang.NoClassDefFoundError e) {
                JOptionPane.showMessageDialog(null, "ERRO " + e);

            }

        }

    }
//-------------------------------------------------------------------------------------------------------------------------

    public void getTecnicoReport() {
        Connection conn = null;
          conn =Conexao.connect();

        int confirm = JOptionPane.showConfirmDialog(null, "Confrima a emissao deste relatario?", "Atencao", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            try {

                JasperPrint jasperPrint = JasperFillManager.fillReport(getOs() + "os_tecnico.jasper", null, conn);
                JasperViewer.viewReport(jasperPrint, false);

                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao emetir o Relatorio de fornecedor " + ex);

            } catch (java.lang.NoClassDefFoundError e) {
                //JOptionPane.showMessageDialog(null, "ERRO "+e);
                System.out.print(e);

            }

        }

    }
    
    
//-----------------------------------Relatorio de Vendas----------------------------------------------------------------

    public void getClienteReport() throws JRException, SQLException {

        int confirm = JOptionPane.showConfirmDialog(null, "Confirma a emissao deste relatorio?", "Atencao", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            try {
                JasperPrint print = JasperFillManager.fillReport(getOs(), null, conn);
                JasperViewer.viewReport(print, false);
                conn.close();

            } catch (java.lang.NoClassDefFoundError e) {
                JOptionPane.showMessageDialog(null, "ERRO " + e);

            }

        }

    }
//-------------

}
