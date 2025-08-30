-- Crear la base de datos
DROP DATABASE IF EXISTS eventsys_lb;
CREATE DATABASE eventsys_lb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE eventsys_lb;

-- ============================
-- TABLAS MAESTRAS
-- ============================

-- Tabla de tipos de documento
CREATE TABLE tipo_documento (
    id_tipo_documento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
         -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de géneros
CREATE TABLE genero (
    id_genero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
         -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de estado civil
CREATE TABLE estado_civil (
    id_estado_civil INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
         -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de estados generales (activo, inactivo, suspendido, etc.)
CREATE TABLE estado (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
         -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de departamentos
CREATE TABLE departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
         -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de cargos
CREATE TABLE cargos (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    id_departamento INT NOT NULL,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento) ON DELETE CASCADE
);


-- ============================
-- USUARIOS Y SEGURIDAD
-- ============================

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    id_estado INT NOT NULL,
     -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
     -- Relacion
     FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

-- Tabla de roles
CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion TEXT,
     -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de permisos
CREATE TABLE permisos (
    id_permiso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
     -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Relación N:M roles - permisos
CREATE TABLE roles_permisos (
    id_rol INT,
    id_permiso INT,
	-- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_rol, id_permiso),
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol) ON DELETE CASCADE,
    FOREIGN KEY (id_permiso) REFERENCES permisos(id_permiso) ON DELETE CASCADE
);

-- Relación N:M entre usuarios y roles
CREATE TABLE usuario_roles (
    id_usuario INT,
    id_rol INT,
     -- Auditoría
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_usuario, id_rol),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol) ON DELETE CASCADE
);
 
-- Tabla de empleados
CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_documento INT  NULL,
    numero_documento VARCHAR(15) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
	apellidos VARCHAR(100) NOT NULL,
	fecha_nacimiento DATE,
	id_genero INT NOT NULL,
	id_estado_civil INT NOT NULL,
	telefono VARCHAR(50),
	email_personal VARCHAR(100),
	email_corporativo VARCHAR(100),
	direccion VARCHAR(255),
	id_departamento INT NULL,
    id_cargo INT NULL,
    fecha_ingreso DATE NOT NULL,
	fecha_cese DATE NULL,
    motivo_cese VARCHAR(255) NULL,
    salario DECIMAL(10,2) NOT NULL DEFAULT 0.00 CHECK (salario >= 0),
	id_estado INT NULL,
	id_usuario INT NULL,
    -- Campos de auditoría
	fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
	fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	usuario_actualizacion VARCHAR(50) NOT NULL,
    -- Relaciones
	FOREIGN KEY (id_cargo) REFERENCES cargos(id_cargo) ON DELETE SET NULL,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado) ON DELETE SET NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE SET NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento) ON DELETE SET NULL,
    FOREIGN KEY (id_tipo_documento) REFERENCES tipo_documento(id_tipo_documento) ON DELETE SET NULL,
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero) ON DELETE RESTRICT,
    FOREIGN KEY (id_estado_civil) REFERENCES estado_civil(id_estado_civil) ON DELETE RESTRICT
);

-- Tabla de Categoria_productos
CREATE TABLE categorias_producto (
   id_categoria INT AUTO_INCREMENT PRIMARY KEY,
   codigo_categorias VARCHAR(10) UNIQUE NOT NULL,
   nombre_categoria VARCHAR(100) NOT NULL,
 	-- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);


CREATE TABLE subcategorias_producto (
    id_subcategoria INT AUTO_INCREMENT PRIMARY KEY,
    codigo_subcategoria VARCHAR(10) UNIQUE NOT NULL,
    nombre_subcategoria VARCHAR(100) NOT NULL,
    descripcion TEXT,
    id_categoria INT NOT NULL,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categorias_producto(id_categoria)
);

-- Tabla de productos

CREATE TABLE productos (
    id_producto INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo_producto VARCHAR(20) NOT NULL UNIQUE,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion TEXT,
    url_imagen VARCHAR(255),
    unidad_medida VARCHAR(20) NOT NULL DEFAULT 'unidad',
    stock_actual INT UNSIGNED NOT NULL DEFAULT 0 CHECK (stock_actual >= 0),
    id_estado INT NOT NULL,  -- Estado del producto
    id_marca INT UNSIGNED NOT NULL,
    id_proveedor INT NOT NULL,
    id_categoria INT NOT NULL,
    id_subcategoria INT NOT NULL,
	  -- Campos de auditoria
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado),
    FOREIGN KEY (id_marca) REFERENCES marcas(id_marca),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (id_categoria) REFERENCES categorias_producto(id_categoria),
    FOREIGN KEY (id_subcategoria) REFERENCES subcategorias_producto(id_subcategoria)
);


