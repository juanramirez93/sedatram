package com.sedatram.utils;

public class StringsUtil {

	public static final String AUTH = "Autenticaci�n";
	public static final String ENTER = "Ingresar";
	public static final String USER = "Usuario";
	public static final String PASSWORD = "Password";
	public static final String ENTER_DENIED = "Contrase�a inv�lida";
	public static final String CUSTOMERS = "Clientes";
	public static final String DATA_BASES = "Bases de Datos";
	public static final String TITLE = "SedatramApp";
	public static final String ADD = "Agregar";
	public static final String BACK = "Atr�s";
	public static final String DETAIL = "Detalles";
	public static final String EDIT = "Editar";
	public static final String SAVE = "Guardar";
	public static final String FILTER = "Filtro";
	public static final String SEARCH = "Buscar";
	public static final String[] TABLE_COLUMNS_CUSTOMER = { "Identificaci�n", "Nombres", "Tel/Cel", "eMail" };
	public static final String[] NATURAL_CUSTOMER_FIELDS = { "Tipo documento", "N�mero", "Nombres", "Apellidos",
			"E-mail", "Tel�fono", "Celular", "Direcci�n", "Ciudad", "Departamento" };
	public static final String[] NATURAL_CUSTOMER_DOCUMENTS_OPTIONS = { "C�dula", "Tarjeta de " + "Identidad",
			"C�dula de Extranjer�a" };
	public static final String ONLY_NUMBERS_MESSAGE = "Ingrese solo n�meros";
	public static final String ALREADY_EXIST_MESSAGE = "El registro ya existe";
	public static final String INCOMPLETE_DATA_MESSAGE = "Datos incompletos o err�neos";
	public static final String PHONE_ERROR_MESSAGE = "El n�mero de telefono fijo debe tener 8 d�gitos incluyendo el indicativo de la "
			+ "ciudad";
	public static final String CELLPHONE_ERROR_MESSAGE = "El n�mero de celular debe tener 10 d�gitos";
	public static final String SELECT_REGISTER = "Seleccione un registro";
	public static final String DELETE = "Eliminar";
	public static final String SEND_EMAIL = "Enviar e-mail";
	public static final String[] LEGAL_CUSTOMER_FIELDS = { "Tipo documento", "N�mero", "Nombre", "Siglas", "E-mail",
			"Tel�fono", "Celular", "Direcci�n", "Ciudad", "Departamento", "Representante Legal", "Contacto" };
	public static final String RECORDS = "Registros";
	public static final String[] LEGAL_CUSTOMER_DOCUMENTS_OPTIONS = { "NIT" };
	public static final String NATURAL_OR_LEGAL = "Natural o Jur�dico";
	public static final String[] NATURAL_LEGAL = { "Natural", "Jur�dico" };
	public static final String NIT_NOT_VALID = "NIT no v�lido";
	public static final String IDENTIFICATION = "Identificaci�n";
	public static final String NAME = "Nombres";
	public static final String PHONE = "Tel�fono";
	public static final String EXPORT = "Exportar";
	public static final String EXPORT_SUCCESSFUL = "Se export� correctamente";
	public static final String EXPORT_FAILURE = "Ocurri� un error al exportar";
	public static final String[] EXPORT_CUSTOMER_FIELDS = { "Tipo ID", "Identificaci�n", "Nombres", "e-mail",
			"Tel�fono", "Celular", "Direcci�n", "Ciudad", "Departamento", "Representante Legal", "Contacto" };
	public static final String VEHICLES = "Veh�culos";
	public static final String[] TABLE_COLUMNS_VEHICULES = { "Placa", "Servicio", "Clase", "Marca", "L�nea", "Modelo" };
	public static final String[] EXPORT_VEHICLES_FIELDS = { "Placa", "Servicio", "Clase", "Marca", "L�nea", "Modelo",
			"Color", "# Serie", "# Motor", "# Chasis", "VIN", "Cilindraje", "Carrocer�a", "Combustible", "Matr�cula",
			"Tr�nsito", "Capacidad", "PBV", "# Ejes", "C�dula(s) Propietario(s)", "Nombres Propietario(s)" };
	public static final String[] VEHICLE_FIELDS = { "Placa", "Servicio", "Clase", "Marca", "L�nea", "Modelo", "Color",
			"# Serie", "# Motor", "# Chasis", "VIN", "Cilindraje", "Carrocer�a", "Combustible", "Matr�cula", "Tr�nsito",
			"Capacidad", "PBV", "# Ejes" };
	public static final String[] VEHICLE_SERVICES = { "PUBLICO", "PARTICULAR" };
	public static final String WISH_ADD_OWNER = "�Desea agregar propietarios?";
	public static final String OWNERS = "Propietarios";
	public static final String[] TABLE_OWNERS_FIELD = { "Identificaci�n", "Nombres" };
	public static final String VIEW_OWNERS = "Ver propietarios";
	public static final String[] NATURAL_OWNER_FIELDS = { "Tipo documento", "N�mero", "Nombres", "Apellidos" };
	public static final String OWNER_DETAIL = "Detalle Propietario";
	public static final String OPTION_NO_AVAILABLE = "Opci�n no disponible";
	public static final String OWNER = "Agregar/Editar Propietario";
	public static final String[] LEGAL_OWNER_FIELDS = { "Tipo documento", "N�mero", "Nombre", "Siglas" };
	public static final String OLD_PASSWORD = "Contrase�a Actual";
	public static final String NEW_PASSWORD = "Nueva Contrase�a";
	public static final String CONFIRM_PASSWORD = "Confirmar Contrase�a";
	public static final String CHANGE_PASS = "Cambiar Contrase�a";
	public static final Object NOT_SAME = "Las contrase�as no coinciden";
	public static final String PROCESSES = "Procesos";
	public static final String FORMALITY = "Tr�mites";
	public static final String[] TABLE_COLUMNS_FORMALITY = { "Fecha", "ID Cliente", "Nombre Cliente", "Tipo",
			"Estado" };
	public static final String CAPS_ON = "Bloq May�s activado";
	public static final String[] FORMALITY_FIELDS = { "Tipo de tr�mite", "Fecha de inicio", "Cliente", "Veh�culo" };
	public static final String CUSTOMER_DO_NOT_EXIST = "El cliente no existe. �Desea crearlo?";
	public static final String VEHICLE_DO_NOT_EXIST = "El veh�culo no existe. �Desea crearlo?";
	public static final String[] TABLE_COLUMNS_BUYER = { "Identificaci�n", "Nombre", "Celular", "e-Mail" };
	public static final String BUYER = "Compradores";
	public static final String[] NATURAL_BUYER_FIELD = {};

	public static boolean verifyPassword(char[] passwordString, char[] passwordConfirmString) {
		if (passwordString.length == passwordConfirmString.length) {
			for (int i = 0; i < passwordString.length; i++) {
				if (passwordString[i] != passwordConfirmString[i]) {
					return false;
				}
			}
		} else {
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
			} else {
				result.insert(0, chars[dif]);
			}
			i++;
		}
		return result.toString();
	}
}