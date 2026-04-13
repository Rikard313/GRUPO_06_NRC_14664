package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import clase.Electrodomestico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtIDProd;
	private JTextField txtPrecio;
	private ArrayList<Electrodomestico> lista = new ArrayList<>();
	private JButton BotonEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setBounds(66, 8, 86, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Producto");
		lblNewLabel_1.setBounds(10, 41, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		txtIDProd = new JTextField();
		txtIDProd.setBounds(87, 38, 86, 20);
		contentPane.add(txtIDProd);
		txtIDProd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(66, 65, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnNewButton = new JButton("Reportar");
		btnNewButton.setBounds(10, 101, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBounds(110, 101, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(e -> {

    String nombre = txtNom.getText();

    //Validamos que no se agreguen números
    if (!nombre.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "Solo se permiten letras y no números en el nombre");
        return;
    }

    //Verificamos si el producto ya existe
    for (Electrodomestico e1 : lista) {
        if (e1.getNombre().equalsIgnoreCase(nombre)) {
            JOptionPane.showMessageDialog(null, "producto repetido");
            return;
        }
    }

    //Creamos o agregamos un nuevo producto
    int id = Integer.parseInt(txtIDProd.getText());
    double precio = Double.parseDouble(txtPrecio.getText());

    Electrodomestico nuevo = new Electrodomestico(id, nombre, "Sin marca", precio, 1);

    lista.add(nuevo);

    JOptionPane.showMessageDialog(null, "producto ya agregado");
			
	//Limpiamos los campos
    txtNom.setText("");
    txtIDProd.setText("");
    txtPrecio.setText("");

});
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(209, 101, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int idBuscado = Integer.parseInt(txtIDProd.getText());

		            boolean encontrado = false;

		            for (Electrodomestico elec : lista) {
		                if (elec.getId() == idBuscado) {

		                    txtNom.setText(elec.getNombre());
		                    txtPrecio.setText(String.valueOf(elec.getPrecio()));

		                    encontrado = true;
		                    break;
		                }
		            }

		            if (!encontrado) {
		                JOptionPane.showMessageDialog(null, "Producto no encontrado");
		            }

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Ingrese un ID válido");
		        }
		    }
			}
		);
		contentPane.add(btnNewButton_2);
		
		JTextArea txtS = new JTextArea();
		txtS.setBounds(10, 135, 414, 145);
		contentPane.add(txtS);
		{
			BotonEliminar = new JButton("Eliminar");
			BotonEliminar.addActionListener(this);
			BotonEliminar.setBounds(310, 101, 89, 23);
			contentPane.add(BotonEliminar);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BotonEliminar) {
			do_btnNewButton_3_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		
	}
}
