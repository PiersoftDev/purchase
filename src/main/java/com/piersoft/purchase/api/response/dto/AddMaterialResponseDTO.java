package com.piersoft.purchase.api.response.dto;


//create response object for addMaterial API from MaterialIndentController with lombok annotations

public class AddMaterialResponseDTO {

        private String status;
        private String message;

        public AddMaterialResponseDTO(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public AddMaterialResponseDTO() {
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
}
