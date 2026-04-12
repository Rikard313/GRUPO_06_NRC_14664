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

public class V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<Electrodomestico> lista = new ArrayList<>();

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
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Producto");
		lblNewLabel_1.setBounds(10, 41, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 38, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 65, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Reportar");
		btnNewButton.setBounds(10, 101, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBounds(110, 101, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(e -> {

    String nombre = textField.getText();

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
    int id = Integer.parseInt(textField_1.getText());
    double precio = Double.parseDouble(textField_2.getText());

    Electrodomestico nuevo = new Electrodomestico(id, nombre, "Sin marca", precio, 1);

    lista.add(nuevo);

    JOptionPane.showMessageDialog(null, "producto ya agregado");
			
	//Limpiamos los campos
    textField.setText("");
    textField_1.setText("");
    textField_2.setText("");

});
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(209, 101, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreAEliminar = textField.getText().trim();
				if (nombreAEliminar.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del producto a eliminar.");
			        return;
			    }
				boolean encontrado = false;
				for (int i = 0; i < lista.size(); i++) {
			        if (lista.get(i).getNombre().equalsIgnoreCase(nombreAEliminar)) {
			            lista.remove(i);
			            encontrado = true;
			            break; 
			        }
				}

			    if (encontrado) {
			        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        
			    } else {
			        JOptionPane.showMessageDialog(null, "No se encontró ningún producto con ese nombre.");
			    }
			    }
			
		});
		btnNewButton_3.setBounds(308, 101, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 135, 414, 145);
		contentPane.add(textArea);

	}
}
