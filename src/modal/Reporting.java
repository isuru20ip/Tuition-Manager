package modal;

import java.io.File;
import java.util.HashMap;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

public class Reporting {

    // find save folder
    private String getFolder() {
        // Create the JFileChooser instance
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Show the open dialog
        int result = folderChooser.showOpenDialog(null);

        // Check if a folder was selected
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = folderChooser.getSelectedFile();
            return selectedFolder.getAbsolutePath();
        }
        return null;
    }

    // save reports
    public boolean saveReport(String reportName, HashMap parm, JRDataSource dataSource) throws JRException {
        String path = getFolder();
        if (path == null) {
            return false;
        }
        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm, dataSource);
        JasperExportManager.exportReportToPdfFile(print, path + "/" + reportName + modal.SetDate.getDate("yyyy-MM-dd HH.mm").replace(" ", "_") + ".pdf");
        return true;
    }

    // save reports
    public boolean saveReport(String reportName, HashMap parm) throws JRException {
        String path = getFolder();
        if (path == null) {
            return false;
        }

        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm);
        JasperExportManager.exportReportToPdfFile(print, path + "/" + reportName + modal.SetDate.getDate("yyyy-MM-dd HH.mm").replace(" ", "_") + ".pdf");
        return true;
    }

    // viwe reports
    public void viewReport(String reportName, HashMap parm, JRDataSource dataSourse) throws JRException {
        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm, dataSourse);
        JasperViewer.viewReport(print, false);
    }

    // view reports
    public void viewReport(String reportName, HashMap parm) throws JRException {
        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm);
        JasperViewer.viewReport(print, false);
    }

    // print reports
    public boolean printReport(String reportName, HashMap parm, JRDataSource dataSourse) throws JRException {
        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm, dataSourse);
        return JasperPrintManager.printReport(print, true);
       
    }

    // print reports
    public boolean printReport(String reportName, HashMap parm) throws JRException {
        JasperPrint print = JasperFillManager.fillReport("src//report//" + reportName + ".jasper", parm);
        return JasperPrintManager.printReport(print, true);
       
    }
}
