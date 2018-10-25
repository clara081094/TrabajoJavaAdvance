create database if not exists prueba;

use prueba;

create table categoria (
  id int primary key auto_increment,
  nombre varchar(50) not null
);

create table producto (
  id int primary key auto_increment,
  nombre varchar(100) not null,
  descripcion varchar(500) not null,
  categoria_id int not null,
  foreign key fk_producto_categoria (categoria_id) references categoria(id)
);

create table producto_sku (
  id int primary key auto_increment,
  producto_id int not null,
  activo char(1) not null default '1',
  precio decimal(10,2) not null default 0.0,
  cantidad int not null default 0,
  foreign key fk_producto_sku_producto (producto_id) references producto(id)
);

create table usuario (
  id int primary key auto_increment,
  correo_electronico varchar(100) not null,
  contrasena varchar(50) not null,
  nombre varchar(100) not null
);

create table venta (
  id int primary key auto_increment,
  usuario_id int not null,
  subtotal decimal(12,2) not null,
  impuestos decimal(12,2) not null,
  total decimal(12,2) not null,
  fecha_venta datetime not null,
  foreign key fk_venta_usuario(usuario_id) references usuario(id)
);

create table detalle_venta (
  id int primary key auto_increment,
  venta_id int not null,
  producto_sku_id int not null,
  precio_unitario decimal(10,2) not null,
  cantidad int not null,
  foreign key detalle_venta_venta (venta_id) references venta(id),
  foreign key detalle_venta_producto_sku (producto_sku_id) references producto_sku(id)
);

insert into categoria values
(null, 'Hogar'),
(null, 'Deportes'),
(null, 'Tecnología');

insert into producto values
(null, 'Imaco Freidora de Aire 2.6 Lts AF2614', 'Cuenta con una tecnología de convección de aire que utiliza hasta 80% menos aceite, perfecto para cuidar la salud. – Incluye un temporizador de 30 minutos con apagado automático al terminar el tiempo seleccionado. También podrás manejar las perillas de temperatura y timer y conrolar la temperatura hasta 200° C', 1),
(null, 'Samsung Refrigeradora RT29K5710S8 295 Lt Twin Cooling Plus', 'Capacidad de 295 litros- Dispensador de agua- Tecnología No Frost- Tecnología Multiflow- Sistema de enfriamiento Twin Cooling Plus- Bandejas de vidrio templado', 1),
(null, 'Muvo Caminadora Endurance 10', 'Área de trote: 40 x 120 cm- Velocidad máxima de 12 km/h- Escaneo de Velocidad / Tiempo / Distancia / Pulso / Calorías- 12 Programas de entrenamiento- 4 Programas de velocidad / 3 Posiciones de inclinación- Peso máximo permitido de 105 Kg', 2),
(null, 'Monark Elliptical Air Cross Trainer E1020', 'Sistema de resistencia: Por cadena - Niveles de resistencia: Fricción - Peso máximo Usuario (kg): 100 kilos - Información de consola: Mide velocidad, tiempo,distancia, calorías y ritmo cardiaco. - Ruedas de desplazamiento: Si - Asiento Ajustable - Condiciones de servicio de armado', 2),
(null, 'Advance Notebook 2 en 1 CN4046 10.1'' 32GB 2GB + Intense Devices Parlante Inalámbrico 6W', 'Advance Notebook 2 en 1 CN4046 10.1'' Intel Atom x5-Z8350 32GB 2GB:- Sistema operativo Windows 10 Home- Procesador Intel Atom x5-Z8350- Pantalla touch de 10.1'' con fondo WLED (1280x800)- Memoria interna de 32GB / Memoria RAM de 2GB DDR3- Puerto microUSBParlante Inalámbrico Intense Devices:- Potencia de salida de 6 watts- Frencuencia: 50 Hz - 20 KHz- Efectos de iluminación- Sintonizador de radio FM- Conectividad Bluetooth', 3),
(null, 'LG Smart TV 43" Full HD 43LK5700 ThinQ AI', '- Resolución Full HD de 1920 x 1080 píxeles

- Tecnología de imagen HDR

- Navegador ThinQ AI

- Modo Surround: Virtual Plus

- Conectividad WiFi / Bluetooth

- 2 Puertos HDMI / 1 Puertos USB', 3),
(null, 'LG Smart TV 65'' 4K UHD 65UK6350 ThinQ AI', '- Resolución 4K UHD de 3840 x 2160 píxeles

- Tecnología de imagen HDR

- Navegador ThinQ AI

- Decoficador de sonido DTS Virtual X

- Conectividad WiFi / Bluetooth

- 3 Puertos HDMI / 2 Puertos USB', 3);

select * from categoria;

select * from producto;

select * from producto_sku;

insert into producto_sku (producto_id, precio, cantidad) values
(1, 199.00, 10),
(2, 1399.00, 10),
(3, 1099.00, 10),
(4, 999.00, 10),
(5, 499.00, 10),
(6, 1699.00, 10),
(7, 3199.00, 10);
