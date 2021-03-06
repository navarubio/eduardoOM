/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans.informe4505;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author sismacontab
 */
public class ReporteAnexos {
        public void getReporte(String ruta) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();

            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void getAnexo1(String admin, String codadmin, String mcpiopaciente, String dptopaciente, String dptoempresa, String mcpioempresa, String numinform,String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("numinform", numinform);
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void getAnexo2(String admin, String codadmin, String mcpiopaciente, String dptopaciente, 
            String dptoempresa, String mcpioempresa, String dptoprestador, String mcpioprestador, 
            String diagppal, String diagrel1, String diagrel2, String diagrel3, String numinform,
            String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("dptoremite", dptoprestador);
            parameter.put("mcpioremite", mcpioprestador);
            parameter.put("diagppal", diagppal);
            parameter.put("diagrel1", diagrel1);
            parameter.put("diagrel2", diagrel2);
            parameter.put("diagrel3", diagrel3);
            parameter.put("numinform", numinform);
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public void getAnexo3(String admin, String codadmin, String mcpiopaciente, String dptopaciente, 
            String dptoempresa, String mcpioempresa, String services, 
            String diagppal, String diagrel1, String diagrel2, String numinform, int anexo3,
            String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("diagppal", diagppal);
            parameter.put("diagrel1", diagrel1);
            parameter.put("diagrel2", diagrel2);
            parameter.put("services", services);
            parameter.put("numinform", numinform);
            parameter.put("anexo3", anexo3); 
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    
    public void getAnexo4(String admin, String codadmin, String mcpiopaciente, String dptopaciente, 
            String dptoempresa, String mcpioempresa, String services, 
            String numinform, int anexo4, String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("services", services);
            parameter.put("numinform", numinform);
            parameter.put("anexo4", anexo4); 
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void getAnexo5(String admin, String codadmin, String mcpiopaciente, String dptopaciente, 
            String dptoempresa, String mcpioempresa, String dptoresponsable, String mcpioresponsable, String numinform,
            String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("dptoresponsable", dptoresponsable);
            parameter.put("mcpioremite", mcpioresponsable);
            parameter.put("numinform", numinform);
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void getAnexo6(String admin, String codadmin, String mcpiopaciente, String dptopaciente, 
            String dptoempresa, String mcpioempresa, String dptoresponsable, String mcpioresponsable, String numinform,
            String ruta ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if (ruta != null) {

            Connection conexion;
            Class.forName("org.postgresql.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Produccion", "postgres", "091095");

            //Se definen los parametros si es que el reporte necesita
            Map parameter = new HashMap();
            parameter.put("admin", admin);
            parameter.put("codadmin", codadmin);
            parameter.put("mcpiopaciente", mcpiopaciente);
            parameter.put("dptopaciente", dptopaciente);
            parameter.put("dptoempresa", dptoempresa);
            parameter.put("mcpioempresa", mcpioempresa);
            parameter.put("dptoresponsable", dptoresponsable);
            parameter.put("mcpioremite", mcpioresponsable);
            parameter.put("numinform", numinform);
            
            try {
                File file = new File(ruta);

                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

                httpServletResponse.setContentType("application/pdf");
                httpServletResponse.addHeader("Content-Type", "application/pdf");

                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

                JRExporter jrExporter = null;
                jrExporter = new JRPdfExporter();
                jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

                if (jrExporter != null) {
                    try {
                        jrExporter.exportReport();
                    } catch (JRException e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    
}