-- Tabla de marcas
CREATE TABLE marcas (
    id_marca INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(100) NOT NULL UNIQUE,
    pais_origen VARCHAR(50),
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de proveedores
CREATE TABLE proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(100),
    contacto VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100),
	-- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla de compras
CREATE TABLE compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT,
    fecha DATETIME,
    total DECIMAL(10,2),
    id_usuario INT,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Tabla de detalle_compras
CREATE TABLE detalle_compras (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT,
    id_producto INT,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_compra) REFERENCES compras(id_compra),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de clientes
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL,
    direccion VARCHAR(150),
    celular VARCHAR(20),
    email VARCHAR(100),
    id_origen INT,
    id_tipo_documento INT,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_origen) REFERENCES origenes(id_origen),
    FOREIGN KEY (id_tipo_documento) REFERENCES tipo_documento(id_tipo_documento)
);

-- Tabla de origenes
CREATE TABLE origenes (
    id_origen INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);


-- Tabla de cotizacion
CREATE TABLE cotizaciones (
    id_cotizacion INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_usuario INT NOT NULL,
    fecha_emision DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_evento DATE NOT NULL,
    fecha_devolucion DATE NOT NULL,
    direccion_evento VARCHAR(200) NOT NULL,
    estado ENUM('pendiente', 'aceptada', 'rechazada') DEFAULT 'pendiente',
    total DECIMAL(10,2) DEFAULT 0.00,
    observaciones TEXT,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Tabla de detalle_cotizacion
CREATE TABLE detalle_cotizacion (
    id_detalle_cotizacion INT AUTO_INCREMENT PRIMARY KEY,
    id_cotizacion INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL, -- Se copia de precios_alquiler
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_cotizacion) REFERENCES cotizaciones(id_cotizacion),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);


-- Tabla de precios_alquiler
CREATE TABLE precios_alquiler (
    id_precio INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT NOT NULL,
    tipo_precio ENUM('venta', 'alquiler', 'mayorista') NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL CHECK (precio_unitario >= 0),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE DEFAULT NULL, -- Si es NULL, significa que está vigente
    id_estado INT NOT NULL,
	-- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de contrato
CREATE TABLE contratos (
    id_contrato INT AUTO_INCREMENT PRIMARY KEY,
    id_cotizacion INT UNIQUE,
    fecha_contrato DATETIME,
    fecha_entrega DATE,
    fecha_retorno DATE,
    id_usuario INT,
    garantia DECIMAL(10,2) DEFAULT 0.00,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_cotizacion) REFERENCES cotizaciones(id_cotizacion),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Tabla de factura
CREATE TABLE facturas (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_usuario INT NOT NULL, -- Usuario que la generó
    fecha_emision DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    tipo_comprobante ENUM('boleta', 'factura'),
    estado ENUM('emitida', 'anulada') DEFAULT 'emitida',
	id_medio INT,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_medio) REFERENCES medios_pago(id_medio)
);

-- Tabla de detalle_factura
CREATE TABLE detalle_factura (
    id_detalle_factura INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
	-- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_factura) REFERENCES facturas(id_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de control_retorno
CREATE TABLE control_retorno (
    id_control INT AUTO_INCREMENT PRIMARY KEY,
    id_contrato INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad_entregada INT NOT NULL,
    cantidad_devuelta INT NOT NULL,
    observaciones TEXT,
    fecha_retorno DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_usuario INT, -- usuario que registró la devolución
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_contrato) REFERENCES contratos(id_contrato),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Tabla de productos_perdidos
CREATE TABLE productos_perdidos (
    id_perdida INT AUTO_INCREMENT PRIMARY KEY,
    id_control INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad_perdida INT NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo TEXT, -- opcional: daño, extravío, etc.
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_control) REFERENCES control_retorno(id_control),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de medios_pago
CREATE TABLE medios_pago (
    id_medio INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL, -- Ej: Efectivo, Yape, Plin, Bancario
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL
);

-- Tabla pago
CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_contrato INT NOT NULL,
    id_medio INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
    observacion TEXT,
    -- Campos de auditoria
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_creacion VARCHAR(50) NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    usuario_actualizacion VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_contrato) REFERENCES contratos(id_contrato),
    FOREIGN KEY (id_medio) REFERENCES medios_pago(id_medio)
);

