package com.company.FXML;

import com.company.Product;
import com.company.ProductType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductEditDialogController {
    @FXML
    private TextField productNameField;
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox<ProductType> productTypeField = new ComboBox<>();

    @FXML
    private CheckBox trainerField;

    private Stage dialogStage;
    private Product product;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
        productTypeField.getItems().setAll(ProductType.values());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            product.setName(productNameField.getText());
            product.setAmount(Integer.parseInt(amountField.getText()));
            product.setType(productTypeField.getValue());
            product.setTrainer(trainerField.isSelected());
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (productNameField.getText() == null || productNameField.getText().length() == 0) {
            errorMessage += "No valid product name!\n";
        }

        if (amountField.getText() == null || amountField.getText().length() == 0 ||
                Integer.parseInt(amountField.getText()) <= 0) {
            errorMessage += "No valid amount!\n";
        }

        if (productTypeField.getValue() == null) {
            errorMessage += "No valid product type!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (!product.isValid()) {
            productNameField.setText("");
            amountField.setText("");
            productTypeField.getSelectionModel().selectFirst();
            trainerField.fire();
        } else {
            productNameField.setText(product.getName());
            amountField.setText(String.valueOf(product.getAmount()));
            productTypeField.getSelectionModel().select(product.getType());
            if (product.isTrainer())
                //trainerField.setText(String.valueOf(product.isTrainer()));
                trainerField.fire();
        }
    }
}
