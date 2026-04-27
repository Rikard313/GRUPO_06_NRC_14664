package clase;

public class Electrodomestico {

	 private int id;
	    private String nombre;
	    private String marca;
	    private double precio;
	    private int stock;
		public Electrodomestico (int id, String nombre){
		this.id = id;
    	this.nombre = nombre;
    	this.marca = "Sin marca";
    	this.precio = 0.0;
    	this.stock = 0;
		}
		public Electrodomestico(int id, String nombre, double precio){
		this.id = id;
    	this.nombre = nombre;
    	this.marca = "Sin marca";
   	 	this.precio = precio;
   	 	this.stock = 1;
		}
		public Electrodomestico(int id, String nombre, String marca, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
	    
}