--
INSERT INTO tipo_documento (nombre, usuario_creacion, usuario_actualizacion)
VALUES
('DNI', 'admin', 'admin'),
('Carnet de Extranjeria', 'admin', 'admin'),
('Pasaporte', 'admin', 'admin'),
('RUC', 'admin', 'admin'),
('Conviviente', 'admin', 'admin');


INSERT INTO genero (nombre, usuario_creacion, usuario_actualizacion)
VALUES
('Masculino', 'admin', 'admin'),
('Femenino', 'admin', 'admin');


INSERT INTO estado_civil (nombre, usuario_creacion, usuario_actualizacion)
VALUES
('Soltero(a)', 'admin', 'admin'),
('Casado(a)', 'admin', 'admin'),
('Divorciado(a)', 'admin', 'admin'),
('Viudo(a)', 'admin', 'admin'),
('Conviviente', 'admin', 'admin');


INSERT INTO estado (nombre, usuario_creacion, usuario_actualizacion)
VALUES
('Activo', 'admin', 'admin'),
('Inactivo', 'admin', 'admin'),
('Suspendido', 'admin', 'admin'),
('Terminado', 'admin', 'admin');


INSERT INTO departamentos (nombre, descripcion, usuario_creacion, fecha_creacion, usuario_actualizacion, fecha_actualizacion)
VALUES
('Servicio', 'Área que atiende en eventos: mozos, barman, vigilancia y limpieza', 'admin', NOW(), 'admin', NOW()),
('Operaciones', 'Supervisa la producción y logística de eventos', 'admin', NOW(), 'admin', NOW()),
('Administrador', 'Tareas administrativas y gestión documental', 'admin', NOW(), 'admin', NOW()),
('Logística', 'Área responsable de transporte y distribución', 'admin', NOW(), 'admin', NOW()),
('Almacén', 'Área de almacenamiento y control de inventario', 'admin', NOW(), 'admin', NOW()),
('Ventas', 'Gestiona la atención a clientes, genera cotizaciones y contratos, coordina los servicios para eventos, y supervisa las ventas.', 'admin', NOW(), 'admin', NOW());



INSERT INTO cargos (nombre, descripcion, id_departamento, usuario_creacion, usuario_actualizacion)
VALUES
 -- Servicio (id_departamento = 1)
 ('Mozo', 'Atiende a los clientes durante el evento', 1, 'admin', 'admin'),
 ('Barman', 'Prepara y sirve bebidas', 1, 'admin', 'admin'),
 ('Vigilante', 'Encargado de la seguridad en eventos', 1, 'admin', 'admin'),
 ('Personal de Limpieza', 'Mantiene la limpieza durante y después de los eventos', 1, 'admin', 'admin'),
 -- Operaciones (id_departamento = 2)
 ('Jefe de Operaciones', 'Supervisa la producción y logística de la empresa', 2, 'admin', 'admin'),
 -- Administrador (id_departamento = 3)
 ('Administrador', 'Encargado de la gestión administrativa general', 3, 'admin', 'admin'),
 -- Logística (id_departamento = 4)
 ('Chofer', 'Conduce los vehículos para transporte de insumos y personal', 4, 'admin', 'admin'),
 ('Ayudante de Logística', 'Apoya en la carga, descarga y distribución', 4, 'admin', 'admin'),
-- Almacén (id_departamento = 5)
 ('Almacenero', 'Controla el ingreso y salida de productos e insumos', 5, 'admin', 'admin');
 
INSERT INTO usuarios (username, password_hash, nombres, apellidos, email,  id_estado,  usuario_creacion, usuario_actualizacion)
VALUES
('admin', SHA2('admin123', 256),'Carlos Eduardo', 'Cardenas Altuna','cardenasa@leboulevard.ca.com', 1,  'admin', 'admin'),
('joperaciones', SHA2('operaciones123', 256), 'Monica Soledad', 'Cordova Vildez','monci.cv@leboulevard.ca.com', 1, 'admin', 'admin'),
('almacenero', SHA2('almacen123', 256), 'Miriam', 'Altuna Ponce','almacen@leboulevard.ca.com', 1, 'admin', 'admin');

