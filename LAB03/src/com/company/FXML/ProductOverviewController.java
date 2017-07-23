package com.company.FXML;


import com.company.Main;
import com.company.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProductOverviewController {

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productColumn;

    @FXML
    private Label productName;
    @FXML
    private Label productType;
    @FXML
    private Label trainer;
    @FXML
    private Label amount;

    private Main main;

    private void showProductDetails(Product product) {
        if (product != null) {
            productName.setText(product.getName());
            productType.setText(product.getType().toString());
            trainer.setText(String.valueOf(product.isTrainer()));
            amount.setText(String.valueOf(product.getAmount()));
        } else {
            productName.setText("");
            productType.setText("");
            trainer.setText("");
            amount.setText("");
        }
    }

    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0)
            productTable.getItems().remove(selectedIndex);
        else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");

            alert.showAndWait();
        }
    }

    public void setMainApp(Main main) {
        this.main = main;

        productColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showProductDetails(null);

        // Listen for selection changes and show the person details when changed.
        productTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductDetails(newValue));

        // Add observable list data to the table
        productTable.setItems(main.getProductData());
    }

    @FXML
    private void handleNewProduct() {
        Product tempProduct = new Product();
        boolean okClicked = main.showProductEditDialog(tempProduct);
        if (okClicked) {
            main.getProductData().add(tempProduct);
        }
    }

    @FXML
    private void handleEditProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = main.showProductEditDialog(selectedProduct);
            if (okClicked) {
                showProductDetails(selectedProduct);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product in the table.");

            alert.showAndWait();
        }
    }

}

