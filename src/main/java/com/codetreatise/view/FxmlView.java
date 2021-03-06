package com.codetreatise.view;

import java.util.ResourceBundle;

public enum FxmlView {

    USER {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("admin.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Admin-side.fxml";
        }
    }, 
    Comptable {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("comptable.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Comptable-side.fxml";
        }
    },Serveur {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("serveur.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/ServerSide.fxml";
        }
    },
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
    MenuMangement {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("menu.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Menu3Gestion.fxml";
        }
    },
    HrMangement {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("hr.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Employee-Gestion.fxml";
        }
    };;
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