INSERT INTO roles (nombre, descripcion, usuario_creacion, usuario_actualizacion)
VALUES 
('Administrador', 'Control total del sistema y configuración general', 'admin', 'admin'),
('Jefe de Operaciones', 'Supervisa cotizaciones, proveedores y reportes','admin', 'admin'),
('Almacenero', 'Gestiona entregas, devoluciones y control de stock','admin', 'admin'),
('Vendedor', 'Atiende clientes, genera cotizaciones y registra alquileres', 'admin', 'admin');


INSERT INTO permisos (nombre, descripcion, usuario_creacion, usuario_actualizacion)
VALUES
('cotizaciones_crear', 'Permite crear nuevas cotizaciones',  'admin', 'admin'),
('cotizaciones_ver', 'Permite ver cotizaciones y sus detalles',  'admin', 'admin'),
('cotizaciones_exportar', 'Permite exportar cotizaciones a PDF o enviar por WhatsApp',  'admin', 'admin'),
('inventario_ver', 'Permite ver y listar productos', 'admin', 'admin'),
('inventario_editar', 'Permite agregar o editar productos y stock',  'admin', 'admin'),
('facturacion_crear', 'Permite emitir facturas',  'admin', 'admin'),
('clientes_crear', 'Permite registrar nuevos clientes',  'admin', 'admin'),
('reservas_gestionar', 'Permite aprobar o cancelar reservas',  'admin', 'admin'),
('dashboard_ver', 'Permite ver el dashboard con KPIs y gráficos',  'admin', 'admin'),
('administracion_usuarios', 'Permite gestionar usuarios, roles y contraseñas',  'admin', 'admin'),
('sincronizar_datos', 'Permite usar la función de sincronización de datos', 'admin', 'admin'),
('cerrar_sesion', 'Permite cerrar sesión del sistema',  'admin', 'admin');


-- Asignar permisos a roles
INSERT INTO roles_permisos (id_rol, id_permiso,usuario_creacion, usuario_actualizacion) VALUES
-- Administrador (id_rol = 1) tiene todos los permisos
(1, 1,'admin', 'admin'), (1, 2,'admin', 'admin'), (1, 3,'admin', 'admin'), (1, 4,'admin', 'admin'), (1, 5,'admin', 'admin'), (1, 6,'admin', 'admin'), (1, 7,'admin', 'admin'), (1, 8,'admin', 'admin'), (1, 9,'admin', 'admin'), (1, 10,'admin', 'admin'), (1, 11,'admin', 'admin'), (1, 12,'admin', 'admin');


INSERT INTO roles_permisos (id_rol, id_permiso,usuario_creacion, usuario_actualizacion) VALUES
-- Jefe de Operaciones (id_rol = 2) permisos relacionados a cotizaciones, reservas, reportes
(2, 1,'admin', 'admin'), (2, 2,'admin', 'admin'), (2, 3,'admin', 'admin'), (2, 8,'admin', 'admin'), (2, 9,'admin', 'admin');

INSERT INTO roles_permisos (id_rol, id_permiso,usuario_creacion, usuario_actualizacion) VALUES
-- Almacenero (id_rol = 3) permisos de inventario
(3, 4,'admin', 'admin'), (3, 5,'admin', 'admin'),

-- Vendedor (id_rol = 4) permisos de clientes, cotizaciones, facturación
(4, 1,'admin', 'admin'), (4, 2,'admin', 'admin'), (4, 6,'admin', 'admin'), (4, 7,'admin', 'admin');



-- Asignar el rol Administrador al usuario admin
INSERT INTO usuario_roles (id_usuario, id_rol, usuario_creacion, usuario_actualizacion)
VALUES (1, 1, 'admin', 'admin');

-- Asignar el rol Supervisor a juan
INSERT INTO usuario_roles (id_usuario, id_rol, usuario_creacion, usuario_actualizacion)
VALUES (2, 2, 'admin', 'admin');

-- Asignar 2 roles a un mismo usuario (admin es también supervisor)
INSERT INTO usuario_roles (id_usuario, id_rol, usuario_creacion, usuario_actualizacion)
VALUES (1, 2, 'admin', 'admin');




