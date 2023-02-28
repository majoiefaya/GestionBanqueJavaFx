module GestionBancaire {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	exports model;
	
	
	
	opens application to javafx.graphics, javafx.fxml;
}
