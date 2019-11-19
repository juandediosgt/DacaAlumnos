/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.primefaces.context.RequestContext;

import utils.Conexion;


/**
 *
 * @author Ismael Ruiz
 */
public class CrearReporteBean extends Conexion implements Serializable {

    private String urlPdfFile;
    private String nameReport;
    private Date fechaInicial;
    private Date fechaFinal;
    private String idAlumno;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy/MM/dd");
    

    /**
     * Creates a new instance of ReportesBean
     */
    public CrearReporteBean() {

    }

    //Metodo que cierra el popUp del reporte
    public void cerrarReportePopUp() {

    }
        //Metodo que crea el reporte de usuarios activos
    public void reporteJasperAlumnos() throws ServletException, IOException, ClassNotFoundException, JRException, SQLException, ParseException {
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();

            // Get jasper report
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String jrxmlFileName = ctx.getRealPath("/Jasper/infoAlumno.jrxml");
            ServletContext ctx2 = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String urlPdfFileName = ctx2.getRealPath("/Jasper");
//            ServletContext ctx4 = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//            String rutaImagen = ctx4.getRealPath("/Images/logo.jpg");

            // Create arguments
            HashMap hm = null;
            hm = new HashMap();
            //hm.put("logo", rutaImagen);

            //Compiled and Export Report
            JasperReport report = JasperCompileManager.compileReport(jrxmlFileName);
            JasperPrint print = JasperFillManager.fillReport(report, hm, conect);
            JasperExportManager.exportReportToPdfFile(print, urlPdfFileName + "/Alumnos.pdf");
            this.setUrlPdfFile(this.getUrlReportesPdf() + "Alumnos.pdf");
            this.setNameReport("REPORTE DE USUARIOS ACTIVOS");
            RequestContext dialogPdf = RequestContext.getCurrentInstance();
            dialogPdf.execute("PF('dglReport').show();");
            conect.close();
        } catch (SQLException | IOException | JRException ex) {
            ex.printStackTrace();
        }
    }

    //Metodo que crea el reporte de usuarios activos
    public void reporteJasperReport() throws ServletException, IOException, ClassNotFoundException, JRException, SQLException, ParseException {
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();

            // Get jasper report
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String jrxmlFileName = ctx.getRealPath("/Jasper/usuariosActivos.jrxml");
            ServletContext ctx2 = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String urlPdfFileName = ctx2.getRealPath("/Jasper");
//            ServletContext ctx4 = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//            String rutaImagen = ctx4.getRealPath("/Images/logo.jpg");

            // Create arguments
            HashMap hm = null;
            hm = new HashMap();
            //hm.put("logo", rutaImagen);

            //Compiled and Export Report
            JasperReport report = JasperCompileManager.compileReport(jrxmlFileName);
            JasperPrint print = JasperFillManager.fillReport(report, hm, conect);
            JasperExportManager.exportReportToPdfFile(print, urlPdfFileName + "/Usuarios.pdf");
            this.setUrlPdfFile(this.getUrlReportesPdf() + "Usuarios.pdf");
            this.setNameReport("REPORTE DE USUARIOS ACTIVOS");
            RequestContext dialogPdf = RequestContext.getCurrentInstance();
            dialogPdf.execute("PF('dglReport').show();");
            conect.close();
        } catch (SQLException | IOException | JRException ex) {
            ex.printStackTrace();
        }
    }

    //Metodos gets y sets
    public String getUrlPdfFile() {
        return urlPdfFile;
    }

    public void setUrlPdfFile(String urlPdfFile) {
        this.urlPdfFile = urlPdfFile;
    }

    public String getNameReport() {
        return nameReport;
    }

    public void setNameReport(String nameReport) {
        this.nameReport = nameReport;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public SimpleDateFormat getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(SimpleDateFormat formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public SimpleDateFormat getFormatoFecha2() {
        return formatoFecha2;
    }

    public void setFormatoFecha2(SimpleDateFormat formatoFecha2) {
        this.formatoFecha2 = formatoFecha2;
    }
}