INSERT INTO empleados (
    id_tipo_documento, numero_documento, nombres, apellidos, fecha_nacimiento,
    id_genero, id_estado_civil, telefono, email_personal, email_corporativo,
    direccion, id_departamento, id_cargo, fecha_ingreso, salario,
    id_estado, id_usuario, usuario_creacion, usuario_actualizacion
) VALUES (
    1, '18130283', 'Carlos Eduardo', 'Cárdenas Altuna', '1973-07-15',
    1, 2, '960144175', 'norcad.sg@gmail.com', 'cardenasa@leboulevard.ca.com',
    'Urb. Villa Santa Maria Mz LL - Lt 3', 3, 6, '2000-01-15', 3500.00,
    1, 1, 'admin', 'admin'
),
(1, '03882099', 'Monica Soledad', 'Cordova Vilchez', '1973-05-01',
    2, 2, '977532253', 'monci.cv@gmail.com', 'monica.cv@leboulevard.ca.com',
    'Urb. Villa Santa Maria Mz LL - Lt 3', 2, 5, '2000-01-15', 3500.00,
    1, 2, 'admin', 'admin'
 ),   
(1, '41528741', 'José', 'Ramírez Soto', '1985-08-21',
 1, 1, '987654321', 'jose@gmail.com', 'jose@leboulevard.ca.com',
 'Av. Las Flores 123', 1, 2, '2010-03-10', 1025.00,
 1, 3, 'admin', 'admin'
 ),
 (1, '61287412', 'María Fernanda', 'Pérez Gómez', '1990-11-30',
 2, 1, '912345678', 'maria.perez@gmail.com', 'mperez@leboulevard.ca.com',
 'Jr. Los Cedros 456', 1, 4, '2015-06-25', 1025.00,
 1, NULL, 'admin', 'admin'
),
(1, '51287412', 'Leonardo', 'Lingán', '1990-11-30',
 2, 1, '998545678', 'leonardolingan@gmail.com', 'llingan@leboulevard.ca.com',
 'Jr. pizarro 456 - centro', 1, 1, '2015-06-25', 1025.00,
 1, NULL, 'admin', 'admin'
 ),
 (1, '41287412', 'Edward', 'Yupanqui', '1990-11-30',
 2, 1, '945845678', 'edwardyupanqui@gmail.com', 'eyupanqui@leboulevard.ca.com',
 'Jr. Bolivar 556 - centro', 1, 1, '2015-06-25', 1025.00,
 1, NULL, 'admin', 'admin'
 );
 

--
--
--

INSERT INTO categorias_producto (
    codigo_categoria,
    nombre_categoria,
    fecha_creacion,
    usuario_creacion,
    fecha_actualizacion,
    usuario_actualizacion
)
VALUES
('0100CR', 'Cristalería',              CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0200MN', 'Menaje',                   CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0300UB', 'Utensilios',               CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0400DC', 'Decoración',               CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0500VS', 'Vestuario',                CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0600SV', 'Servicios',                CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('0700CT', 'Catering',                 CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');


-- Cristalería
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('CR01', 'Copas', 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CR02', 'Vasos', 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CR03', 'Jarras', 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CR04', 'Hieleras', 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Menaje
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('MN01', 'Platos', 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('MN02', 'Cubiertos', 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('MN03', 'Servilletas', 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('MN04', 'Manteles', 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Utensilios 
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('UB01', 'Thermos', 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('UB02', 'Cafeteras eléctricas', 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('UB03', 'Dispensadores', 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('UB04', 'Cocteleras', 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Decoración
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('DC01', 'Candelabros', 4, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('DC02', 'Faroles', 4, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('DC03', 'Letreros', 4, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('DC04', 'Floreros', 4, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Vestuario
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('VS01', 'Camisas', 5, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('VS02', 'Chalecos', 5, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('VS03', 'Chaquetas', 5, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('VS04', 'Mandiles', 5, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Servicios
INSERT INTO subcategorias_producto (codigo_subcategoria, nombre_subcategoria, id_categoria, fecha_creacion, usuario_creacion, fecha_actualizacion, usuario_actualizacion)
VALUES
('SV01', 'Mozos', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('SV02', 'Bartender', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('SV03', 'Cocina y ayudante', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('SV04', 'Lavado', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('SV05', 'Limpieza', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('SV06', 'Vigilancia', 6, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

-- Catering
INSERT INTO subcategorias_producto VALUES
('CT01', 'Pollada', 7, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CT02', 'Parrilla', 7, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CT03', 'Caja china', 7, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('CT04', 'Buffet caliente/frío', 7, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

SELECT * FROM productos;