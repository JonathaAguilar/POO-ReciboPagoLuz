package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import modelo.Recibo;
import vista.vista;

public class Controlador implements ActionListener{
    private vista vista;
    private Recibo rec;
    
public Controlador(Recibo rec, vista vista) {
        this.vista = vista;
        this.rec = rec;
      
        vista.btGuardar.addActionListener(this);
        vista.btMostrar.addActionListener(this);
        vista.btNuevo.addActionListener(this); 
        vista.cmbTipo.addActionListener(this);
        vista.btCancelar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btCerrar.addActionListener(this);
    }
    
    public void iniciarVista(){
        vista.setTitle("::RECIBO::");
        vista.setSize(470, 500);
        vista.setVisible(true);
    }
        public void limpiar(){
        vista.txtRecibo.setText("");
        vista.txtNombre.setText("");
        vista.txtDomicilio.setText("");
        vista.txtFecha.setText("");
        vista.txtCostoKi.setText("");
        vista.txtKiCon.setText("");
        vista.lblsub.setText("$");
        vista.lblImpuesto.setText("$");
        vista.lblTotal.setText("$");
        vista.cmbTipo.setSelectedIndex(0);
    }
    
    public static void main(String[] args) {
        Recibo rec = new Recibo();
        vista vista = new vista(new JFrame(), true);
        Controlador contra = new Controlador(rec, vista);
        contra.iniciarVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==vista.btNuevo){
            vista.txtRecibo.setEnabled(true);
            vista.txtNombre.setEnabled(true);
            vista.txtDomicilio.setEnabled(true);
            vista.txtFecha.setEnabled(true);
            vista.txtCostoKi.setEnabled(true);
            vista.txtKiCon.setEnabled(true);
            vista.lblsub.setEnabled(true);
            vista.lblImpuesto.setEnabled(true);
            vista.lblTotal.setEnabled(true);
            vista.cmbTipo.setEnabled(true);
            vista.btGuardar.setEnabled(true);
            vista.btMostrar.setEnabled(true);
            vista.btnLimpiar.setEnabled(true);
            vista.btCancelar.setEnabled(true);
            vista.btCerrar.setEnabled(true);
        }
        if(e.getSource()==vista.btnLimpiar){
            limpiar();
        }
        if(e.getSource()==vista.btCancelar){
            vista.txtRecibo.setEnabled(false);
            vista.txtNombre.setEnabled(false);
            vista.txtDomicilio.setEnabled(false);
            vista.txtFecha.setEnabled(false);
            vista.txtCostoKi.setEnabled(false);
            vista.txtKiCon.setEnabled(false);
            vista.lblsub.setEnabled(false);
            vista.lblImpuesto.setEnabled(false);
            vista.lblTotal.setEnabled(false);
            vista.cmbTipo.setEnabled(false);
            vista.btGuardar.setEnabled(false);
            vista.btMostrar.setEnabled(false);
            vista.btnLimpiar.setEnabled(false);
            vista.btCancelar.setEnabled(false);
            vista.btCerrar.setEnabled(false);
            limpiar();
        }
        if(e.getSource()==vista.btMostrar){
            vista.txtRecibo.setText(Integer.toString(rec.getNumRecibo()));
            vista.txtNombre.setText(rec.getNombre());
            vista.txtFecha.setText(rec.getFecha());
            vista.txtCostoKi.setText(Float.toString(rec.getCostoK()));
            vista.txtKiCon.setText(Float.toString(rec.getKiCon()));
            vista.txtDomicilio.setText(rec.getDomicilio());
            vista.cmbTipo.setSelectedIndex(rec.getTipoSer());
            vista.lblImpuesto.setText("$" +Float.toString(rec.calcularImpuestos()));
            vista.lblsub.setText(Float.toString(rec.calcularSub()));
            vista.lblTotal.setText("$ "+Float.toString(rec.calcularTotal()));       }
    
        if(e.getSource()==vista.btCerrar){
            int option=JOptionPane.showConfirmDialog(vista,"¿Deseas salir?",
            "Decide", JOptionPane.YES_NO_OPTION);
             if(option==JOptionPane.YES_NO_OPTION){
                 vista.dispose();
                 System.exit(0);
             }
        }
        if(e.getSource()==vista.btGuardar){
            try{
            rec.setNombre(vista.txtNombre.getText());
            rec.setFecha(vista.txtFecha.getText());
            rec.setDomicilio(vista.txtDomicilio.getText());
            rec.setNumRecibo(Integer.parseInt(vista.txtRecibo.getText()));
            
            rec.setKiCon(Float.parseFloat(vista.txtKiCon.getText()));
            rec.setTipoSer(vista.cmbTipo.getSelectedIndex());
             switch (rec.getTipoSer()){
                case 0:
                    rec.setCostoK(2);
                    break;
                case 1:
                    rec.setCostoK(3);
                    break;
                case 2:
                    rec.setCostoK(5);
                    break;
            }
           
            JOptionPane.showMessageDialog(vista, "Se guardo con Exito");
        }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(vista, "Surgio el siguiente error:" +ex.getMessage());       
        
        }catch(Exception ex2){
                JOptionPane.showMessageDialog(vista, "Surgio el siguiente error:" +ex2.getMessage());}       


        }
    }
}
