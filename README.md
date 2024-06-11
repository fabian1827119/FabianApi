# ApiJwt
Es una api donde se realiza lo siguiente:
<br>
<h4>Autenticacion por jwt</h4> 
<ul>
<li>Registro de usuarios.</li>
<li>Login de usuarios.</li>
</ul>

<h4>Usuarios</h4> 
<ul>
  <li>Se obtiene usuario por id.</li>
  <li>Se obtienen todos los usuarios.</li>
  <li>Actualiza usuario por id.</li>
  <li>Devuelve un mensage si estas autenticado por jwt.</li>
</ul>

<h4>Pokemon</h4> 
<ul>
  <li>Obtiene los datos de un pokemon por nombre.</li>
  <li>Obtiene mensajes de post por id.</li>
</ul>

<h4>Encriptar y desencrirtar</h4> 
<ul>
  <li>Encripta una cadena de texto usando el cifrado AES/CBC/PKCS5Padding implementando una llave publica y un vector de inicialización.</li>
  <li>Desencripta una cadena de texto usando el cifrado AES/CBC/PKCS5Padding implementando una llave publica y un vector de inicialización.</li>
</ul>

# Generar .jar e imagen docker
<ul>
  <li>Navegue al directorio del proyecto donde esta el archivo <code>pom.xml</code>:<code>cd your-repo></code>.</li>
  <li>Limpie y compile el proyecto con: <code>mvn clean package</code></li>
  <li>Contruye la imagen: <code>docker build -t apijwt .</code> </li>
  <li>Ejecuta la imagen: <code>docker run -it -p 8085:8085 apijwt</code></li>
  <li>Pruebe API Rest usando Postman u otra aplicación en <code>http://localhost:8085</code></li>
</ul>

# Colección Postman
Se agrega una coleccion de Postman con todas las peticiones.
* Navegue al siguiente directorio <code> src\main\resources\templates\ColeccionPostman </code>




