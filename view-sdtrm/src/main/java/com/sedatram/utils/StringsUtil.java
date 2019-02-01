package com.sedatram.utils;

public class StringsUtil {

    public static final String AUTH = "Autenticación";
    public static final String ENTER = "Ingresar";
    public static final String USER = "Usuario";
    public static final String PASSWORD = "Password";
    public static final String ENTER_DENIED = "Contraseña inválida";
    public static final String CUSTOMERS = "Clientes";
    public static final String DATA_BASES = "Bases de Datos";
    public static final String TITLE = "SedatramApp";
    public static final String ADD = "Agregar";
    public static final String BACK = "Atrás";
    public static final String DETAIL = "Detalles";
    public static final String EDIT = "Editar";
    public static final String SAVE = "Guardar";
    public static final String FILTER = "Filtro";
    public static final String SEARCH = "Buscar";
    public static final String[] TABLE_COLUMNS_CUSTOMER =
            {"Identificación", "Nombres", "Tel/Cel", "eMail"};
    public static final String[] NATURAL_CUSTOMER_FIELDS = {"Tipo documento", "Número",
            "Nombres", "Apellidos", "E-mail", "Teléfono", "Celular", "Dirección", "Ciudad",
            "Departamento"};
    public static final String[] NATURAL_CUSTOMER_DOCUMENTS_OPTIONS = {"Cédula", "Tarjeta de " +
            "Identidad", "Cédula de Extranjería"};
    public static final String ONLY_NUMBERS_MESSAGE = "Ingrese solo números";
    public static final String ALREADY_EXIST_MESSAGE = "El registro ya existe";
    public static final String INCOMPLETE_DATA_MESSAGE = "Datos incompletos o erróneos";
    public static final String PHONE_ERROR_MESSAGE =
            "El número de telefono fijo debe tener 8 dígitos incluyendo el indicativo de la " +
                    "ciudad";
    public static final String CELLPHONE_ERROR_MESSAGE =
            "El n�mero de celular debe tener 10 dígitos";
    public static final String SELECT_REGISTER = "Seleccione un registro";
    public static final String DELETE = "Eliminar";
    public static final String SEND_EMAIL = "Enviar e-mail";
    public static final String[] LEGAL_CUSTOMER_FIELDS = {"Tipo documento", "Número",
            "Nombre", "Siglas", "E-mail", "Teléfono", "Celular", "Dirección", "Ciudad",
            "Departamento", "Representante Legal", "Contacto"};
    public static final String RECORDS = "Registros";
    public static final String[] LEGAL_CUSTOMER_DOCUMENTS_OPTIONS = {"NIT"};
    public static final String NATURAL_OR_LEGAL = "Natural o Jurídico";
    public static final String[] NATURAL_LEGAL = {"Natural", "Jurídico"};
    public static final String NIT_NOT_VALID = "NIT no válido";
    public static final String IDENTIFICATION = "Identificación";
    public static final String NAME = "Nombres";
    public static final String PHONE = "Teléfono";
    public static final String EXPORT = "Exportar";
    public static final String EXPORT_SUCCESSFUL = "Se exportó correctamente";
    public static final String EXPORT_FAILURE = "Ocurrió un error al exportar";
    public static final String[] EXPORT_CUSTOMER_FIELDS =
            {"Tipo ID", "Identificación", "Nombres", "e-mail", "Teléfono", "Celular",
                    "Dirección", "Ciudad", "Departamento", "Representante Legal", "Contacto"};
    public static final String VEHICLES = "Vehículos";
    public static final String[] TABLE_COLUMNS_VEHICULES =
            {"Placa", "Servicio", "Clase", "Marca", "Línea", "Modelo"};
    public static final String[] EXPORT_VEHICLES_FIELDS = {"Placa", "Servicio", "Clase", "Marca",
            "Línea", "Modelo", "Color", "# Serie", "# Motor", "# Chasis", "VIN", "Cilindraje",
            "Carrocería", "Combustible", "Matrícula", "Tránsito", "Capacidad", "PBV", "# Ejes",
            "Cédula(s) Propietario(s)", "Nombres Propietario(s)"};
    public static final String[] VEHICLE_FIELDS = {"Placa", "Servicio", "Clase", "Marca",
            "Línea", "Modelo", "Color", "# Serie", "# Motor", "# Chasis", "VIN", "Cilindraje",
            "Carrocería", "Combustible", "Matrícula", "Tránsito", "Capacidad", "PBV", "# Ejes"};
    public static final String[] VEHICLE_SERVICES = {"PUBLICO", "PARTICULAR"};
    public static final String WISH_ADD_OWNER = "¿Desea agregar propietarios?";
    public static final String OWNERS = "Propietarios";
    public static final String[] TABLE_OWNERS_FIELD = {"Identificación", "Nombres"};
    public static final String VIEW_OWNERS = "Ver propietarios";
    public static final String[] NATURAL_OWNER_FIELDS = {"Tipo documento", "Número",
            "Nombres", "Apellidos"};
    public static final String OWNER_DETAIL = "Detalle Propietario";
    public static final String OPTION_NO_AVAILABLE = "Opción no disponible";
    public static final String OWNER = "Agregar/Editar Propietario";
    public static final String[] LEGAL_OWNER_FIELDS = {"Tipo documento", "Número",
            "Nombre", "Siglas"};
    public static final String OLD_PASSWORD = "Contraseña Actual";
    public static final String NEW_PASSWORD = "Nueva Contraseña";
    public static final String CONFIRM_PASSWORD = "Confirmar Contraseña";
    public static final String CHANGE_PASS = "Cambiar Contraseña";
    public static final Object NOT_SAME = "Las contraseñas no coinciden";
    public static final String PROCESSES = "Procesos";
    public static final String FORMALITY = "Trámites";
    public static final String[] TABLE_COLUMNS_FORMALITY =
            {"Fecha", "ID Cliente", "Nombre Cliente", "Tipo", "Estado"};
    public static final String CAPS_ON = "Bloq Mayús activado";
    public static final String[] FORMALITY_FIELDS = {"Tipo de trámite","Fecha de inicio", "Cliente", "Vehículo"};
    public static final String CUSTOMER_DO_NOT_EXIST = "El cliente no existe. ¿Desea crearlo?";
	public static final String VEHICLE_DO_NOT_EXIST = "El vehículo no existe. ¿Desea crearlo?";

    public static boolean verifyPassword(char[] passwordString, char[] passwordConfirmString) {
        if (passwordString.length == passwordConfirmString.length) {
            for (int i = 0; i < passwordString.length; i++) {
                if (passwordString[i] != passwordConfirmString[i]) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

    public static String formatId(String iden) {
        char[] chars = iden.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 1;
        while (i <= chars.length) {
            int dif = chars.length - i;
            if (i % 3 == 0 && i != chars.length) {
                result.insert(0, "." + chars[dif]);
            }
            else {
                result.insert(0, chars[dif]);
            }
            i++;
        }
        return result.toString();
    }
}
